package scalaCookbook.c4ClassesAndProperties

object DefiningPropertiesInAnAbstractBaseClassOrTrait extends App {

  //You want to define abstract or concrete properties in an
  // abstract base class (or trait) that can be referenced in all child classes.

  //  You can declare both val and var fields in an abstract class (or trait), and
  //  those fields can be abstract or have concrete implementations


  // 1 . Abstract val and var fields

  abstract class Pet(name: String) {
    val greeting: String
    var age: Int

    def sayHello() {
      println(greeting)
    }

    override def toString: String = s"I say $greeting, and I`m $age"
  }

  class Dog(name: String) extends Pet(name) {
    override val greeting: String = "woff"
    override var age: Int = 10
  }

  class Cat(name: String) extends Pet(name) {
    override val greeting: String = "Meow"
    override var age: Int = 5
  }

  val dog = new Dog("Fido")
  val cat = new Cat("Morris")

  dog.sayHello()
  cat.sayHello()

  println(dog)
  println(cat)

  // verify that age can be changed
  cat.age = 20
  println(cat)

}
