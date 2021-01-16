package scalaCookbook.c4ClassesAndProperties

import scalaCookbook.c4ClassesAndProperties.Pizza.{DEFAULT_CRUST_SIZE, DEFAULT_CRUST_TYPE}

object DefiningAuxiliaryConstructors extends App {

  val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  val p2 = new Pizza(Pizza.DEFAULT_CRUST_SIZE)
  val p3 = new Pizza(Pizza.DEFAULT_CRUST_TYPE)
  val p4 = new Pizza
}

//Also, each constructor must call one of the previously defined constructors.

//There are several important points to this recipe:
//
//    Auxiliary constructors are defined by creating methods named this.
//
//    Each auxiliary constructor must begin with a call to a previously defined constructor.
//
//    Each constructor must have a different signature.
//
//    One constructor calls another constructor with the name this.


//To summarize, if you want the accessors and mutators to be generated for you, put them in the primary constructor.
class Pizza(var crustSize: Int, var crustType: String) {

  def this(crustSize: Int) {
    this(crustSize, DEFAULT_CRUST_TYPE)
  }

  def this(crustType: String) {
    this(DEFAULT_CRUST_SIZE, crustType)
  }

  def this() {
    this(DEFAULT_CRUST_SIZE, DEFAULT_CRUST_TYPE)
  }

  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}

object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"

}