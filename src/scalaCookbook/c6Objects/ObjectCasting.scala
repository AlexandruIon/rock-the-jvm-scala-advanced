package scalaCookbook.c6Objects

object ObjectCasting extends App {


  //You need to cast an instance of a class from one type to another, such as when creating objects dynamically.

  //Use the asInstanceOf method to cast an instance to the desired type

  val a = 10

  val b = a.asInstanceOf[Long]

  val c = a.asInstanceOf[Byte]

}
