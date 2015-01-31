package myorg

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.HTMLCanvasElement
import doctus.scalajs.DoctusCanvasScalajs
import doctus.scalajs.DoctusSchedulerScalajs

@JSExport("Mydoctus")
object Mydoctus {

  @JSExport
  def main() {
    val canvasElem: HTMLCanvasElement = dom.document.getElementById("canvas").asInstanceOf[HTMLCanvasElement]

    val canvas = DoctusCanvasScalajs(canvasElem)
    val sched = DoctusSchedulerScalajs

    myorg.Controller(canvas, sched)
  }

}