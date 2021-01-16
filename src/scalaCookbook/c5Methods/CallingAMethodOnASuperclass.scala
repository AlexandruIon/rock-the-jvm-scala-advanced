package scalaCookbook.c5Methods

object CallingAMethodOnASuperclass extends App {

  //In the basic use case, the syntax to invoke a method in an immediate parent class is the same as Java:
  // Use super to refer to the parent class, and then provide the method name.

  //Controlling which trait you call a method from

  // you can choose which trait to run the method from with the super[traitName].methodName syntax.
  //  Note that when using this technique, you can’t continue to reach up through the parent class
  //  hierarchy unless you directly extend the target class or trait using the extends or with keywords

  trait Human {
    def hello = "the Human trait"
  }

  trait Mother extends Human {
    override def hello: String = "Mother"
  }

  trait Father extends Human {
    override def hello: String = "Father"
  }

  class Child extends Human with Mother with Father {
    def printSuper: String = super.hello

    def printMother: String = super[Mother].hello

    def printFather: String = super[Father].hello

    def printHuman: String = super[Human].hello
  }

  val c = new Child
  println(s"c.printSuper  = ${c.printSuper}")
  println(s"c.printMother = ${c.printMother}")
  println(s"c.printFather = ${c.printFather}")
  println(s"c.printHuman  = ${c.printHuman}")

}
