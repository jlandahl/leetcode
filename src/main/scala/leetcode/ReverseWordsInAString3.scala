package leetcode

object ReverseWordsInAString3 extends App {
  def reverseWords(s: String): String = {
    @annotation.tailrec
    def reverseWord(arr: Array[Char], left: Int, right: Int): Unit = {
      if (left > right) {
        ()
      } else {
        val temp = arr(left)
        arr(left) = arr(right)
        arr(right) = temp
        reverseWord(arr, left + 1, right - 1)
      }
    }

    @annotation.tailrec
    def loop(arr: Array[Char], left: Int, right: Int): Unit = {
      if (left >= arr.length) {
        ()
      } else if (right == arr.length || arr(right) == ' ') {
        reverseWord(arr, left, right - 1)
        loop(arr, right + 1, right + 1)
      } else if (arr(left) == ' ') {
        loop(arr, left + 1, left + 1)
      } else {
        loop(arr, left, right + 1)
      }
    }
    val arr = s.toCharArray
    loop(arr, 0, 0)
    arr.mkString
  }

  println(reverseWords("Let's take LeetCode contest"))
}