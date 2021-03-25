package org.applied.akkastreams.substreams

import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Flow
import akka.NotUsed
import akka.stream.scaladsl.Sink
import scala.concurrent.duration._
import scala.concurrent.TimeoutException

object Substreams extends App {
  implicit val system: ActorSystem = ActorSystem()

  // Testdata: two vehicles both turn on ignition, drive a bit, stop, turn ignition off.
  Source(
    List(
      Signal(1, Ignition, 1d),
      Signal(1, Velocity, 10d),
      Signal(2, Ignition, 1d),
      Signal(2, Velocity, 10d),
      Signal(1, Velocity, 0d),
      Signal(1, Ignition, 0d),
      Signal(2, Velocity, 0d),
      Signal(2, Ignition, 0d)
    )
  ).via(
    DrivingDetector.flow
  ).runWith(
    Sink.foreach(println)
  )

  system.terminate()
}
