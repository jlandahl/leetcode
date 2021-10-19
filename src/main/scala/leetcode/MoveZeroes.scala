package leetcode

object MoveZeroes extends App {
  def moveZeroes(nums: Array[Int]): Unit = {
    var lastNonZero = 0
    nums.indices.foreach { i =>
      if (nums(i) != 0) {
        val temp = nums(i)
        nums(i) = nums(lastNonZero)
        nums(lastNonZero) = temp
        lastNonZero += 1
      }
    }
  }

  val a = Array(0,1,0,3,12)
  moveZeroes((a))
  println(a.toList)
}
