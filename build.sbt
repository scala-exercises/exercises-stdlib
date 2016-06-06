lazy val stdlib = (project in file("."))
.enablePlugins(ExerciseCompilerPlugin)
.settings(
  organization := "org.scalaexercises",
  name            := "content-stdlib",
  scalaVersion := "2.11.7",
  version := "0.0.0-SNAPSHOT",
  resolvers ++= Seq(
    Resolver.sonatypeRepo("snapshots")
  ),
  libraryDependencies ++= Seq(
    "com.chuusai" %% "shapeless" % "2.2.5",
    "org.scalatest" %% "scalatest" % "2.2.4",
    "org.scalaexercises" %% "runtime" % "0.0.0-SNAPSHOT" changing(),
    "org.scalaexercises" %% "definitions" % "0.0.0-SNAPSHOT" changing(),
    "org.scalacheck" %% "scalacheck" % "1.12.5",
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.12" % "0.3.1"
  )
)
