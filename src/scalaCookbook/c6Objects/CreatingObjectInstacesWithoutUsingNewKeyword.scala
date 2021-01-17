package scalaCookbook.c6Objects

object CreatingObjectInstacesWithoutUsingNewKeyword extends App {

  //There are two ways to do this:
  //
  //    Create a companion object for your class, and define an apply method in the companion object with the desired constructor signature.
  //
  //    Define your class as a case class.

  val dawn = Person("dawn")
  val dawn2 = Person.apply("dawn2") // factory method
  val a = Array(Person("Dan"), Person("Elijah"))

  class Person {
    var name: String = _
  }

  object Person {
    def apply(name: String): Person = {
      val p = new Person
      p.name = name
      p
    }
  }


  val as = Animal()
  val b = Animal("Al")
  val c = Animal("William Shatner", 82)

  case class Animal(var name: String, var age: Int)

  //define two auxiliary constructors
  object Animal {
    def apply() = new Animal("<no name>", 0)

    def apply(name: String) = new Animal(name, 0)
  }

}
