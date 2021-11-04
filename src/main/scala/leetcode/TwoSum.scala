package leetcode

object TwoSum {
  // Given an array of integers nums and an integer target, return indices of the two numbers
  // such that they add up to target.
  //
  // You may assume that each input would have exactly one solution, and you may not
  // use the same element twice.
  //
  // You can return the answer in any order.

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.zipWithIndex.toMap
    @annotation.tailrec
    def loop(i: Int): Array[Int] = {
      if (i >= nums.length) {
        Array.empty[Int]
      } else {
        val num = nums(i)
        val complement = target - num
        val i2 = map.getOrElse(complement, -1)
        if ((i2 >= 0) && (i2 != i)) {
          Array(i, i2)
        } else {
          loop(i + 1)
        }
      }
    }
    loop(0)
  }
}