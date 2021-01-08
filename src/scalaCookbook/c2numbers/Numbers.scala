package scalaCookbook.c2numbers

object Numbers extends App {

  //all the numeric types are objects, including Byte, Char, Double, Float, Int, Long, and Short.
  //These seven numeric types extend the AnyVal trait, as do the Unit and Boolean classes, which are considered to be “nonnumeric value types.

  Short.MaxValue
  Short.MinValue
  Int.MinValue
  Int.MaxValue

  /*
  ################################### Parsing a Number from a String
  */

  // Use the to* methods that are available on a String (courtesy of the StringLike trait):

  "100".toInt
  "100".toDouble
  "100".toFloat

  //  "foo".toInt  throws NumberFormatException

  val bi = BigInt("1")
  val bd = BigDecimal("2.11")

  //If you need to perform calculations using bases other than 10, you’ll find the toInt method in the Scala Int class
  // doesn’t have a method that lets you pass in a base and radix. To solve this problem, use the parseInt method in the
  // java.lang.Integer class, as shown in these examples

  Integer.parseInt("1", 2)
  Integer.parseInt("100", 3)

  implicit class StringToInt(s: String) {
    def toInt1(radix: Int) = Integer.parseInt(s, radix)
  }

  "100".toInt1(16)

  //This approach is required if the method will be called from Java code
  @throws(classOf[NumberFormatException])
  def toInt(s: String) = s.toInt

  def toInt2(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }

  println(toInt2("1").getOrElse(0)) // 1
  println(toInt2("a").getOrElse(0)) //0

  //assign the result to x
  val x = toInt2("aString").getOrElse(0)

  toInt2("aString") match {
    case Some(n) => println(n)
    case None => println("Boom! That wasn't a number.")
  }

  /*
  ###################################  Converting Between Numeric Types (Casting)
  */

  // Instead of using the “cast” approach in Java, use the to* methods that are available on all numeric types.
  19.45.toInt
  19.toLong

  val a = 1000L
  a.isValidByte
  a.isValidShort

  /*
  ###################################  Overriding the Default Numeric Type
  */

  val aInt = 1 //int
  val aDouble = 1d
  val aFloat = 1f
  val aLong = 1000L

  // preferred style for annotating types - Scala Style Guide
  val aByteAnnotate = 0: Byte
  val aIntAnnotate = 0: Int
  val aShortAnnotate = 0: Short
  val aDoubleAnnotate = 0: Double

  // alternative
  val aByteAnnotate2: Byte = 0
  val aIntAnnotate2: Int = 0

  /*
  ###################################  Replacements for ++ and −−
  */

  //You want to increment or decrement numbers using operators like ++ and −−
  // that are available in other languages, but Scala doesn’t have these operators.

  //Because val fields are immutable, they can’t be incremented or decremented,
  //but var Int fields can be mutated with the += and −= methods:

  //Note that these symbols aren’t operators; they’re implemented as methods that are
  //available on Int fields declared as a var. Attempting to use them on val fields results in a compile-time error:

  var anInt = 1
  anInt += 1
  println(anInt)

  anInt -= 1
  println(anInt)

  var i = 1
  i *= 2
  i *= 2
  println(i)
  i /= 2
  println(i)

  /*
###################################  Comparing Floating-Point Numbers
*/

  //You need to compare two floating-point numbers, but as in some other programming languages,
  // two floating-point numbers that should be equivalent may not be.

  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

  val aFlotPoint = 0.3
  val bFloatingPoint = 0.1 + 0.2
  ~=(aFlotPoint, bFloatingPoint, 0.0001)
  ~=(bFloatingPoint, aFlotPoint, 0.0001)

  /*
  ###################################  Working with big numbers
  */

  //Use the Scala BigInt and BigDecimal classes. You can create a BigInt:

  var bBigInt = BigInt(1234567890)
  var bBigDecimal = BigDecimal(123456.789)

  //Unlike their Java equivalents, these classes support all the operators you’re used to using with numeric types
  bBigDecimal + bBigDecimal
  bBigDecimal * bBigDecimal
  bBigDecimal += 1
  println(bBigDecimal)

  bBigDecimal.toInt
  bBigDecimal.toLong

  bBigDecimal.isValidByte
  bBigDecimal.isValidChar

  // Although the Scala BigInt and BigDecimal classes are backed by the Java BigInteger and BigDecimal classes,
  // they are simpler to use than their Java counterparts. they work just like
  // other numeric types, and they’re also mutable +=

  Double.PositiveInfinity
  Double.NegativeInfinity

  /*
  ###################################  Generating Random Numbers
  */

  val r = scala.util.Random
  r.nextInt()
  // limit the random numbers to a maximum value
  r.nextInt(100)
  r.nextFloat
  r.nextDouble

  //random characters
  r.nextPrintableChar()

  // create a random length range
  var range = 0 to r.nextInt(10)

  for (i <- 0 to r.nextInt(10)) yield i * 2

  /*
  ###################################  Creating a Range, List, or Array of Numbers
  */

  // create ranges
  val rangeTo = 1 to 10
  val rangeToWithStep = 1 to 10 by 2

  for (i <- 1 to 5) println(i)
  for (i <- 1 until 5) println(i)

  // covert ranges to other sequences
  val rangeToArray = 1 to 10 toArray
  val rangeToList = 1 to 10 toList

  val rangeToArray2 = (1 to 10).toArray
  val rangeToList2 = (1 to 10).toList

  /*
 ###################################  Formatting Numbers and Currency
 */

  // for basic formatting use the f string interpolator
  val pi = scala.math.Pi
  println(f"$pi%1.5f")

}
