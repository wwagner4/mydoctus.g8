package $organization$

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JPanel

import doctus.swing._

object $name;format="Camel"$Swing extends App {

  val top = new JFrame()
  val panel = DoctusComponentFactory.component

  val canvas = DoctusCanvasSwing(panel)
  val sched = DoctusSchedulerSwing

  val cp = new JPanel
  cp.setLayout(new BorderLayout)
  cp.add(panel, BorderLayout.CENTER)

  top.setContentPane(cp)
  top.setTitle("$name;format="Camel"$")
  top.setSize(new Dimension(900, 700))
  top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  top.setVisible(true)

  Controller(canvas, sched)

}

