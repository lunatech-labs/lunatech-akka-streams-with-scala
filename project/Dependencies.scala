import sbt._

object Version {
  val logbackVer        = "1.2.3"
  val mUnitVer          = "0.7.22"
  val akkaVer           = "2.6.12"
  val scalaVersion      = "2.13.5"
  val scalaTestVer      = "3.2.5"
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

  private val scalaTestDeps = Seq(
    "org.scalatest"     %% "scalatest"  % Version.scalaTestVer % "test",
    "org.scalactic"     %% "scalactic"  % Version.scalaTestVer
  )

  val dependencies: Seq[ModuleID] =
    logbackDeps ++
    munitDeps

  val scalaDependencies: Seq[ModuleID] =
    akkaDeps ++
    scalaTestDeps
}
