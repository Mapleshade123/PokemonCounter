ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

libraryDependencies += "com.lihaoyi" %% "requests" % "0.6.9"
libraryDependencies += "io.github.juliano" % "pokeapi-scala_3" % "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "project"
  )
