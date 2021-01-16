package scalaCookbook.c5Methods

object MethodsThatTakeVariableArgFields extends App {

  //varargs field.

  def printAll(strings: String*): Unit = {
    strings.foreach(println)
  }

  //############# Use _* to adapt a sequence

  // you can use Scala’s _* operator to adapt a sequence (Array, List, Seq, Vector, etc.)
  // so it can be used as an argument for a varargs field:
  //This operator tells the compiler to pass each element of the sequence to printAll as a
  // separate argument, instead of passing fruits as a single argument.


  // a sequence of strings
  var fruits = List("apple", "banana", "cherry")

  //pass the sequence to the varargs field
  printAll(fruits: _*)

}
