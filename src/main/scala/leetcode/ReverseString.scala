package leetcode

object ReverseString {
  // Write a function that reverses a string. The input string is given as an array of characters s.

  def reverseString(s: Array[Char]): Unit = {
    @annotation.tailrec
    def loop(left: Int, right: Int): Unit = {
      if (left < right) {
        val temp = s(left)
        s(left) = s(right)
        s(right) = temp
        loop(left + 1, right - 1)
      }
    }
    loop(0, s.length - 1)
  }
}
