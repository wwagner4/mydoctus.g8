package $organization$

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLCanvasElement
import doctus.scalajs._
import doctus.core.template._

@JSExport("$name;format="Camel"$ScalaJs")
object $name;format="Camel"$ScalaJs {

  @JSExport
  def main() {
    
    val canvasElem: HTMLCanvasElement = dom.document.getElementById("canvas").asInstanceOf[HTMLCanvasElement]

    val canvas = DoctusTemplateCanvasScalajs(canvasElem)
    val sched = DoctusSchedulerScalajs

    // Common to all platforms
    val templ = $organization$.$name;format="Camel"$DoctusTemplate(canvas)
    DoctusTemplateControllerImpl(templ, sched, canvas)

    
  }

}