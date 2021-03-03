package org.cmt

import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Flow
import akka.NotUsed
import akka.stream.scaladsl.Sink
import scala.concurrent.duration._
import scala.concurrent.TimeoutException

sealed trait SignalType
case object Velocity extends SignalType
case object Ignition extends SignalType

case class Signal(vin: Int, signalType: SignalType, value: Double)

sealed trait State {
  def update(signal: Signal): State
}

case class DrivingState(vin: Int) extends State {
  def update(signal: Signal): State =
    signal.signalType match {
      case Ignition if signal.value == 0 => ParkedState(vin)
      case _                             => this
    }
}

case class ParkedState(vin: Int) extends State {
  def update(signal: Signal): State =
    signal.signalType match {
      case Velocity if signal.value > 0 => DrivingState(vin)
      case _                            => this
    }
}

object Scan extends App {
  implicit val system: ActorSystem = ActorSystem()

  // test data:
  // - car 1 stays parked
  // - car 2 is going for a (short) drive
  val source = Source(
    List(
      Signal(1, Ignition, 0d),
      Signal(2, Ignition, 1d),
      Signal(2, Velocity, 10d),
      Signal(2, Velocity, 0d),
      Signal(2, Ignition, 0d)
    )
  )

  val detector = Flow[Signal]
    .groupBy(
      maxSubstreams = 10,
      f = _.vin,
      allowClosedSubstreamRecreation = true
    )
    .scan((Option.empty[State])) {
      case (None, signal)        => Some(ParkedState(signal.vin).update(signal))
      case (Some(state), signal) => Some(state.update(signal))
    }
    .collect { case Some(state) => state }
    .idleTimeout(5.minutes)
    .recoverWithRetries(1, { case _: TimeoutException => Source.empty })
    .mergeSubstreams

  source.via(detector).runWith(Sink.foreach(println))
  system.terminate()
}
