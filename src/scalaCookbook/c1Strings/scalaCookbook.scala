package scalaCookbook.c1Strings

package object scalaCookbook {

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }

}
