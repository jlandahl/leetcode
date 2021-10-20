package leetcode

object LongestPalindromicSubstring {
  def main(args: Array[String]): Unit = {
    println(menacher("babad"))
  }

  // Given a string s, return the longest palindromic substring in s.

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

  def menacher(s: String): String = {
    val s2 = s.mkString("|", "|", "|")
    val radii = Array.ofDim[Int](s2.length)
    var center = 0
    var radius = 0

    while (center < s2.length) {
      while (center-(radius+1) >= 0 && center+(radius+1) < s2.length && s2(center-(radius+1)) == s2(center+(radius+1))) {
        radius += 1
      }
      radii.update(center, radius)

      val oldCenter = center
      val oldRadius = radius
      center += 1
      radius = 0
      @annotation.tailrec
      def loop(): Unit = {
        if (center <= oldCenter + oldRadius) {
          val mirroredCenter = oldCenter - (center - oldCenter)
          val maxMirroredRadius = oldCenter + oldRadius - center
          if (radii(mirroredCenter) < maxMirroredRadius) {
            radii.update(center, radii(mirroredCenter))
            center += 1
            loop()
          } else if (radii(mirroredCenter) > maxMirroredRadius) {
            radii.update(center, maxMirroredRadius)
            center += 1
            loop()
          } else {
            radius = maxMirroredRadius
          }
        }
      }
      loop()
    }

    val max = radii.max
    val index = radii.indexOf(max)
    s2.substring(index - max, index + max + 1).replace("|", "")
  }
}
