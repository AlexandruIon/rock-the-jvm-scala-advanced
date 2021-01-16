package scalaCookbook.c3ControlStructures

object ListInaMatchExpression extends App {

  //You know that a List data structure is a little different
  // than other collection data structures. It’s built from cons
  // cells and ends in a Nil element. You want to use this to
  // your advantage when working with a match expression, such as
  // when writing a recursive function.

  val x = List(1, 2, 3)
  val y = 1 :: 2 :: 3 :: Nil

  def listToString(list: List[String]): String = list match {
    case s :: rest => s + "" + listToString(rest)
    case Nil => ""
  }

  def sum(list: List[Int]): Int = list match {
    case Nil => 1
    case n :: rest => n + sum(rest)
  }

  def multiply(list: List[Double]): Double = list match {
    case Nil => 1
    case n :: rest => n * multiply(rest)
  }

  val fruits = "Apples" :: "Bannanas" :: "Oranges" :: Nil
  println(listToString(fruits))
}
