package leetcode

object SquaresSortedArray {
  def main(args: Array[String]): Unit = {
    println(sortedSquares2(Array(-4,-1,0,3,10)).toList)
  }

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
          result.update(curr, squared(left))
          loop(left + 1, right, curr -1, result)
        } else {
          result.update(curr, squared(right))
          loop(left, right - 1, curr - 1, result)
        }
      }
    }
    loop(0, nums.length - 1, nums.length - 1, Array.ofDim[Int](nums.length))
  }
}
