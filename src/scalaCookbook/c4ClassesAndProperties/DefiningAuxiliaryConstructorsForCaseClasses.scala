package scalaCookbook.c4ClassesAndProperties

object DefiningAuxiliaryConstructorsForCaseClasses extends App {

  val p = Person("John Smith", 30)
  //converted to
  val p2 = Person.apply("John Smith", 30)

  //This is a call to an apply method in the companion object of the Person class.
  // You don’t see this, you just see the line that you wrote, but this is how the
  // compiler translates your code. As a result, if you want to add new “constructors” to your case class,
  // you write new apply methods. (To be clear, the word “constructor” is used loosely here.)

  //  For instance, if you decide that you want to add auxiliary constructors to let you create new Person
  //  instances (a) without specifying any parameters, and (b) by only specifying their name, the solution is to add apply methods to the companion object of the Person case class


  val a = Person() // corresponds to apply()
  val b = Person("Pam") //corresponds to apply(name: String)
  val c = Person("William", 82)



  //A case class is a special type of class that generates a lot of boilerplate code for you.
  //Because of the way they work, adding what appears to be an auxiliary constructor to a case class is different
  //than adding an auxiliary constructor to a “regular” class. This is because they’re not really constructors:
  // they’re apply methods in the companion object of the class.


  //Parameters in the constructor of a case class differ from these rules in one way.
  // Case class constructor parameters are val by default.
  case class Person(var name: String, var age: Int)

  object Person {
    def apply() = new Person("<no name>", 0)

    def apply(name: String) = new Person(name, 0)
  }


}
