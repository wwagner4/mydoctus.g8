package $organization$

import java.awt.Dimension
import doctus.swing.DoctusActivatableSwing
import doctus.swing.DoctusCanvasSwing
import doctus.swing.DoctusSchedulerSwing
import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.BorderLayout
import doctus.core.DoctusClickable
import java.util.Date
import java.text.SimpleDateFormat
import java.io.File
import java.io.PrintWriter
import javax.swing.JButton
import doctus.swing.DoctusClickableSwing
import java.awt.FlowLayout
import doctus.swing.DoctusComponentFactory

object $name;format="Camel"$Swing extends App {

  val top = new JFrame()
  val panel = DoctusComponentFactory.component

  val canvas = DoctusCanvasSwing(panel)
  val sched = DoctusSchedulerSwing

  val cp = new JPanel
  cp.setLayout(new BorderLayout)
  cp.add(panel, BorderLayout.CENTER)

  top.setContentPane(cp)
  top.setTitle("$name__Camel$")
  top.setSize(new Dimension(900, 700))
  top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  top.setVisible(true)

  Controller(canvas, sched)

}

