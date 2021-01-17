package scalaCookbook.c6Objects

object PackageObjectTest extends App {

  echo("Hello, world")
  echo(MAGIC_NUM)
  echo(Margin.LEFT)

  // use our MutableMap type (scala.collection.mutable.Map)

  val mm = MutableMap("name" -> "Al")
  mm += ("password" -> "123")
  for ((k, v) <- mm) printf("key: %s, value: %s\n", k, v)

}
