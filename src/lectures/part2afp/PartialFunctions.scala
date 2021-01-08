package lectures.part2afp

object PartialFunctions extends App {

  // whole fnction cause any int can be passed to the function and return a result
  val aFunction = (x: Int) => x + 1 // Function1[Int,Int] === Int => Int
  val sum: (Int, Int) => Int = (a, b) => a + b // ??????WTF

  // we want certain parts of the Int domain
  val aFussyFunction = (x: Int) =>
    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 999
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  }
  //{1,2,4} => Int  - parital function because is a subset of the Int Domain

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  } // partial function value

  //  val

}


