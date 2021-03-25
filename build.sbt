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
    `step_000_using_sourceWithContext`,
    `step_001_flow_from_source_and_sink`,
    `step_002_using_stateful_streams`,
    `step_003_using_substreams`,
    `step_004_using_scan`,
    `step_005_implement_a_delay_element`,
    `step_006_implement_fir_manually`,
    `step_007_implement_fir_streamlined`,
    `step_008_implement_iir_set_stage`,
    `step_009_implement_iir`,
    `step_010_chain_fir_and_fir`,
    `step_011_chain_iir_and_fir_cancel_echo`,
    `step_012_check_diff`,
    `step_013_vco`,
    `step_014_matching_streams_speeds`
  )
  .settings(ThisBuild / scalaVersion := Version.scalaVersion)
  .settings(CommonSettings.commonSettings: _*)

lazy val common = project
  .settings(CommonSettings.commonSettings: _*)

lazy val `step_000_using_sourceWithContext` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_001_flow_from_source_and_sink` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_002_using_stateful_streams` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_003_using_substreams` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_004_using_scan` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_005_implement_a_delay_element` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_006_implement_fir_manually` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_007_implement_fir_streamlined` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_008_implement_iir_set_stage` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_009_implement_iir` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_010_chain_fir_and_fir` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_011_chain_iir_and_fir_cancel_echo` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_012_check_diff` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_013_vco` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")

lazy val `step_014_matching_streams_speeds` = project
  .configure(CommonSettings.configure)
  .dependsOn(common % "test->test;compile->compile")
       