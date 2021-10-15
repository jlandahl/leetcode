package misc

object TestStrings extends App {
  val strings = List(
    "arrb6???4xxbl5???eee5" -> true,
    "acc?7??sss?3rr1??????5" -> true,
    "5??aaaaaaaaaaaaaaaaaaa?5?5" -> true,
    "9???1???9???1???9" -> true,
    "aa6?9" -> false,
    "8???2???9" -> false,
    "10???0???10" -> false,
    "aa3??oiuqwer?7???2" -> false
  )

  def test(): Unit = {
    strings.foreach { case (string, result) =>
      println(string, checkString2(string) == result)
    }
  }

  def checkString(s: String): Boolean = {
    var digit = -1
    var qs = 0
    var i = 0
    var mismatch = false
    var found = false
    while (i < s.length && !mismatch) {
      val c = s(i)
      if (c.isDigit) {
        val newDigit = c.toString.toInt
        if (digit == -1)
          qs = 0
        if (qs == 3) {
          if (digit + newDigit == 10) {
            found = true
            qs = 0
          } else {
            found = false
            mismatch = true
          }
        }
        digit = newDigit
      } else if (c == '?') {
        qs += 1
      }
      i += 1
    }
    found
  }

  def checkString2(s: String): Boolean = {
    // drop everything before the first digit
    val s2 = s.dropWhile(!_.isDigit)

    @annotation.tailrec
    def loop(lastDigit: Int, qs: Int, i: Int, found: Boolean): Boolean = {
      if (i >= s2.length) {
        found
      } else {
        val c = s2(i)
        if (c.isDigit) {
          val newDigit = c.toString.toInt
          if (qs == 3) {
            if (lastDigit + newDigit != 10) {
              false
            } else {
              loop(newDigit, 0, i + 1, true)
            }
          } else {
            loop(newDigit, qs, i + 1, found)
          }
        } else if (c == '?') {
          loop(lastDigit, qs + 1, i + 1, found)
        } else {
          loop(lastDigit, qs, i + 1, found)
        }
      }
    }
    loop(-1, 0, 0, false)
  }

  test()

}
