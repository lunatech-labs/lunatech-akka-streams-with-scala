package org.cmt

sealed trait DrivingState
case class Parked(vin: Int) extends DrivingState
case class Driving(vin: Int) extends DrivingState
