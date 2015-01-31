package myorg

import doctus.core._
import doctus.core.color._

case class WordPos(word: String, x: Double, y: Double, size: Double)

/**
 * In here comes the complete logic for your project
 */
case class Controller(canvas: DoctusCanvas, sched: DoctusScheduler) {

  val ran = new java.util.Random
  var words = {
    val mx = canvas.width / 2.0 - 80
    val my = canvas.height / 2.0
    val wordList = List("here", "comes", "your", "creativity")
    wordList.map(WordPos(_, mx, my, 50))
  }

  /**
   * Determines what method is called on repaint
   */
  canvas.onRepaint(paint)

  /**
   * Causes the canvas to call the paint method every 50 milliseconds
   */
  sched.start(canvas.repaint, 50)

  /**
   * Here comes your creativity.
   * This method is called every 50 milliseconds by the scheduler
   */
  def paint(g: DoctusGraphics) {
    val w = canvas.width
    val h = canvas.height

    def drawBackground(g: DoctusGraphics): Unit = {
      g.setColor(DoctusColorBlack, 30)
      g.fillRect(0, 0, w, h)
    }

    def drawWord(wp: WordPos): Unit = {
      g.setFontSize(wp.size)
      g.drawString(wp.word, wp.x, wp.y)
    }

    def next(l: WordPos): WordPos = {
      def adjX(v: Double, max: Int): Double =
        if (v < -100) -100 else if (v > max + 20) max + 20 else v
      def adjY(v: Double, max: Int): Double =
        if (v < -10) -10 else if (v > max - 100) max - 100 else v
      def adjSize(v: Double): Double =
        if (v < 20) 20 else if (v > 200) 200 else v
      val d1 = ran.nextInt(23) - 11
      val d2 = ran.nextInt(17) - 8
      val d3 = ran.nextInt(7) - 3
      WordPos(l.word, adjX(l.x + d1, w), adjY(l.y + d2, h), adjSize(l.size + d3))
    }

    drawBackground(g)
    g.setColor(DoctusColorWhite)
    words = words.map(next)
    words.foreach(drawWord)
  }

}

