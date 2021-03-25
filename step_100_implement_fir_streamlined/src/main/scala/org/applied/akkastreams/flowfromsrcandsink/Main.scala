package org.applied.akkastreams.flowfromsrcandsink

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, Source}

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Main extends App {

  implicit val system: ActorSystem = ActorSystem()
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val fSource = Source.tick(1.second, 1.second, 1)
  val (queue, fSink) = Sink.queue[String]().preMaterialize()

  val flow = Flow.fromSinkAndSource(fSink, fSource)

  val running = Source.tick(3.second, 3.second, "Hello").via(flow).runForeach(println)

  printValue(queue.pull())

  def printValue(f: Future[Option[String]]): Unit = {
    f.onComplete {
      case Success(value) => println(value)
        printValue(queue.pull())
      case Failure(ex) => println(ex.toString)
    }
  }
}
