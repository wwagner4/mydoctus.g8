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

    val scalaVersion = "2.11.8"
    val doctusVersion = "1.0.5"
    val utestVersion = "0.4.1"
    val scalaJsDomJqueryVersion = "0.9.0"

  }

  // Settings
  object S {

    lazy val commonSettings =
        Seq(
          version := D.version,
          scalaVersion := D.scalaVersion,
          organization := "$organization$",
          resolvers += Resolver.bintrayRepo("wwagner4", "maven"),
          EclipseKeys.withSource := true)

    lazy val coreSettings =
      commonSettings ++
        Seq(
          libraryDependencies += "net.entelijan" %%% "doctus-core" % D.doctusVersion,
          libraryDependencies += "com.lihaoyi" %%% "utest" % D.utestVersion % "test")

    lazy val swingSettings =
      commonSettings ++
        Seq(
          fork := true,
          libraryDependencies += "net.entelijan" %% "doctus-swing" % D.doctusVersion,
          libraryDependencies += "com.lihaoyi" %%% "utest" % D.utestVersion % "test",
          testFrameworks += new TestFramework("utest.runner.Framework"))

    lazy val scalajsSettings =
      commonSettings ++
        Seq(
          jsDependencies += RuntimeDOM,
          libraryDependencies += "org.scala-js" %%% "scalajs-dom" % D.scalaJsDomJqueryVersion,
          libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % D.scalaJsDomJqueryVersion,
          libraryDependencies += "com.lihaoyi" %%% "utest" % D.utestVersion % "test",
          libraryDependencies += "net.entelijan" %%% "doctus-scalajs" % D.doctusVersion
//          testFrameworks += new TestFramework("utest.runner.Framework")
          )

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

