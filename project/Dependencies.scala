import sbt._

object Version {
  val logbackVer        = "1.2.3"
  val mUnitVer          = "0.7.22"
  val akkaVer           = "2.6.12"
  val scalaVersion      = "3.0.0-RC1"
}

object Dependencies {

  private val logbackDeps = Seq (
    "ch.qos.logback"                 %  "logback-classic",
  ).map (_ % Version.logbackVer)

  private val munitDeps = Seq(
    "org.scalameta" %% "munit" % Version.mUnitVer % Test
  )
  
  private val akkaDeps = Seq(
    "com.typesafe.akka" %% "akka-stream" % Version.akkaVer,
    "com.typesafe.akka" %% "akka-stream-testkit" % Version.akkaVer,
    "com.typesafe.akka" %% "akka-actor" % Version.akkaVer,
  )

  val dependencies: Seq[ModuleID] =
    logbackDeps ++
    munitDeps

  val scalaDependencies: Seq[ModuleID] =
    akkaDeps
}
