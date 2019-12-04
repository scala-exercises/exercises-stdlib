val scalaExercisesV = "0.5.0-SNAPSHOT"

def dep(artifactId: String) =
  "org.scala-exercises" %% artifactId % scalaExercisesV excludeAll (ExclusionRule("io.monix"))

lazy val stdlib = (project in file("."))
  .enablePlugins(ExerciseCompilerPlugin)
  .settings(
    name := "exercises-stdlib",
    libraryDependencies ++= Seq(
      dep("exercise-compiler"),
      dep("definitions"),
      %%("shapeless", V.shapeless),
      %%("scalatest", V.scalatest),
      %%("scalacheck", V.scalacheck),
      "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % V.scalacheckShapeless,
      "org.scalatestplus"          %% "scalatestplus-scalacheck"  % V.scalatestplusScheck
    )
  )

// Distribution

pgpPassphrase := Some(getEnvVar("PGP_PASSPHRASE").getOrElse("").toCharArray)
pgpPublicRing := file(s"$gpgFolder/pubring.gpg")
pgpSecretRing := file(s"$gpgFolder/secring.gpg")
