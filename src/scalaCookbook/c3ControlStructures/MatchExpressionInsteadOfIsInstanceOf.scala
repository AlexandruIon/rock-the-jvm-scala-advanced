package scalaCookbook.c3ControlStructures

object MatchExpressionInsteadOfIsInstanceOf extends App {

  // You want to write a block of code to match one type, or multiple different types.

  // You can use the isInstanceOf method to test the type of an object:
  val x = Foo("asd")
  if (x.isInstanceOf[Foo]) {

  }

  //  However, some programmers discourage this approach, and in other cases, it may not be convenient.
  //  In these instances, you can handle the different expected types in a match expression.


  def isPerson(x: Any): Boolean = x match {
    //    case p: Person1 => true
    case Person1(_) => true
    case _ => false
  }

  println(s"Is person: ${isPerson(Person1("alex"))}")

  //  Or you may be given an object that extends a known supertype, and then
  //  want to take different actions based on the exact subtype.

  trait SentientBeing

  trait Animal extends SentientBeing

  case class Dog(name: String) extends Animal

  case class Person(name: String, age: Int) extends SentientBeing

  def printInfo(x: SentientBeing) = x match {
    case Person(name, age) =>
    case Dog(name) =>
  }


  case class Foo(foo: String)

  case class Person1(name: String)

}
