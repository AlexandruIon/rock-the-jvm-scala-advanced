package mine

object HowToWriteFunctions extends App {

  //https://alvinalexander.com/scala/how-to-use-functions-as-variables-values-in-scala-fp/
  //https://alvinalexander.com/scala/fpbook/explaining-scala-val-function-syntax-functional-programming/
  val anInt = 1
  val anIntExplicit: Int = 2

  val f = (i: Int) => {    i % 2 == 0  }

  val f1: (Int) => Boolean = i => {    i % 2 == 0  }
  val f2: Int => Boolean = i => {    i % 2 == 0  }
  val f3: Int => Boolean = i => i % 2 == 0
  val f4: Int => Boolean = _ % 2 == 0

  ////

  //implicit approach
  val add = (x: Int, y: Int) => {    x + y  }
  val add2 = (x: Int, y: Int) => x + y

  //explicit approach
  val add3: (Int, Int) => Int = (x, y) => {    x + y  }
  val add4: (Int, Int) => Int = (x, y) => x + y


  // using a method like an anonymus function

  def modMethod(i: Int) = i % 2 == 0
  def modMethod2(i: Int)= { i % 2 == 0 }
  def modMethod3(i: Int): Boolean = i % 2 == 0
  def modMethod4(i: Int): Boolean = { i % 2 == 0 }

  val list = List.range(1, 10)
  list.filter(modMethod)


  val addNew = (i: Int) => i + 1  // implicit return type (IRT)
  val addNew2: Int => Int = i => i + 1  // explicit return type (ERT)

  val sum = (a: Int, b: Int) => a + b //implicit
  val sumNew: (Int, Int) => Int = (a, b) => a + b //explicit

}
