package scalaCookbook.c4ClassesAndProperties

object AssigningAFieldToABlockOrFunction extends App {

  //You want to initialize a field in a class using a block of code, or by calling a function.

  //  Set the field equal to the desired block of code or function. Optionally, define the
  //  field as lazy if the algorithm requires a long time to run.

  class Foo {

    // set 'text' equal to the result of the block of code.
    val text: String = {
      var lines = ""
      try {
        lines = io.Source.fromFile("").getLines().mkString
      } catch {
        case e: Exception => lines = "Error happened"
      }
      lines
    }

    println(text)
  }

}
