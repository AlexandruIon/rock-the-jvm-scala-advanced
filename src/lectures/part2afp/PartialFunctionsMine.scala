package lectures.part2afp

object PartialFunctionsMine extends App {

  val withDefault3 = new Function[Option[Int], Int] {
    override def apply(v1: Option[Int]): Int = v1 match {
      case Some(x) => x
      case None => 0
    }
  }

  val withDefault2 = (x: Option[Int]) => x match {
    case Some(x) => x
    case None => 0
  }

  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  val withDefault4: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  val sum: (Int, Int) => Int = (a, b) => a + b
  val choice: (Int) => Int = {
    case x => x
  }

  println {
    withDefault(Some(10))
  }
  println {
    withDefault(None)
  }

}
