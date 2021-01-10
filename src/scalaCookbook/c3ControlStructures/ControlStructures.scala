package scalaCookbook.c3ControlStructures

import scala.annotation.switch
import scala.util.control.Breaks.{break, breakable}

object ControlStructures extends App {

  //The try/catch/finally structure is similar to Java, though Scala uses pattern matching in the catch clause

  //An important lesson from the for loop examples is that when you use the for/yield combination with a collection,
  // you’re building and returning a new collection, but when you use a for loop without yield, you’re just operating
  // on each element in the collection—you’re not creating a new collection. The for/yield combination is referred to
  // as a for comprehension, and in its basic use, it works just like the map method

  val a = Array("Apple", "banana", "orange")

  for (e <- a) println(e)

  for (e <- a) {
    val s = e.toUpperCase
    println(s)
  }

  val newArray = for (e <- a) yield e.toUpperCase
  println(newArray)

  //When your algorithm requires multiple lines of code, perform the work in a block after the yield keyword:
  val newArray2 = for (e <- a) yield {
    val s = e.toUpperCase
    s
  }
  println(newArray2)

  //  for loop counters
  for (i <- 0 until a.length) {
    println(s"$i is ${a(i)}")
  }
  //Scala collections also offer a zipWithIndex method that you can use to create a loop counter:
  for ((e, count) <- a.zipWithIndex) {
    println(s"$count is $e")
  }

  for (i <- 1 to 3) println(i)

  //Looping over a Map

  val names = Map("fname" -> "Robert", "lname" -> "Goren")
  for ((k, v) <- names) println(s"key: $k, value: $v")

  /*
   ################################### Using for Loops with Multiple Counters
   */

  //Ranges created with the <- symbol in for loops are referred to as generators,
  for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")
  for {i <- 1 to 2
       j <- 1 to 2
       } println(s"i = $i, j=$j")

  /*
 ################################### Using a for Loop with Embedded if Statements (Guards)
 */
  //These if statements are referred to as filters, filter expressions, or guards,
  for {i <- 1 to 10
       if i % 2 == 0
       } println(i)

  /*
 ################################### Creating a for Comprehension (for/yield Combination)
 */

  //Use a yield statement with a for loop and your algorithm to create a new collection from an existing collection.
  //Except for rare occasions, the collection type returned by a for comprehension is the same type that you begin with.

  /*
 ################################### Implementing break and continue
 */

  //You have a situation where you need to use a break or continue construct, but Scala doesn’t have break or continue keywords.

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break // break out of the for loop
    }
  }
  //In this case, when i becomes greater than 4, the break “keyword” is reached. At this point an exception is thrown,
  // and the for loop is exited. The breakable “keyword” essentially catches the exception, and the flow of control
  // continues with any other code that might be after the breakable block.

  //Note that break and breakable aren’t actually keywords; they’re methods in scala.util.control.Breaks.

  // to implement a break in scala

  //  breakable {
  //    for (x <- xs) {
  //      if (cond)
  //        break
  //    }
  //  }

  // to implement continue in scala

  //  for (x <- xs) {
  //    breakable {
  //      if (cond)
  //        break
  //    }
  //  }


  import scala.util.control._

  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")
          if (i == 2 && j == 'b') Outer.break
        }
      }
    }
  }


  /*
 ################################### Using a Match Expression Like a switch Statement
 */

  val i = 2
  val month = i match {
    case 1 => "January"
    case 2 => "February"
    case 3 => "March"
    case 4 => "April"
    case 5 => "May"
    case 6 => "June"
    case 7 => "July"
    case 8 => "August"
    case 9 => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _ => "Invalid month" // the default, catch-all
  }

  //The @switch annotation
  //When writing simple match expressions like this, it’s recommend to use the @switch annotation. This annotation
  // provides a warning at compile time if the switch can’t be compiled to a tableswitch or lookupswitch.
  //
  //Compiling your match expression to a tableswitch or lookupswitch is better for performance, because it results
  // in a branch table rather than a decision tree. When a value is given to the expression, it can jump directly
  // to the result rather than working through the decision tree.

  val x = (i: @switch) match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }

  //  So unless you’re intentionally writing a partial function, you’ll want to handle the default case.


  /*
################################### Matching Multiple Conditions with One Case Statement
*/


  // Scala is an “expression-oriented programming (EOP) language,”
  val evenOrOdd = i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
    case _ => println("doing nothing")
  }


}
