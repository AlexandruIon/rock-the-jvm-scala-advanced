package lectures.part1as

//The Scala standard is that an unapply method returns the case class constructor fields in a
// tuple that’s wrapped in an Option. The “tuple” part of the solution was shown in the previous lesson.
object AdvancedPatternMatching extends App {

  val numbers = List(1)

  val description = numbers match {
    case head :: Nil => println(s"the only element is $head")
    case _ =>
  }

  /*
  -constants
  -wildcards
  -case classes
  -tuples
  -some special magic like above
   */

  // case classes decomposable through pattern matching.


  class Person(val name: String, val age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] =
      if (person.age < 21) None
      else
        Some((person.name, person.age))

    def unapply(age: Int): Option[String] = Some(if (age < 21) "minor" else "major")
  }

  val bob = new Person("Bob", 25)

  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a yo."
  }
  println {
    greeting
  }

  val legalStatus = bob.age match {
    case Person(status) => s"My legalstatus is $status"
  }
  println {
    legalStatus
  }

  /*
   Exercise
   */

  //  object even {
  //    def unapply(arg: Int): Option[Boolean] =
  //      if (arg % 2 == 0) Some(true) else None
  //  }

  object even {
    def unapply(arg: Int): Boolean =
      arg % 2 == 0
  }

  object singleDigit {
    def unapply(arg: Int): Boolean =
      arg < 10
  }

  val n: Int = 2
  val mathProperty = n match {
    case singleDigit() => "single digit"
    case even() => "an even number"
    case _ => "no property"
  }
  println {
    mathProperty
  }


  // infix patterns - works only when you have 2 things in the pattern

  case class Or[A, B](a: A, b: B) //either

  val either = Or(2, "two")
  val humanDescription = either match {
    case Or(number, string) => s"$number is written as $string"
    case number Or string => s"$number is written as $string"
  }

  println {
    humanDescription
  }

  // decomposing sequences
  val vararg = numbers match {
    case List(1, _*) => "starting with 1"
  }
  println {
    vararg
  }

  abstract class MyList[+A] {
    def head: A = ??? // unimplemented
    def tail: MyList[A] = ??? //unimplemented
  }

  case object Empty extends MyList[Nothing]

  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] =
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
  }

  val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val decomposed = myList match {
    case MyList(1, 2, _*) => "starting with 1,2"
    case _ => "something else"
  }
  println {
    decomposed
  }


  // custom return types for unapply

  // isEmpty: Boolean, get: something

  abstract class Wrapper[T] {
    def isEmpty: Boolean

    def get: T
  }

  object PersonWrapper {
    def unapply(person: Person): Wrapper[String] = {
      new Wrapper[String] {
        override def isEmpty: Boolean = false

        override def get: String = person.name
      }
    }
  }

  println(bob match {
    case PersonWrapper(n) => s"This person`s name is $n"
    case _ => "An Alien"
  })


}
