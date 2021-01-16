package scalaCookbook.c4ClassesAndProperties

object HandlingConstructorParametersWhenExtendingAClass extends App {


  //You want to extend a base class, and need to work with the constructor parameters declared in
  // the base class, as well as new parameters in the subclass.

  //Declare your base class as usual with val or var constructor parameters. When defining a subclass
  // constructor, leave the val or var declaration off of the fields that are common to both classes.
  // Then define new constructor parameters in the subclass as val or var fields, as usual.

  class Person(var name: String, var address: Address) {
    override def toString: String = if (address == null) name else s"$name @ $address"
  }

  case class Address(city: String, state: String)

  class Employee(name: String, address: Address, var age: Int) extends Person(name, address)

  //This raises the question, if you define an Employee class that extends Person, how should you handle the name
  //and address fields in the Employee constructor? Assuming Employee adds no new parameters, there are at least two main choices:

  //this is correct
  class Employee2(name: String, address: Address) extends Person(name, address)

}
