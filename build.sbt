sbtPlugin := true

organization := "com.bmdsoftware"
licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
//publishMavenStyle := true
publishArtifact in Test := false
publishTo := {
  val nexus = "https://dev.bmd-software.com/nexus/"
  if (isSnapshot.value)
    Some("Public (Snapshots)" at nexus + "content/repositories/snapshots")
  else
    Some("Public (Releases)" at nexus + "content/repositories/releases")
}
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

name := "sbt-rjs"

version := "1.0.9"

scalaVersion := "2.10.6"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "org.webjars" % "rjs" % "2.3.5"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.2.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.3")

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
