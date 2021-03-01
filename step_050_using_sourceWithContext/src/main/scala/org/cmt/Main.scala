package org.cmt

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source, SourceWithContext}
import org.cmt.StreamLogExtensions._
import org.slf4j.{ LoggerFactory}

import java.util.UUID
import scala.util.Random

object Main:

  def extractContext[Data, Ctx](element: (Data, Ctx)): Ctx = element._2
  def extractData[Data, Ctx](element: (Data, Ctx)): Data = element._1
  
  def main(args:Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("akka-stream-system")
    import system.dispatcher

    implicit val logger = LoggerFactory.getLogger(getClass)

    val sourceIds = Source.fromIterator(() => Iterator.continually(UUID.randomUUID()))
    val data = Source.fromIterator(() => Iterator.continually(Random.nextInt(1000)))
    val inputValues = sourceIds.zip(data)
    val st = inputValues
        .zipWithIndex
        .take(10)
        .logInfo("Elements Sourced")
        .asSourceWithContext(extractContext).map(extractData)
        .map((key, n) => (key, n * 2)) // "Business Logic"
        .logSWCInfo("Elements Inside")
        .asSource
        .logInfo("Elements Processed")
        .runWith(Sink.ignore)

    Thread.sleep(500)         // Give async logging some time to do its stuff
    st.onComplete(_ => system.terminate())

  }