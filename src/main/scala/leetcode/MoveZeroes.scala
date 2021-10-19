package leetcode

object MoveZeroes extends App {
  def moveZeroes(nums: Array[Int]): Unit = {
    val result = Array.ofDim[Int](nums.length)
    var zeroes = 0
    nums.indices.foreach { i =>
      if (nums(i) == 0) {
        zeroes += 1
        result(nums.length - zeroes) = nums(i)
      } else {
        result(i - zeroes) = nums(i)
      }
    }
    nums.indices.foreach { i =>
      nums(i) = result(i)
    }
  }

  val a = Array(0,1,0,3,12)
  moveZeroes((a))
  println(a.toList)
}
