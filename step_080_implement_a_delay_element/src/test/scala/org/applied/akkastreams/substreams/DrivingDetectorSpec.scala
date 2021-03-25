package org.applied.akkastreams.substreams

import org.scalatest.freespec.AnyFreeSpec
import org.applied.akkastreams.echo.AkkaSpec
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Sink

class DrivingDetectorSpec extends AnyFreeSpec with AkkaSpec {

  "DrivingDetector" - {
    "should detect run detection logic separately between cars" in {
      val twoCars = List(
        Signal(1, Ignition, 1d),
        Signal(1, Velocity, 10d),
        Signal(2, Ignition, 1d),
        Signal(2, Velocity, 10d),
        Signal(1, Velocity, 0d),
        Signal(1, Ignition, 0d),
        Signal(2, Velocity, 0d),
        Signal(2, Ignition, 0d)
      )
      val result =
        Source(twoCars)
          .via(DrivingDetector.flow)
          .runWith(Sink.seq)
          .futureValue
      assert(
        result == Vector(
          Parked(1),
          Driving(1),
          Parked(2),
          Driving(2),
          Driving(1),
          Parked(1),
          Driving(2),
          Parked(2)
        )
      )
    }
  }
}
