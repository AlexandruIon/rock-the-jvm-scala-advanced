package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 65 //expression

  //instructions vs expressions
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  //Unit ==void

  val theUnit = println("hello, scala")


  def aFunction(x: Int): Int = x + 1

  //recursion: stack and tail
  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if (n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  //object-oriented programming
  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog //subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //natural language

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  //generics
  abstract class MyList[+A]

  //singletons and companions
  object MyList

  //case classes
  case class Person(name: String, age: Int)

  //exceptions and try/catch/finally
  val throwsException = throw new RuntimeException //expression // type Nothing
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("some logs")
  }

  //packaging and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1
  List(1, 2, 3).map(anonymousIncrementer) // HOF

  //for-comprehension -> chain of maps flat maps
  val pair = for {
    num <- List(1, 2, 3) // if condition
    char <- List('a', 'b', 'b')
  } yield num + "-" + char

  // scala collections
  val aMap = Map("Alex" -> 789, "Jess" -> 555)

  // "collections" abstract computations Options, Try
  val anOption = Some(2)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(name, _) => s"Hi, my name is $name"
  }

}




























