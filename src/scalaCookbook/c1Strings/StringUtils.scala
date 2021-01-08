package scalaCookbook.c1Strings

object StringUtils {

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }

}
