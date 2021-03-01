import sbt.Keys._
import sbt._
import sbtstudent.AdditionalSettings
import dotty.tools.sbtplugin.DottyPlugin.autoImport.DottyCompatModuleID

object CommonSettings {
  lazy val commonSettings = Seq(
    Compile / scalacOptions ++= CompileOptions.compileOptions,
    Compile / unmanagedSourceDirectories := List((scalaSource in Compile).value, (javaSource in Compile).value),
    Test / unmanagedSourceDirectories := List((scalaSource in Test).value, (javaSource in Test).value),
    Test / logBuffered := false,
    Test / parallelExecution := false,
    libraryDependencies ++= Dependencies.dependencies,
    libraryDependencies ++= Dependencies.scalaDependencies.map(_.withDottyCompat(scalaVersion.value)),
    testFrameworks += new TestFramework("munit.Framework")
  ) ++
    AdditionalSettings.initialCmdsConsole ++
    AdditionalSettings.initialCmdsTestConsole ++
    AdditionalSettings.cmdAliases

  lazy val configure: Project => Project = (project: Project) => {
    project.settings(CommonSettings.commonSettings: _*)
  }
}
