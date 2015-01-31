import sbt._
import Keys._
import sbt.Package.ManifestAttributes
import com.typesafe.sbteclipse.plugin.EclipsePlugin._
import com.typesafe.sbteclipse.core.Validation
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseTransformerFactory

import scala.scalajs.sbtplugin._
import ScalaJSPlugin._
import ScalaJSKeys._

object MydoctusBuild extends Build {

  // Constant values
  object D {

    val version = "1.0-SNAPSHOT"

    val scalaVersion = "2.11.4"
    val doctusVersion = "1.0.3-SNAPSHOT"

  }

  // Settings
  object S {

    lazy val commonSettings =
        Seq(
          version := D.version,
          scalaVersion := D.scalaVersion,
          organization := "myorg",
          libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test")

    lazy val coreSettings =
      commonSettings ++
        scalaJSBuildSettings ++
        Seq(
          libraryDependencies += "net.entelijan" %%% "doctus-core" % D.doctusVersion,
          libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2")

    lazy val swingSettings =
      commonSettings ++
        Seq(
          fork := true,
          libraryDependencies += "net.entelijan" %% "doctus-swing" % D.doctusVersion)

    lazy val scalajsSettings =
      commonSettings ++
        scalaJSBuildSettings ++
        Seq(
          libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-dom" % "0.6",
          libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-jquery" % "0.6",
          libraryDependencies += "net.entelijan" %%% "doctus-scalajs" % D.doctusVersion)

  }

  // Project definitions
  lazy val root = Project(id = "mydoctus-root",
    base = file("."), //
    settings = S.commonSettings).aggregate(core, swing, scalajs)

  lazy val core = Project(
    id = "mydoctus-core",
    base = file("mydoctus-core"), // 
    settings = S.coreSettings)

  lazy val swing = Project(
    id = "mydoctus-swing",
    base = file("mydoctus-swing"),
    settings = S.swingSettings //
    ).dependsOn(core)

  lazy val scalajs = Project(
    id = "mydoctus-scalajs",
    base = file("mydoctus-scalajs"),
    settings = S.scalajsSettings //
    ).dependsOn(core)

}

