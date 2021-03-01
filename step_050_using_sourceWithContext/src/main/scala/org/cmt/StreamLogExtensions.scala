package org.cmt

import akka.stream.Attributes
import akka.stream.scaladsl.{Source, SourceWithContext}
import org.slf4j.Logger

object StreamLogExtensions {
  extension [T, M](src: Source[T, M])
    def logInfo(name: String)(implicit logger: Logger) = {
      src.map { msg => 
        logger.info(s"[$name] ${msg.toString}");msg
    }
  }

  extension [T, C, M](src: SourceWithContext[T, C, M])
    def logSWCInfo(name: String)(implicit logger: Logger): SourceWithContext[T, C, M] = {
      src.map { msg => 
        logger.info(s"[$name] ${msg.toString}");msg
    }
  }
}
