package leetcode

object SquaresSortedArray {
  // Given an integer array nums sorted in non-decreasing order, return an array of the
  // squares of each number sorted in non-decreasing order.

  def sortedSquares(nums: Array[Int]): Array[Int] = {
    nums.map(x => x * x).sorted
  }

  def sortedSquares2(nums: Array[Int]): Array[Int] = {
    val squared = nums.map(x => x * x)

    @annotation.tailrec
    def loop(left: Int, right: Int, curr: Int, result: Array[Int]): Array[Int] = {
      if (left > right) {
        result
      } else {
        if (squared(left) > squared(right)) {
          result(curr) = squared(left)
          loop(left + 1, right, curr - 1, result)
        } else {
          result(curr) = squared(right)
          loop(left, right - 1, curr - 1, result)
        }
      }
    }
    loop(0, nums.length - 1, nums.length - 1, Array.ofDim[Int](nums.length))
  }
}
