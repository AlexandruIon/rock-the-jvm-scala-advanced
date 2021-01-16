package scalaCookbook.c4ClassesAndProperties

object WhenToUseAnAbstractClass extends App {

  //  Scala has traits, and a trait is more flexible than an abstract class, so you wonder,
  //  “When should I use an abstract class?”


  //  There are two main reasons to use an abstract class in Scala:

  //  1. You want to create a base class that requires constructor arguments.

  //  2. The code will be called from Java code.

  // this won`t compile
  //  trait Animal(name: String)

  //use an abstract class whenever a base behavior must have constructor parameters:
  abstract class Animal(name: String)


  //Regarding the second reason, if you’re writing code that needs to be accessed from Java, you’ll find that
  // Scala traits with implemented methods can’t be called from Java code.

  //  To declare that a method is abstract, just leave the body of the method undefined:

  //def speak // no body makes the method abstract
}


