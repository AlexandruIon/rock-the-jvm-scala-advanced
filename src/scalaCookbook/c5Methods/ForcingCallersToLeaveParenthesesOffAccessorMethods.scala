package scalaCookbook.c5Methods

object ForcingCallersToLeaveParenthesesOffAccessorMethods extends App {

  //You want to enforce a coding style where getter/accessor methods can’t have parentheses when they are invoked.


  // Define your getter/accessor method without parentheses after the method name:

  class Pizza {
    // no parentheses after crustSize
    def crustSize = 12
  }

  // this forces consumers of your class to call crustSize without parantheses:

  val p = new Pizza
  p.crustSize
  //  p.crustSize() -> fails


  //The recommended strategy for calling getter methods that have
  // no side effects is to leave the parentheses off when calling the method

  //Scala Style Guide => Methods which act as accessors of any sort ... should be declared without parentheses,
  // except if they have side effects.
}
