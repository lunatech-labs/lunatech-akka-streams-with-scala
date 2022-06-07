import sbt._
import sbt.Keys._

object CommonSettings {
  lazy val commonSettings = Seq(
    Compile / scalacOptions ++= CompileOptions.compileOptions,
    Test / logBuffered := false,
    Test / parallelExecution := false,
    libraryDependencies ++= Dependencies.dependencies,
    libraryDependencies ++= Dependencies.scalaDependencies.map(_.cross(CrossVersion.for3Use2_13)),
  ) 
}
