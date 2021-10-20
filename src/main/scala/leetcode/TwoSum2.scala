package leetcode

object TwoSum2 extends App {
  // Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
  // find two numbers such that they add up to a specific target number. Let these two numbers
  // be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.
  //
  // Return the indices of the two numbers, index1 and index2, as an integer array
  // [index1, index2] of length 2.
  //
  // The tests are generated such that there is exactly one solution.
  // You may not use the same element twice.

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def search(left: Int, right: Int, target: Int): Int = {
      if (left > right) {
        -1
      } else {
        val mid = (right - left) / 2 + left
        if (numbers(mid) == target) {
          mid
        } else if (numbers(mid) < target) {
          search(mid + 1, right, target)
        } else {
          search(left, mid - 1, target)
        }
      }
    }

    @annotation.tailrec
    def loop(i: Int): Array[Int] = {
      if (i >= numbers.length) {
        Array(0, 0)
      } else {
        val complement = target - numbers(i)
        val j = search(i + 1, numbers.length - 1, complement)
        if (j > i)
          Array(i + 1, j + 1)
        else
          loop(i + 1)
      }
    }
    loop(0)
  }

  println(twoSum(Array(2, 7, 11, 15), 9).toList)
  println(twoSum(Array(2, 3, 4), 6).toList)
  println(twoSum(Array(-1, 0), -1).toList)
}
