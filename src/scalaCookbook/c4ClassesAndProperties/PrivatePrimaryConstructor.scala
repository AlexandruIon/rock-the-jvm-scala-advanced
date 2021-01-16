package scalaCookbook.c4ClassesAndProperties

object PrivatePrimaryConstructor extends App {

  //val p = new Person("Mercedes") this won`t compile

  //this won`t compile
  // val brain = new Brain

  //this works
  val brain = Brain.getInstance
  println(brain)

  //  A companion object is simply an object that’s defined in the same file as a class, where the object and class
  //  have the same name. If you declare a class named Foo in a file named Foo.scala, and then declare an
  //  object named Foo in that same file, the Foo object is the companion object for the Foo class.

  //  !!!! A companion object has several purposes, and one purpose is that any method declared in a companion
  //  object will appear to be a static method on the object
}

//You want to make the primary constructor of a class private, such as to enforce the Singleton pattern
//To make the primary constructor private, insert the private keyword in between the class name and any parameters the constructor accepts

//a private no-args primary constructor
class Order private {

}

//a private one-arg primary constructor
class Person2 private(name: String) {

}

//A simple way to enforce the Singleton pattern in Scala is to make the primary constructor private,
// then put a getInstance method in the companion object of the class:

class Brain private {
  override def toString = "This is the brain."
}

object Brain {
  val brain = new Brain

  def getInstance = brain
}