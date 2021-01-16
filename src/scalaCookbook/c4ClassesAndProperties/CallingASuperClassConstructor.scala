package scalaCookbook.c4ClassesAndProperties

object CallingASuperClassConstructor extends App {

  //You want to control the superclass constructor that’s called when you create constructors in a subclass.


  //  This is a bit of a trick question, because you can control the superclass constructor that’s called by
  //  the primary constructor in a subclass, but you can’t control the superclass constructor that’s called by
  //  an auxiliary constructor in the subclass.

  //When you define a subclass in Scala, you control the superclass constructor that’s called by its primary
  // constructor when you define the extends portion of the subclass declaration. For instance, in the following code,
  // the Dog class is defined to call the primary constructor of the Animal class, which is a one-arg constructor that
  // takes name as its parameter:

  class Animal(var name: String)

  class Dog(name: String) extends Animal(name)

  //However, if the Animal class has multiple constructors, the primary constructor of the Dog class can call any
  // of those constructors.

  // (1) primary constructor
  class Animal2(var name: String, var age: Int) {
    def this(name: String) = {
      this(name, 20)
    }

    override def toString: String = s"$name is $age years old"
  }

  class Dog2(name: String) extends Animal2(name) {
    println("Dog constructor called")
  }

  //Auxiliary constructors
  //
  //Regarding auxiliary constructors, because the first line of an auxiliary constructor must be a call to another
  //constructor of the current class, there is no way for auxiliary constructors to call a superclass constructor.

  //Therefore, there’s no direct way to control which superclass constructor is called from an auxiliary constructor
  // in a subclass. In fact, because each auxiliary constructor must call a previously defined constructor in the
  // same class, all auxiliary constructors will eventually call the same superclass constructor that’s called from
  // the subclass’s primary constructor.
}
