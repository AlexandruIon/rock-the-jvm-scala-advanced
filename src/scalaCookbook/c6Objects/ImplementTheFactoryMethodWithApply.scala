package scalaCookbook.c6Objects

object ImplementTheFactoryMethodWithApply extends App {

  //To let subclasses declare which type of object should be created,
  // and to keep the object creation point in one location, you want to implement the factory method in Scala.

  //Rather than creating a “get” method for your factory, you can place the factory’s decision-making algorithm in the apply method.


  val cat = Animal("cat") // returns a Cat
  val dog = Animal("dog") // returns a Dog

  trait Animal {
    def speak
  }

  object Animal {

    private class Dog extends Animal {
      override def speak: Unit = println("woof")
    }

    private class Cat extends Animal {
      override def speak: Unit = println("meow")
    }

    // the factory method
    def apply(s: String): Animal = {
      if (s == "dog") new Dog else new Cat
    }
  }

}
