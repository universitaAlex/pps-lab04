ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
  .settings(
    name := "pps-lab04"
  )

libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.2" % Test