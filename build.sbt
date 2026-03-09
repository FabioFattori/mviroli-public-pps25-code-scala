scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "pps-code-scala",
    libraryDependencies ++= Seq(
      "org.junit.jupiter" % "junit-jupiter-api" % "6.0.3" % Test,
      "org.junit.jupiter" % "junit-jupiter-params" % "6.0.3" % Test,
      "com.github.sbt" % "junit-interface" % "0.13.3" % Test)
  )