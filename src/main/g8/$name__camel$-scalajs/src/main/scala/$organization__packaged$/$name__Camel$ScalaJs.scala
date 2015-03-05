package $organization$

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLCanvasElement
import doctus.scalajs.DoctusCanvasScalajs
import doctus.scalajs.DoctusSchedulerScalajs

@JSExport("$name;format="Camel"$ScalaJs")
object $name;format="Camel"$ScalaJs {

  @JSExport
  def main() {
    val canvasElem: HTMLCanvasElement = dom.document.getElementById("canvas").asInstanceOf[HTMLCanvasElement]

    val canvas = DoctusCanvasScalajs(canvasElem)
    val sched = DoctusSchedulerScalajs
    val pointable = DoctusPointableScalajs(canvasElem)

    $organization$.Controller(canvas, sched, pointable)
  }

}