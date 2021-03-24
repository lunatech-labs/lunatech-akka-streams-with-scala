package org.cmt

import akka.stream.scaladsl.Flow
import akka.NotUsed

object DrivingDetector {
  val flow: Flow[Signal, DrivingState, NotUsed] =
    Flow[Signal].statefulMapConcat { () =>
      var driving = false

      { signal =>
        signal.signalType match {
          case Ignition => if (driving && signal.value == 0) driving = false
          case Velocity => if (!driving && signal.value > 0) driving = true
        }
        Seq(
          if (driving) Driving(signal.vin) else Parked(signal.vin)
        )
      }
    }
}
