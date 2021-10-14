package leetcode

object BinarySearch {
  def main(args: Array[String]): Unit = {
    println(search(Array(1, 4, 7, 9, 12), 0))
  }

  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1
    @annotation.tailrec
    def loop(): Int = {
      if (left > right) {
        -1
      } else {
        val mid = (right - left) / 2 + left
        val candidate = nums(mid)
        if (candidate == target) {
          mid
        } else if (candidate < target) {
          left = mid + 1
          loop()
        } else {
          right = mid - 1
          loop()
        }
      }
    }
    loop()
  }
}
