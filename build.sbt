name := """SlickTest"""

version := "1.0"

scalaVersion := "2.11.6"

// Change this to another test framework if you prefer

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.h2database" % "h2" % "1.0.60"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

