package scalaCookbook.c3ControlStructures

object IfExpressionsToCaseStatements extends App {

  val i = 3

  i match {
    case a if 0 to 9 contains a => println("0-9 range" + a)
    case b if 10 to 10 contains b => println("10-19 range: " + b)
    case c if 20 to 29 contains c => println("20-29 range: " + c)
    case _ => println("hmmm.")
  }

  val num = 4
  num match {
    case x if x == 1 => println("one, a lonley number")
    case x if (x == 2 || x == 3) => println(x)
    case _ => println("some other value")
  }

  val stock = Stock("ARR", 100)

  stock match {
    case x if x.symbol == "ARR" && x.price > 100 => buy(x)
    case x if x.symbol == "ARR" && x.price < 20 => sell(x)
  }

  def speak(p: Person) = p match {
    case Person(name) if name == "Fred" => println("Yubba")
    case Person(name) if name == "Bam Bam" => println("Bam bam!")
    case _ => println("Watch the flinstones!")
  }

  case class Person(name: String)

  case class Stock(symbol: String, price: Int)

  def buy(stock: Stock) = println()

  def sell(stock: Stock) = println()
}
