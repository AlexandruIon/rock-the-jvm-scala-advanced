package mine

object PartialFunctions extends App {

  //https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples/

  //You want to define a Scala function that will only work for a subset of possible input values, or you want to define
  //a series of functions that only work for a subset of input values, and combine those functions to completely solve a problem.

  //A partial function is a function that does not provide an answer for every possible input value it can be given.
  //It provides an answer only for a subset of possible data, and defines the data it can handle

  //“A partial function of type PartialFunction[A, B] is a unary function where the domain does not necessarily include
  //all values of type A. The function isDefinedAt allows [you] to test dynamically if a value is in the domain of the function.”

  val divide2 = (x: Int) => 42 / x

  //  divide(0) ArithmeticException

  println("------ partial function with explicit")
  val divide = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x != 0

    override def apply(v1: Int): Int = 42 / v1
  }

  assert(divide.isDefinedAt(1))
  println {
    if (divide.isDefinedAt(1)) divide(1)
  }
  println {
    divide.isDefinedAt(0)
  }

  // partial functions are often written using case statements
  println("----- partial function with case")
  val divide3: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }
  println(s" partial function - is defined at 0 = ${divide3.isDefinedAt(0)}")
  println(s" partial function - is defined at 1 = ${divide3.isDefinedAt(1)}")

  val convertLowNumTOString = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")

    override def isDefinedAt(x: Int): Boolean = x > 0 && x < 6

    override def apply(v1: Int): String = nums(v1 - 1)
  }

  //A terrific feature of partial functions is that you can chain them together.
  //orElse and andThen

  val convert1to5 = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")

    override def isDefinedAt(x: Int): Boolean = x > 0 && x < 6

    override def apply(v1: Int): String = nums(v1 - 1)
  }

  val convert6to10 = new PartialFunction[Int, String] {
    val nums = Array("six", "seven", "eight", "nine", "ten")

    override def isDefinedAt(x: Int): Boolean = x > 5 && x < 11

    override def apply(v1: Int): String = nums(v1 - 6)
  }

  val handle1to10 = convert1to5 orElse convert6to10
  println(s"convert 3 to string ${handle1to10(3)}")
  println(s"convert 8 to string ${handle1to10(8)}")

  // discussion
  // One example of where you’ll run into partial functions is with the collect method on collections’ classes.
  // The collect method takes a partial function as input, and as its Scaladoc describes, collect “Builds a new
  // collection by applying a partial function to all elements of this list on which the function is defined.”

  //  List(0, 1, 2) map {divide} => scala.MatchError: 0 (of class java.lang.Integer)
  val partialFunctionDivideList = List(0, 1, 2) collect {
    divide
  }
  println(s"partial function divide list $partialFunctionDivideList")
  //This is because the collect method is written to test the isDefinedAt method for each element it’s given

  //Because it checks the isDefinedAt method under the covers,
  // collect can handle the fact that your anonymous function can’t work with a String as input.
  val partialFunctionInt = List(42, "cat") collect { case i: Int => i + 1 }
  println(s"partial function int = $partialFunctionInt")


  val sample = 1 to 10
  var even: PartialFunction[Int, Int] = {
    case x: Int if x % 2 == 0 => x
  }

  val sampledEven = sample collect even
  println(s"only even elements in list $sampledEven")

  var odd: PartialFunction[Int, Int] = {
    case x: Int if x % 2 == 1 => x
  }

  val sampledOdd = sample collect odd
  println(s"only odd elements in list $sampledOdd")

  val sampleEvenAndOdd = sample map {
    even orElse odd
  }
  println(s"both even and odd $sampleEvenAndOdd")

}
