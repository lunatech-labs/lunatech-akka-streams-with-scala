package org.applied.akkastreams.substreams

import scala.concurrent.duration._
import scala.concurrent.TimeoutException
import akka.stream.scaladsl.Flow
import akka.NotUsed
import akka.stream.scaladsl.Source

object DrivingDetector {
  val flow: Flow[Signal, DrivingState, NotUsed] =
    Flow[Signal]
      .groupBy(
        maxSubstreams = 10,
        f = _.vin,
        allowClosedSubstreamRecreation = true
      )
      .statefulMapConcat { () =>
        var driving = false

        { signal =>
          signal.signalType match {
            case Ignition => if (driving && signal.value == 0) driving = false
            case Velocity => if (!driving && signal.value > 0) driving = true
          }
          Seq(
            if (driving) Driving(signal.vin)
            else Parked(signal.vin)
          )
        }
      }
      .idleTimeout(5.minutes)
      .recoverWithRetries(1, { case _: TimeoutException => Source.empty })
      .mergeSubstreams

}
