package leetcode

object BinarySearch {
  // Given an array of integers nums which is sorted in ascending order, and an integer target,
  // write a function to search target in nums. If target exists, then return its index.
  // Otherwise, return -1.
  //
  // You must write an algorithm with O(log n) runtime complexity.

  def search(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def loop(left: Int, right: Int): Int = {
      if (left > right) {
        -1
      } else {
        val mid = (right - left) / 2 + left
        val candidate = nums(mid)
        if (candidate == target)
          mid
        else if (candidate < target)
          loop(mid + 1, right)
        else
          loop(left, mid - 1)
      }
    }
    loop(0, nums.length - 1)
  }
}
