package scalaCookbook.c5Methods

class DefiningAMethodThatReturnsMultipleItemsTuples extends App {

  def getStockInfo = {
    // other code
    ("NFLX", 100.00, 101.00) // this is a Tuple3
  }

  val (symbol, currentPrice, bidPrice) = getStockInfo

  val result = getStockInfo
  result._1
  result._2

}
