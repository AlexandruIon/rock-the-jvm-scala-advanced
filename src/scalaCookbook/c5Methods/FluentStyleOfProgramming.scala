package scalaCookbook.c5Methods

object FluentStyleOfProgramming extends App {

  // fluent programming aka method chaining

  //To support this style of programming:
  //
  //    If your class can be extended, specify this.type as the return type of fluent style methods.
  //
  //    If you’re sure that your class won’t be extended, you can optionally return this from your fluent style methods.

  val employee = new Employee
  employee.setFirstName("Al").setLastName("Alexander").setRole("developer")
  println(employee)

  //  If you’re sure your class won’t be extended, specifying this.type as the return type of your set* methods
  //  isn’t necessary; you can just return the this reference at the end of each fluent style method.

  //Returning this in your methods works fine if you’re sure your class won’t be extended, but if your class can
  // be extended—as in the first example where the Employee class extended the Person class—explicitly setting
  // this.type as the return type of your set* methods ensures that the fluent style will continue to work in
  // your subclasses.

  class Person {
    protected var fname = ""
    protected var lname = ""

    def setFirstName(firstName: String): this.type = {
      fname = firstName
      this
    }

    def setLastName(lastName: String): this.type = {
      lname = lastName
      this
    }
  }

  class Employee extends Person {
    protected var role = ""

    def setRole(role: String): this.type = {
      this.role = role
      this
    }

    override def toString: String = "%s, %s, %s".format(fname, lname, role)
  }

}
