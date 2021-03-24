package org.applied.akkastreams

import akka.stream.scaladsl.Flow

object FIRElements {
  object FirInitial {
    def apply() = {
      Flow.fromFunction[Double, (Double, Double)] { sample =>
        (sample, sample)
      }
    }
  }

  object FirSelectOut {
    def apply() = {
      Flow.fromFunction[(Double, Double), Double] { case (_, out) => out}
    }
  }

  object FirInitialZero {
    def apply() = {
      Flow.fromFunction[Double, (Double, Double)] { sample =>
        (sample, 0.0d)
      }
    }
  }
}
