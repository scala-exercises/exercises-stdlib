import com.jsuereth.sbtpgp.PgpKeys.publishSigned

ThisBuild / organization       := "org.scala-exercises"
ThisBuild / githubOrganization := "47degrees"
ThisBuild / scalaVersion       := "2.13.8"

// Required to prevent errors for eviction from binary incompatible dependency
// resolutions.
// See also: https://github.com/scala-exercises/exercises-cats/pull/267
ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

ThisBuild / resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

// This is required by the exercises compiler:
publishLocal  := (publishLocal dependsOn compile).value
publishSigned := (publishSigned dependsOn compile).value

addCommandAlias("ci-test", "scalafmtCheckAll; scalafmtSbtCheck; test")
addCommandAlias("ci-docs", "github; documentation/mdoc; headerCreateAll")
addCommandAlias("ci-publish", "github; ci-release")

lazy val exercises = (project in file("."))
  .settings(name := "exercises-stdlib")
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-exercises"        %% "exercise-compiler"         % "0.7.1+14-b94ba7a2-SNAPSHOT",
      "org.scala-exercises"        %% "definitions"               % "0.7.1+14-b94ba7a2-SNAPSHOT",
      "com.chuusai"                %% "shapeless"                 % "2.3.7",
      "org.scalatest"              %% "scalatest"                 % "3.2.11",
      "org.scalacheck"             %% "scalacheck"                % "1.15.4",
      "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0",
      "org.scalatestplus"          %% "scalacheck-1-15"           % "3.2.9.0" % Test
    )
  )
  .enablePlugins(ExerciseCompilerPlugin)

lazy val documentation = project
  .settings(mdocOut := file("."))
  .settings(publish / skip := true)
  .enablePlugins(MdocPlugin)
