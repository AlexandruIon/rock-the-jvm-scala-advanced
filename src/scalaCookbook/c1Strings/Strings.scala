package scalaCookbook.c1Strings

object Strings extends App {

  //implicit conversions pattern helps a Scala String have both string and collection features
  "scala".drop(2).take(2).capitalize

  //  chaining methods together like this, it’s known as a fluent style of programming


  /*
   ################################### String equality - whether they contain the same sequence of characters.
   */

  // you compare two String instances with the == operator

  val s1 = "Hello"
  val s2 = "Hello"
  val s3 = "H" + "ello"

  assert(s1 == s2)
  assert(s3 == s1)

  //benefit of the == method is that it doesn’t throw a NullPointerException on a basic test if a String is null
  val s4: String = null

  assert(s3 != s4)
  assert(s4 != s3)

  val s5 = "Hello"
  val s6 = "hello"
  assert(s5.toUpperCase == s6.toUpperCase)

  // == method defined in the AnyRef class first checks for null values, and then calls the equals method
  // on the first object (i.e., this) to see if the two objects are equal

  /*
   ################################ Multiline Strings - “heredoc” syntax
   */

  val foo =
    """THis is
      |a multiline
      |String
      |""".stripMargin
  println(foo)

  val speech =
    """Four score and
      # seven years ago""".stripMargin('#')
  println(speech)

  val speechContinuousLine =
    """
      |Four score and
      |seven years ago
      |our fathers""".stripMargin.replaceAll("\n", "")
  println(speechContinuousLine)

  val multiLineStringWithQuotes =
    """
      |This is known as a
      |"multiline" string
      |or 'heredoc' syntax.""".stripMargin.replaceAll("\n", " ")
  println(multiLineStringWithQuotes)

  /*
   ########################## Splitting strings
   */

  "hello world".split(" ")
  "hello world".split(" ").foreach(println)

  /*
   ########################## Substituting Variables into Strings
   */

  // Beginning with Scala 2.10 you can use string interpolation
  val name = "Fred"
  val age = 33
  val weight = 200.00
  println(s"$name is $age years old, and weights $weight pounds.")

  //when you precede your string with the letter s, you’re creating a processed string literal.
  //This example uses the “s string interpolator,” which lets you embed variables inside a string, where they’re
  //replaced by their values. As stated in the documentation,
  //“Prepending s to any string literal allows the usage of variables directly in the string

  println(s"Age next year: ${age + 1}")
  println(s"You are 33 years old: ${age == 33}")

  //Any arbitrary expression can be embedded in ${}

  case class Student(name: String, score: Int)

  val hannah = Student("Hannah", 95)

  println(s"${hannah.name} has a score of ${hannah.score}")

  //The s that’s placed before each string literal is actually a method
  //### The f string interpolator (printf style formatting)

  println(f"$name is $age years old, and weights $weight%.2f pounds.")
  println(f"$name is $age years old, and weights $weight%.0f pounds.")

  //###  The raw interpolator
  // raw interpolator “performs no escaping of literals within the string.”
  println(s"foo\nbar")
  println(raw"foo\bar")


  /*
   ########################## Processing a String One Character at a Time
   */

  // you can use the map or foreach methods, a for loop, or other approaches
  val upper = "hello, world".map(c => c.toUpper)
  val upper2 = "hello, world".map(_.toUpper)

  val upperFilter = "hello, world".filter(_ != 'l').map(_.toUpper)
  println(upperFilter)

  for (c <- "hello") println(c)

  //To write a for loop to work like a map method, add a yield statement to the end of the loop
  //Adding yield to a for loop essentially places the result from each loop iteration into a temporary holding area.
  //When the loop completes, all of the elements in the holding area are returned as a single collection
  val upperFor = for (c <- "hello, world") yield c.toUpper
  println(upperFor)

  val upperForWithFilter = for (c <- "hello, wold" if c != 'l') yield c.toUpper
  println(upperForWithFilter)


  //Scala treats a string as a sequence of characters
  //  map treats a String as a sequential collection of Char elements
  //  Under the covers, the Scala compiler translates a for loop into a foreach method call


  /*
   ########################## Finding Patterns in Strings
   */

  //Create a Regex object by invoking the .r method on a String
  val numPattern = "[0-9]+".r
  val address = "123 Main Street Suite 101"

  val match1 = numPattern.findFirstIn(address)
  val matches = numPattern.findAllIn(address)
  matches.foreach(println)

  //Using the .r method on a String is the easiest way to create a Regex object.
  //Another approach is to import the Regex class, create a Regex instance, and then use the instance in the same way:

  import scala.util.matching.Regex

  val numPattern2 = new Regex("[0-9]+")
  val mathc2 = numPattern2.findFirstIn(address)

  /*
   ########################## Replacing Patterns in Strings
   */

  //Because a String is immutable, you can’t perform find-and-replace operations directly on it,
  //but you can create a new String that contains the replaced contents

  val address3 = "123 Main Street".replaceAll("[0-9]", "x")
  println(address3)

  /*
   ########################## Extracting Parts of a String That Match Patterns
   */

  val extractPattern = "([0-9]+) ([A-Za-z]+)".r
  val extractPattern(count, fruit) = "100 babans"
  println(s"count = $count and fruit = $fruit")

  // match "movies 80301"
  val MoviesZipRE = "movies (\\sd{5})".r
  // match "movies near boulder, co"
  val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r

  val textUserTypes = ""
  textUserTypes match {
    case MoviesZipRE(zip) => println(zip)
    case MoviesNearCityStateRE(city, state) => println(s"$city and $state")
    case _ =>
  }

  /*
   ########################## Accessing a Character in a String
   */

  "hello".charAt(0) // java approach

  //you can treat a String as an Array, and access each character with the array notation shown.
  "hello"(0) //scala version
  "hello".apply(0) // scala behind the scenes

  /*
   ########################## Add Your Own Methods to the String Class
   */

  //In Scala 2.10, you define an implicit class, and then define methods within that class to implement the behavior you want.

  implicit class StringImprovements(s: String) {
    def increment: String = s.map(c => (c + 1).toChar)

    def decrement: String = s.map(c => (c - 1).toChar)

    def hideAll: String = s.replaceAll(".", "*")

    def plusOne = s.toInt + 1

    def asBoolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }

  val result = "HAL".increment
  println(result)

  // “An implicit class must be defined in a scope where method definitions are allowed (not at the top level).”
  // This means that your implicit class must be defined inside a class, object, or package object.
  // A major benefit of this approach is that you don’t have to extend existing classes to add the new functionality
  //It’s recommended that the return type of implicit method definitions should be annotated

  "4".plusOne
  "0".asBoolean
  "1".asBoolean

}
