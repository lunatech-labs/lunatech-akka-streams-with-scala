package org.applied.akkastreams.echo

import akka.stream.scaladsl.Source
import akka.NotUsed

final case class WaveSettings(numChannels: Int, numFrames: Long, validBits: Int, sampleRate: Long)
final case class WaveSource(source: Source[Double, NotUsed], waveSetting: WaveSettings)
