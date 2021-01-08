package lectures.part1as

import java.io.{File, PrintWriter}
import scala.util.Try

object DarkSugars extends App {

  //######### syntax sugar #1: methods with single param ###########################


  //One way in which you can make the client code look a bit more like a built-in control structure is to use
  //curly braces instead of parentheses to surround the argument list. In any method invocation in Scala in
  //which you're passing in exactly one argument, you can opt to use curly braces to surround the argument
  //instead of parentheses. PiS - 9.4 WRITING NEW CONTROL STRUCTURES
  def singleArgMethod(arg: Int): String = s"$arg little ducks ...."

  val description = singleArgMethod {
    // write some complex code
    42
  }

  // it`s in fact apply method of Try
  val aTryInstance = Try { // java`s try {..}
    throw new RuntimeException
  }

  List(1, 2, 3).map {
    x => x + 1
  }

  println {
    "yolo"
  }

  def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  //  This technique is called the loan pattern
  withPrintWriter(new File("date.txt"), writer => writer.println(new java.util.Date))

  def withPrintWriterCurry(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  //The purpose of this ability to substitute curly braces for parentheses for passing in one argument is to
  //enable client programmers to write function literals between curly braces
  withPrintWriterCurry(new File("date.txt")) {
    writer => writer.println(new java.util.Date)
  }

  //######## syntax sugar #2: single abstract method ##############################

  //https://stackoverflow.com/questions/22820352/scala-single-method-interface-implementation
  //will allow a function type to be used where an instance of a
  //class or trait declaring a single abstract method (SAM) is required
  //31.5 JAVA 8 INTEGRATION IN SCALA 2.12
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

  // example : Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello, scala")
  })

  val aFunkyThread = new Thread(() => println("hello, scala"))

  abstract class AnAbstractType {
    def implementer: Int = 23

    def f(a: Int): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")


  //######## syntax sugar #3: the :: and #:: methods are special########################

  val prependedList = 2 :: List(2, 3) // List(2,3).::(2) -> right associative
  // scala spec: last char decides associativity of method
  1 :: 2 :: 3 :: List(4, 5)
  List(4, 5).::(3).::(2).::(1) // equivalent

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this //actial implementaiton here
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]


  //############### syntax sugar #4: multi-word method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is so sweet"

  //############### syntax sugar #5: infix types
  class Composite[A, B]

  val composite: Composite[Int, String] = ???
  val composite2: Int Composite String = ???

  class -->[A, B]

  val towards: Int --> String = ???

  //############### syntax sugar #6: update() is very special, much like apply()

  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // rewritten to anArray.update(2,7)
  // used in mutalbe collections

  //############### syntax sugar #7: setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member: Int = internalMember //"getter"
    def member_=(value: Int): Unit = internalMember = value //"setter"
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritten as aMutableContainer.member_=42
}
