ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.1"

lazy val root = (project in file("."))
  .settings(
    name := "Markdown2Flash",
    libraryDependencies += "com.lihaoyi" %%% "os-lib" % "0.9.1"
  )
enablePlugins(ScalaNativePlugin)
