organization := "com.lightbend.lagom"

name := "lagom-service-locator-zookeeper"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"
scalacOptions += "-target:jvm-1.8"
val lagomVersion = "1.0.0-RC1"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

libraryDependencies ++= Seq(
  "com.lightbend.lagom" %% "lagom-javadsl-api"   % lagomVersion,
  "org.apache.curator"   % "curator-x-discovery" % "2.11.0",
  "org.apache.curator"   % "curator-test"        % "2.11.0" % Test,
  "org.scalatest"       %% "scalatest"           % "2.2.4" % Test
)