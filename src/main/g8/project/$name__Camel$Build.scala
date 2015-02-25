import sbt._
import Keys._
import sbt.Package.ManifestAttributes
import com.typesafe.sbteclipse.plugin.EclipsePlugin._

import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object $name;format="Camel"$Build extends Build {

  // Constant values
  object D {

    val version = "$version$"

    val scalaVersion = "$scala_version_major$.$scala_version_minor$"
    val doctusVersion = "1.0.4-SNAPSHOT"

  }

  // Settings
  object S {

    lazy val commonSettings =
        Seq(
          version := D.version,
          scalaVersion := D.scalaVersion,
          organization := "$organization$",
          resolvers += "entelijan" at "http://entelijan.net/artifactory/repo",
          EclipseKeys.withSource := true)

    lazy val coreSettings =
      commonSettings ++
        Seq(
          libraryDependencies += "net.entelijan" %%% "doctus-core" % D.doctusVersion,
          libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0" % "test",
          testFrameworks += new TestFramework("utest.runner.Framework"))

    lazy val swingSettings =
      commonSettings ++
        Seq(
          fork := true,
          libraryDependencies += "net.entelijan" %% "doctus-swing" % D.doctusVersion,
          libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test")

    lazy val scalajsSettings =
      commonSettings ++
        Seq(
          jsDependencies += RuntimeDOM,
          libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0",
          libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
          libraryDependencies += "org.scala-js" %% "scalajs-library" % "0.6.0", 
          libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0" % "test",
          libraryDependencies += "net.entelijan" %%% "doctus-scalajs" % D.doctusVersion,
          testFrameworks += new TestFramework("utest.runner.Framework"))

  }

  // Project definitions
  lazy val root = Project(
    id = "$name;format="camel"$-root",
    base = file("."), 
    settings = S.commonSettings)
    .aggregate(core, swing, scalajs)

  lazy val core = Project(
    id = "$name;format="camel"$-core",
    base = file("$name;format="camel"$-core"),
    settings = S.coreSettings)
    .enablePlugins(ScalaJSPlugin)

  lazy val swing = Project(
    id = "$name;format="camel"$-swing",
    base = file("$name;format="camel"$-swing"),
    settings = S.swingSettings)
	  .dependsOn(core)

  lazy val scalajs = Project(
    id = "$name;format="camel"$-scalajs",
    base = file("$name;format="camel"$-scalajs"),
    settings = S.scalajsSettings)
	  .dependsOn(core)
    .enablePlugins(ScalaJSPlugin)

}

