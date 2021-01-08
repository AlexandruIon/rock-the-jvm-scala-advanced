package lectures.part1as

object AdvancedPatternMatchingMine extends App {

  abstract class Expr

  //  biggest advantage
  //    of case classes is that they support pattern matching

  case class Var(name: String) extends Expr

  case class Number(num: Double) extends Expr

  case class UnOp(operator: String, arg: Expr) extends Expr

  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  // ############# case class syntactic conveniences

  // 1. First, it adds a factory method with the name of the class.
  //  case classes have an apply method by default which takes care of object construction.
  val v = Var("x")
  val v2 = new Var("x")
  val op = BinOp("+", Number(1), v)

  // 2. All arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained as fields:
  //When you create a case class with parameters, the parameters are public vals.
  v.name
  op.left

  // 3. the compiler adds "natural" implementations of methods toString, hashCode, and equals to your class
  println(op)
  op.right == Var("x")

  // 4. the compiler adds a copy method to your class for making modified copies.
  // This method is useful for making a new instance of the class that is the same as another one except that one or two
  //attributes are different
  val opMin = op.copy(operator = "-")
  println {
    opMin
  }

}
