package leetcode

object BinarySearch {
  def main(args: Array[String]): Unit = {
    println(search(Array(1, 4, 7, 9, 12), 7))
  }

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
