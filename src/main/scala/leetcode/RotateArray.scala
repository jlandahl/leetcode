package leetcode

object RotateArray {
  // Given an array, rotate the array to the right by k steps, where k is non-negative.

  def rotate(nums: Array[Int], k: Int): Unit = {
    @annotation.tailrec
    def loop(i: Int, j: Int, result: Array[Int]): Array[Int] = {
      if (i >= nums.length) {
        result
      } else if (j >= nums.length) {
        val j2 = j % nums.length
        result.update(j2, nums(i))
        loop(i + 1, j2 + 1, result)
      } else {
        result.update(j, nums(i))
        loop(i + 1, j + 1, result)
      }
    }
    val result = loop(0, k, Array.ofDim[Int](nums.length))
    result.indices.foreach { i => nums(i) = result(i) }
  }
}
