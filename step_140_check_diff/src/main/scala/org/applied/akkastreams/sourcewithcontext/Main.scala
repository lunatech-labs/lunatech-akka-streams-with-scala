package org.applied.akkastreams.sourcewithcontext

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source, SourceWithContext}
import StreamLogExtensions._
import org.slf4j.{ LoggerFactory}

import java.util.UUID
import scala.util.Random

object Main {

  final case class Data(i: Int, d: Double)

  def extractContext[Data, Ctx](element: (Data, Ctx)): Ctx = element._2
  def extractData[Data, Ctx](element: (Data, Ctx)): Data = element._1

  /**
   * A source data based on tuples of two values:
   *   - the first one, an Int between 0 and 999,
   *   - the second one a Double between 0.0d and 100000.0d
   */
  val dataSource: Source[Data, NotUsed] = {
    val scale = 100000
    val sourceOfInts = Source.fromIterator(() => Iterator.continually(Random.nextInt(1000)))
    val sourceOfDouble = Source.fromIterator(() => Iterator.continually(Random.nextInt(scale + 1)/scale.toDouble))
    sourceOfInts.zip(sourceOfDouble).map{ case (i, d) => Data(i, d)}
  }

  /**
   * A source of some context data modelled as a series of randomly generated UUIDs
   */
  val contextSource: Source[UUID, NotUsed] =
    Source.fromIterator(() => Iterator.continually(UUID.randomUUID()))

  /**
   * A source of data & context
   */
  val sourceDataWithContext: Source[(Data, UUID), NotUsed] = dataSource.zip(contextSource)


  /**
    * We demonstrate `asSourceWithContext` which expects elements to consist of tuples
    * where the first element contains data and the second element contains some
    * context (metadata)
    * 
    * Using `asSourceWithContext` allows us to 'ship' the context transparently (read
    * invisible to the core data processing part of the stream processing) and
    * to put it 'back' after the data processing is complete.
    *
    */
  def main(args:Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("akka-stream-system")
    implicit val loggingAdapter = system.log
    import system.dispatcher

    implicit val logger = LoggerFactory.getLogger(getClass)

    /**
      * Some extremely sophisticated business logic
      *
      * @param i: A business Integer value
      * @param d: Some business Double value
      * @return (i, d + i)
      */
    def myBusinessLogic(data: Data): Data = data.copy(d = data.i + data.d)

    val st = sourceDataWithContext
        .take(10)
        .logInfo("Elements Sourced")
        .asSourceWithContext(extractContext).map(extractData)
        .map(myBusinessLogic) // Execute "Business Logic"
        .logSWCInfo("Elements Inside")
        .asSource                                   // Restore context info
        .logInfo("Elements Processed")
        .runWith(Sink.ignore)

    Thread.sleep(500)         // Give async logging some time to do its stuff
    st.onComplete(_ => system.terminate())

  }
}