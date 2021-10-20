package leetcode

object SearchInsertPosition {
  def main(args: Array[String]): Unit = {
    println(searchInsert(Array(1, 2, 3, 7, 9, 10), 8))
  }

  // Given a sorted array of distinct integers and a target value, return the index if the target
  // is found. If not, return the index where it would be if it were inserted in order.
  //
  // You must write an algorithm with O(log n) runtime complexity.

  def searchInsert(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def loop(left: Int, right: Int): Int = {
      if (left > right) {
        left
      } else {
        val mid = left + (right - left) / 2
        if (nums(mid) == target) {
          mid
        } else if (nums(mid) < target) {
          loop(mid + 1, right)
        } else {
          loop(left, mid - 1)
        }
      }
    }
    loop(0, nums.length - 1)
  }
}
