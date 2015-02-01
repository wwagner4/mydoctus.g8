package $organization$

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.HTMLCanvasElement
import doctus.scalajs.DoctusCanvasScalajs
import doctus.scalajs.DoctusSchedulerScalajs

@JSExport("$name__Camel$ScalaJs")
object $name__Camel$ScalaJs {

  @JSExport
  def main() {
    val canvasElem: HTMLCanvasElement = dom.document.getElementById("canvas").asInstanceOf[HTMLCanvasElement]

    val canvas = DoctusCanvasScalajs(canvasElem)
    val sched = DoctusSchedulerScalajs

    $organization$.Controller(canvas, sched)
  }

}