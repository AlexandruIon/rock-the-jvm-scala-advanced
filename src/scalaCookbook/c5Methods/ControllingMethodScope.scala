package scalaCookbook.c5Methods

object ControllingMethodScope extends App {

  //Scala methods are public by default, and you want to control their scope in ways similar to Java.

  //In order from “most restrictive” to “most open,” Scala provides these scope options:

  //    Object-private scope
  //
  //    Private
  //
  //    Package
  //
  //    Package-specific
  //
  //    Public

  //------------------------------

  // 1.  Object-private scope
  // When you do this, the method is available only to the current instance of the current object.
  // Other instances of the same class cannot access the method.

  private[this] def isFoo = true

  class Foo {
    private[this] def isFoo = true

    def foFoo(other: Foo): Unit = {
      //      if(other.isFoo){ won`t compile
      //      }
    }
  }

  // 2.  Private scope
  //makes the method available to (a) the current class and (b) other instances of the current class.

  class Foo2 {
    private def isFoo = true

    def foFoo(other: Foo2): Unit = {
      if (other.isFoo) { // now compiles

      }
    }
  }

  //By making a method private, it is not available to subclasses.
  class Animal {
    private def heartBeat() {}
  }

  class Dog extends Animal {
    //    heartBeat won`t compile
  }


  // 3.  Protected scope

  // Marking a method protected makes the method available to subclasses, so the following code will compile:
  // The meaning of protected is slightly different in Scala than in Java. In Java, protected methods can be
  // accessed by other classes in the same package, but this isn’t true in Scala

  class Animal2 {
    protected def heartBeat() {}
  }

  class Dog2 extends Animal2 {
    heartBeat() // now compiles
  }

  // 4. Package scope

  //To make a method available to all members of the current package—what would be called “package scope” in
  // Java—mark the method as being private to the current package with the private[packageName] syntax.

  class Foo3 {
    private[c5Methods] def doX(): Unit = {

    }

    private def doY() {}
  }

  class Bar {
    val f = new Foo3
    f.doX() //compiles
    // f.doY() // won`t compile
  }


  // 5. Public Scope
  // If no access modifier is added to the method declaration, the method is public.



}
