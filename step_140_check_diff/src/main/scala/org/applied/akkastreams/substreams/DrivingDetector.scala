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
      .scan(Option.empty[DrivingState]) {
        case (_, Signal(vin, Ignition, value)) if value == 0 =>
          Some(Parked(vin))
        case (_, Signal(vin, Velocity, value)) if value > 0 =>
          Some(Driving(vin))
        case (None, Signal(vin, _, _)) =>
          Some(Parked(vin))
        case (drivingState, _) =>
          drivingState
      }
      .collect { case Some(drivingState) => drivingState }
      .idleTimeout(5.minutes)
      .recoverWithRetries(1, { case _: TimeoutException => Source.empty })
      .mergeSubstreams
}
