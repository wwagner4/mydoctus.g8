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
          libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test",
          resolvers += "entelijan" at "http://entelijan.net/artifactory/repo",
          EclipseKeys.withSource := true)

    lazy val coreSettings =
      commonSettings ++
        Seq(
          libraryDependencies += "net.entelijan" %%% "doctus-core" % D.doctusVersion)

    lazy val swingSettings =
      commonSettings ++
        Seq(
          fork := true,
          libraryDependencies += "net.entelijan" %% "doctus-swing" % D.doctusVersion)

    lazy val scalajsSettings =
      commonSettings ++
        Seq(
          jsDependencies += RuntimeDOM,
          libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0",
          libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
          libraryDependencies += "net.entelijan" %%% "doctus-scalajs" % D.doctusVersion)

  }

  // Project definitions
  lazy val root = Project(id = "$name;format="camel"$-root",
    base = file("."), //
    settings = S.commonSettings).aggregate(core, swing, scalajs)

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

