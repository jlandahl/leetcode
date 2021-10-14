package leetcode

object LongestPalindromicSubstring {
  def main(args: Array[String]): Unit = {
    println(longestPalindrome("babad"))
  }

  def longestPalindrome(s: String): String = {
    var maxlen = 0
    var start = 0

    def expandFromCenter(l: Int, r: Int): Unit = {
      var left = l
      var right = r
      while (left > -1 && right < s.length && s(left) == s(right)) {
        left = left - 1
        right = right + 1
      }
      val len = right - left - 1
      if (maxlen < len) {
        maxlen = len
        start = left + 1
      }
    }

    (0 until s.length).foreach { i =>
      expandFromCenter(i, i)
      expandFromCenter(i, i + 1)
    }
    s.substring(start, start + maxlen)
  }
}
