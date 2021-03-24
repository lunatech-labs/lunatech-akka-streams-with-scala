package org.applied.akkastreams

import akka.NotUsed
import akka.stream.FlowShape
import akka.stream.scaladsl.{Broadcast, Concat, Flow, GraphDSL, Source, Zip}
import org.applied.akkastreams.FIRElements.FirInitialZero
import org.applied.akkastreams.FilterElements.buildFIR

object IIRFLow {

  def apply(internalFir: Flow[Double, Double, NotUsed]) = {

    Flow.fromGraph(GraphDSL.create() { implicit b =>
      import GraphDSL.Implicits._

      val start = Source.single(0.0d)
      val concat = b.add(Concat[Double]())

      val zip = b.add(Zip[Double, Double]())
      val bcast = b.add(Broadcast[Double](2))
      val add = b.add(Flow[(Double, Double)].map { case (in, feedback) => in + feedback})

      // outside                         ~> zip.in0
      start            ~> concat         ~> zip.in1
      zip.out          ~> add            ~> bcast
      concat.in(1)     <~ internalFir    <~ bcast.out(0)
      // bcast.out(1)                    ~> outside

      FlowShape[Double, Double](zip.in0, bcast.out(1))
    })
  }

  def buildIIR(stages: Seq[FilterStage]): Flow[Double, Double, NotUsed] = {
    require(stages.nonEmpty, "There should be at least one stage in an IIR filter")
    require(stages.forall { case FilterStage(n, _) => n >= 1}, "A filter stage should have at least a delay of one")
    require(stages.head.delay >=1, "The first stage in an IIR filter should have at least a delay of two")

    val firstStage = stages.head
    val adaptedStages = FilterStage(firstStage.delay - 1, firstStage.coefficient) +: stages.tail
    apply(buildFIR(adaptedStages, FirInitialZero()))
  }
}
