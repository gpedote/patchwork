name := "patchwork"

version := "1.0"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.apache.spark"  %% "spark-core" % "1.6.2",
  "org.apache.spark"  %% "spark-mllib" % "1.6.2",
  "org.apache.spark"  %% "spark-sql" % "1.6.2",
  "org.apache.commons" % "commons-math3" % "3.5",
  "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test",
  "com.github.scopt" %% "scopt" % "3.5.0")

scalariformSettings

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

resolvers += Resolver.sonatypeRepo("public")

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

import sbtassembly.AssemblyPlugin.autoImport._

test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList("javax", "xml", xs @ _*)         => MergeStrategy.first
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*)         => MergeStrategy.last
  case PathList("com", "google", xs @ _*)         => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
