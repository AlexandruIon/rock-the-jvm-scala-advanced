package scalaCookbook.c3ControlStructures

import scala.annotation.tailrec

object CreateYourOwnControlStructures extends App {

  //You want to define your own control structures to improve the Scala language, simplify your own code, or create a DSL for others to use.

  var i = 0
  whilst(1 < 5) {
    println(i)
    i += 1
  }

  // 1st attempt
  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
    while (testCondition) {
      codeBlock
    }
  }

  //2nd attepmt
  @tailrec
  def whilst2(testCondition: => Boolean)(codeBlock: => Unit) {
    if (testCondition) {
      codeBlock
      whilst2(testCondition)(codeBlock)
    }
  }
}
