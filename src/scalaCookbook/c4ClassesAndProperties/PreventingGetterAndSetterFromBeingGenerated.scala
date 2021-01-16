package scalaCookbook.c4ClassesAndProperties

object PreventingGetterAndSetterFromBeingGenerated extends App {

  //When you define a class field as a var, Scala automatically generates getter and setter methods for the field,
  //and defining a field as a val automatically generates a getter method, but you don’t want either a getter or setter.

  //  Define the field with the private or private[this]

  class Stock {
    // getter and setter methods are generated
    var delayedPrice: Double = _

    // keep this field hidden from other classes
    private var currentPrice: Double = _
  }

  //Defining a field as private limits the field so it’s only available to instances of the same class, in this
  //case instances of the Stock class. To be clear, any instance of a Stock class can access a private field of any
  // other Stock instance.

  class Stocks {
    private var price: Double = _

    def setPrice(p: Double) {
      price = p
    }

    def isHigher(that: Stocks): Boolean = this.price > that.price
  }

  val s1 = new Stocks;
  s1.setPrice(100)

  val s2 = new Stocks;
  s2.setPrice(200)

  println(s2.isHigher(s1))


  //###### Object-private fields
  //Defining a field as private[this] takes this privacy a step further, and makes the field object-private,
  //which means that it can only be accessed from the object that contains it. Unlike private,
  //the field can’t also be accessed by other instances of the same type, making it more private than the plain
  //private setting

  class Stocks2 {
    // a private[this] var is object-private, and can only be seen
    // by the current instance
    private[this] var price: Double = _

    def setPrice(p: Double) {
      price = p
    }

    // error: this method won't compile because price is now object-private
    //  def isHigher(that: Stocks2): Boolean = this.price > that.price
  }

}
