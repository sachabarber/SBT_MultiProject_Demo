  import sbt._
  import Keys._

object BuildSettings {


  val buildOrganization = "sas"
  val buildVersion      = "1.0"
  val buildScalaVersion = "2.11.5"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
    //shellPrompt  := ShellPrompt.buildShellPrompt
  )


}


// // Shell prompt which show the current project,
// // git branch and build version
// object ShellPrompt {
//   object devnull extends ProcessLogger {
//     def info (s: => String) {}
//     def error (s: => String) { }
//     def buffer[T] (f: => T): T = f
//   }
  

//   val buildShellPrompt = {
//     (state: State) => {
//       val currProject = Project.extract (state).currentProject.id
//       "%s:%s> ".format (
//         currProject,  BuildSettings.buildVersion
//       )
//     }
//   }
// }


object Dependencies {
//   val logbackVer = "0.9.16"
//   val grizzlyVer = "1.9.19"

//   val logbackcore    = "ch.qos.logback" % "logback-core"     % logbackVer
//   val logbackclassic = "ch.qos.logback" % "logback-classic"  % logbackVer

//   val jacksonjson = "org.codehaus.jackson" % "jackson-core-lgpl" % "1.7.2"

//   val grizzlyframwork = "com.sun.grizzly" % "grizzly-framework" % grizzlyVer
//   val grizzlyhttp     = "com.sun.grizzly" % "grizzly-http"      % grizzlyVer
//   val grizzlyrcm      = "com.sun.grizzly" % "grizzly-rcm"       % grizzlyVer
//   val grizzlyutils    = "com.sun.grizzly" % "grizzly-utils"     % grizzlyVer
//   val grizzlyportunif = "com.sun.grizzly" % "grizzly-portunif"  % grizzlyVer

//   val sleepycat = "com.sleepycat" % "je" % "4.0.92"

//   val apachenet   = "commons-net"   % "commons-net"   % "2.0"
//   val apachecodec = "commons-codec" % "commons-codec" % "1.4"

//   val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1" % "test"
}





object SachasSBTDemo extends Build {
  import Dependencies._
  import BuildSettings._

  // Sub-project specific dependencies
  val commonDeps = Seq (
  //   logbackcore,
  //   logbackclassic,
  //   jacksonjson,
  //   scalatest
  )

  val serverDeps = Seq (
  //   grizzlyframwork,
  //   grizzlyhttp,
  //   grizzlyrcm,
  //   grizzlyutils,
  //   grizzlyportunif,
  //   sleepycat,
  //   scalatest
  )


  lazy val demoApp = Project (
    "SachasSBTDemo-App",
    file ("SachasSBTDemo-App"),
    settings = buildSettings
  )
  //build these projects when main App project gets built
  .aggregate(common, server)
  .dependsOn(common, server)

  lazy val common = Project (
    "common",
    file ("SachasSBTDemo-Common"),
    settings = buildSettings ++ Seq (libraryDependencies ++= commonDeps)
  )

  lazy val server = Project (
    "server",
    file ("SachasSBTDemo-Server"),
    settings = buildSettings ++ Seq (libraryDependencies ++= serverDeps)
  ) dependsOn (common)
  
}