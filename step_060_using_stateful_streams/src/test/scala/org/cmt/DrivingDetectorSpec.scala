package org.cmt

import org.scalatest.freespec.AnyFreeSpec
import org.applied.akkastreams.AkkaSpec
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Sink

class DrivingDetectorSpec extends AnyFreeSpec with AkkaSpec {

  "DrivingDetector" - {
    "should detect run detection logic accurately" in {
      val oneCar = List(
        Signal(1, Ignition, 1d),
        Signal(1, Velocity, 10d),
        Signal(1, Velocity, 0d),
        Signal(1, Ignition, 0d)
      )
      val result =
        Source(oneCar)
          .via(DrivingDetector.flow)
          .runWith(Sink.seq)
          .futureValue
      assert(
        result == Vector(
          Parked(1),
          Driving(1),
          Driving(1),
          Parked(1)
        )
      )
    }
  }
}
