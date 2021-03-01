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

lazy val `dotty-master` = (project in file("."))
  .aggregate(
    `step_050_using_sourceWithContext`,
    `step_060_using_using_substreams`
  )
  .settings(ThisBuild / scalaVersion := Version.scalaVersion)
  .settings(CommonSettings.commonSettings: _*)

lazy val `step_050_using_sourceWithContext` = project
  .configure(CommonSettings.configure)

lazy val `step_060_using_using_substreams` = project
  .configure(CommonSettings.configure)
       