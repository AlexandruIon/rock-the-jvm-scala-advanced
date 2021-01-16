package scalaCookbook.c4ClassesAndProperties

object ClassesAndProperties extends App {

  val p = new Person("alex", "ion")
}

//The primary constructor of a Scala class is a combination of:
//
//    The constructor parameters
//
//    Methods that are called in the body of the class
//
//    Statements and expressions that are executed in the body of the class

//Because the methods in the body of the class are part of the constructor, when an instance of a
// Person class is created, you’ll see the output from the println statements at the beginning and
// end of the class declaration, along with the call to the printHome and printFullName methods near the bottom of the class:


//Anything defined within the body of the class other than method declarations is a part of the primary class constructor.
// Because auxiliary constructors must always call a previously defined constructor in the same class, auxiliary constructors will also execute the same code.
class Person(var firstName: String, var lastName: String) {

  println("the constructor begins")

  //some class fields
  private val HOME = System.getProperty("user.home")
  var age = 0

  //some methods
  override def toString: String = s"$firstName $lastName is $age years old"

  def printHome {
    println(s"HOME = $HOME")
  }

  def printFullName {
    println(this)
  } // uses toString

  printHome
  printFullName
  println("still in the constructor")
}