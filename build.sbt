/***************************************************************
  *      THIS IS A GENERATED FILE - EDIT AT YOUR OWN RISK      *
  **************************************************************
  *
  * Use the mainadm command to generate a new version of
  * this build file.
  *
  * See https://github.com/lightbend/course-management-tools
  * for more details
  *
  */

import sbt._

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val `akka-streams-master` = (project in file("."))
  .aggregate(
    common,
    `step_050_using_sourceWithContext`,
    `step_055_flow_from_source_and_sink`,
    `step_060_using_stateful_streams`,
    `step_061_using_substreams`,
    `step_070_using_scan`,
    `step_080_implement_a_delay_element`,
    `step_090_implement_fir_manually`,
    `step_100_implement_fir_streamlined`,
    `step_110_implement_iir_set_stage`,
    `step_111_implement_iir`,
    `step_120_chain_fir_and_fir`,
    `step_130_chain_iir_and_fir_cancel_echo`,
    `step_140_check_diff`,
    `step_150_vco`,
    `step_160_matching_streams_speeds`
  )
  .settings(CommonSettings.commonSettings: _*)

lazy val common = project
  .settings(CommonSettings.commonSettings: _*)

lazy val `step_050_using_sourceWithContext` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_055_flow_from_source_and_sink` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_060_using_stateful_streams` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_061_using_substreams` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_070_using_scan` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_080_implement_a_delay_element` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_090_implement_fir_manually` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_100_implement_fir_streamlined` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_110_implement_iir_set_stage` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_111_implement_iir` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_120_chain_fir_and_fir` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_130_chain_iir_and_fir_cancel_echo` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_140_check_diff` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_150_vco` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_160_matching_streams_speeds` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")
       