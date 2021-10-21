package leetcode

object ReverseString extends App {
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

  val arr1 = "hello".toCharArray
  reverseString(arr1)
  println(arr1.toList)

  val arr2 = "Hannah".toCharArray
  reverseString(arr2)
  println(arr2.toList)
}
