package org.cmt

import akka.stream.Attributes
import akka.stream.scaladsl.{Source, SourceWithContext}
import akka.event.LoggingAdapter

object StreamLogExtensions {
  implicit class SourceLogExtension[T, M](val src: Source[T, M]) {
    def logInfo(name: String)(implicit log: LoggingAdapter) = {
      src.map { msg => 
        log.info(s"[$name] ${msg.toString}");msg
      }
    }
  }

  implicit class SourceWithContextLogExtension[T, C, M](val src: SourceWithContext[T, C, M]) {
    def logSWCInfo(name: String)(implicit log: LoggingAdapter): SourceWithContext[T, C, M] = {
      src.map { msg => 
        log.info(s"[$name] ${msg.toString}");msg
      }
    }
  }
}