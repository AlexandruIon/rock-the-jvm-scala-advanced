package scalaCookbook.c3ControlStructures

import java.io.{FileInputStream, FileNotFoundException, FileOutputStream, IOException}

object MatchingExceptionsWithTryCatch extends App {

  //  You want to catch one or more exceptions in a try/catch block.

  //The Scala try/catch/finally syntax is similar to Java, but it uses the match expression approach in the catch block:
  val s = "Foo"
  try {
    val i = s.toInt
  } catch {
    case e: Exception => e.printStackTrace()
  }

  try {
    //    openAndReadAFile(filename)
  }
  catch {
    case e: FileNotFoundException =>
    case e: IOException =>
  }

  try {
    //    openAndReadAFile(filename)
  } catch {
    case t: Throwable => t.printStackTrace()
  }

  try {
    //    openAndReadAFile(filename)
  } catch {
    case _: Throwable =>
  }

  //As with Java, you can throw an exception from a catch clause,
  // but because Scala doesn’t have checked exceptions, you don’t need to specify that a method throws the exception
  def toInt(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => throw e
    }

  //If you prefer to declare the exceptions that your method throws, or you need to interact with Java, add the @throws annotation to your method definition:
  @throws(classOf[NumberFormatException])
  def toInt2(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => throw e
    }

  /*
  ##################  Declaring a Variable Before Using It in a try/catch/finally Block
   */

  //You want to use an object in a try block, and need to access it in the finally portion of the block, such as when you need to call a close method on an object.

  //In general, declare your field as an Option before the try/catch block, then create a Some inside the try clause.

  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]

  try {
    in = Some(new FileInputStream(""))
    out = Some(new FileOutputStream(""))
    var c = 0
    while ( {
      c = in.get.read; c != -1
    }) {
      out.get.write(c)
    }
  } catch {
    case e: IOException => e.printStackTrace
  }
  finally {
    println("entered finally ___")
    if (in.isDefined) in.get.close()
    if (out.isDefined) out.get.close()
  }

  //One key to this recipe is knowing the syntax for declaring Option fields that aren’t initially populated:
  //var x has No Option[yeT]
  var in2 = None: Option[FileInputStream]
}
