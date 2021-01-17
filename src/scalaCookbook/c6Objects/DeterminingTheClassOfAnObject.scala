package scalaCookbook.c6Objects

object DeterminingTheClassOfAnObject extends App {

  // Because you don’t have to explicitly declare types with Scala, you may occasionally want to
  // print the class/type of an object to understand how Scala works, or to debug code.


  //When you want to learn about the types Scala is automatically assigning on your behalf,
  //call the getClass method on the object.

  def printAll(numbers: Int*): Unit = {
    println("class: " + numbers.getClass)
  }


}
