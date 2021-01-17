package scalaCookbook.c6Objects

object TheScalaEquivalentOfJavaClass extends App {

  //When an API requires that you pass in a Class, you’d call .class on an object in Java,
  // but that doesn’t work in Scala.

  //Use the Scala classOf method instead of Java’s .class.

  //  The classOf method is defined in the Scala Predef object and is therefore available in
  // all classes without requiring an import.

  val stringClass = classOf[String] // Class[String]

  stringClass.getMethods
}
