package leetcode

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val withIndex = nums.zipWithIndex
    val map = withIndex.toMap
    withIndex.foreach { case (num, i) =>
      val complement = target - num
      val i2 = map.getOrElse(complement, -1)
      if ((i2 >= 0) && (i2 != i)) {
        return Array(i, i2)
      }
    }
    null
  }
}