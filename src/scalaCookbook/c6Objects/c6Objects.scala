package scalaCookbook

package object c6Objects {

  //You want to make functions, fields, and other code available at a package level,
  // without requiring a class or object.

  //  Put the code you want to make available to all classes within a package in a package object.


  //By convention, put your code in a file named package.scala in the directory where you want your code to be available


  val MAGIC_NUM = 42

  def echo(a: Any) {
    println(a)
  }

  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  type MutableMap[K, V] = scala.collection.Map[K, V]
  val MutableMap = scala.collection.mutable.Map

  ///You can now access this code directly from within other classes, traits, and objects in the package


  //  The Scala package object documentation states, “Any kind of definition that you can put inside a class,
  //  you can also put at the top level of a package.” In my experience, package objects are a great place to put
  //  methods and functions that are common to the package, as well as constants, enumerations, and implicit
  //  conversions.
}
