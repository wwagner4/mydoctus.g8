package $organization$

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JPanel
import doctus.swing._
import doctus.core.template._

object $name;format="Camel"$Swing extends App {

  val top = new JFrame()
  val panel = DoctusComponentFactory.component()

  val canvas = DoctusTemplateCanvasSwing(panel)
  val sched = DoctusSchedulerSwing

  val cp = new JPanel
  cp.setLayout(new BorderLayout)
  cp.add(panel, BorderLayout.CENTER)

  top.setContentPane(cp)
  top.setTitle("$name;format="Camel"$")
  top.setSize(new Dimension(900, 700))
  top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  top.setVisible(true)

  // Common to all platforms
  val templ = $name;format="Camel"$DoctusTemplate(canvas)
  DoctusTemplateController(templ, sched, canvas)

}

