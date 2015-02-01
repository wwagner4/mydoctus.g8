import sbt._
import Keys._
import sbt.Package.ManifestAttributes
import com.typesafe.sbteclipse.plugin.EclipsePlugin._
import com.typesafe.sbteclipse.core.Validation
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseTransformerFactory

import scala.scalajs.sbtplugin._
import ScalaJSPlugin._
import ScalaJSKeys._

object $name__Camel$Build extends Build {

  // Constant values
  object D {

    val version = "$version$"

    val scalaVersion = "$scala_version$"
    val doctusVersion = "$doctus_version$"

  }

  // Settings
  object S {

    lazy val commonSettings =
        Seq(
          version := D.version,
          scalaVersion := D.scalaVersion,
          organization := "$organization$",
          libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test")

    lazy val coreSettings =
      commonSettings ++
        scalaJSBuildSettings ++
        Seq(
          libraryDependencies += "net.entelijan" %%% "doctus-core" % D.doctusVersion)

    lazy val swingSettings =
      commonSettings ++
        Seq(
          fork := true,
          libraryDependencies += "net.entelijan" %% "doctus-swing" % D.doctusVersion)

    lazy val scalajsSettings =
      commonSettings ++
        scalaJSBuildSettings ++
        Seq(
          libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-dom" % "$scalajs-dom_version$",
          libraryDependencies += "org.scala-lang.modules.scalajs" %%% "scalajs-jquery" % "$scalajs-jquery_version$",
          libraryDependencies += "net.entelijan" %%% "doctus-scalajs" % D.doctusVersion)

  }

  // Project definitions
  lazy val root = Project(id = "$name__camel$-root",
    base = file("."), //
    settings = S.commonSettings).aggregate(core, swing, scalajs)

  lazy val core = Project(
    id = "$name__camel$-core",
    base = file("$name__camel$-core"), // 
    settings = S.coreSettings)

  lazy val swing = Project(
    id = "$name__camel$-swing",
    base = file("$name__camel$-swing"),
    settings = S.swingSettings //
    ).dependsOn(core)

  lazy val scalajs = Project(
    id = "$name__camel$-scalajs",
    base = file("$name__camel$-scalajs"),
    settings = S.scalajsSettings //
    ).dependsOn(core)

}

