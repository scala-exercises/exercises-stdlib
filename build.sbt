lazy val stdlib = (project in file("."))
.settings(publishSettings:_*)
.enablePlugins(ExerciseCompilerPlugin)
.settings(
  organization := "org.scala-exercises",
  name         := "exercises-stdlib",
  scalaVersion := "2.11.7",
  version := "0.2.2-SNAPSHOT",
  resolvers ++= Seq(
    Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases")
  ),
  libraryDependencies ++= Seq(
    "com.chuusai" %% "shapeless" % "2.2.5",
    "org.scalatest" %% "scalatest" % "2.2.4",
    "org.scala-exercises" %% "exercise-compiler" % version.value,
    "org.scala-exercises" %% "definitions" % version.value,
    "org.scalacheck" %% "scalacheck" % "1.12.5",
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.12" % "0.3.1"
  ),
  licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
)


// Distribution

lazy val gpgFolder = sys.env.getOrElse("SE_GPG_FOLDER", ".")

lazy val publishSettings = Seq(
  organizationName := "Scala Exercises",
  organizationHomepage := Some(new URL("http://scala-exercises.org")),
  startYear := Some(2016),
  description := "Scala Exercises: The path to enlightenment",
  homepage := Some(url("http://scala-exercises.org")),
  pgpPassphrase := Some(sys.env.getOrElse("SE_GPG_PASSPHRASE", "").toCharArray),
  pgpPublicRing := file(s"$gpgFolder/pubring.gpg"),
  pgpSecretRing := file(s"$gpgFolder/secring.gpg"),
  credentials += Credentials("Sonatype Nexus Repository Manager",  "oss.sonatype.org",  sys.env.getOrElse("PUBLISH_USERNAME", ""),  sys.env.getOrElse("PUBLISH_PASSWORD", "")),
  scmInfo := Some(ScmInfo(url("https://github.com/scala-exercises/exercises-stdlib"), "https://github.com/scala-exercises/exercises-stdlib.git")),
  licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := Function.const(false),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("Snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("Releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
      <developers>
        <developer>
          <id>raulraja</id>
          <name>Raul Raja</name>
          <email>raul@47deg.com</email>
        </developer>
        <developer>
          <id>dialelo</id>
          <name>Alejandro Gómez</name>
          <email>al.g.g@47deg.com</email>
        </developer>
        <developer>
          <id>rafaparadela</id>
          <name>Rafa Paradela</name>
          <email>rafa.p@47deg.com</email>
        </developer>
        <developer>
          <id>MasseGuillaume</id>
          <name>Guillaume Massé</name>
          <email>masgui@gmail.com</email>
        </developer>
      </developers>
)
