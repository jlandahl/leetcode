package leetcode

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.zipWithIndex.toMap
    @annotation.tailrec
    def loop(i: Int): Array[Int] = {
      if (i >= nums.length) {
        Array.empty[Int]
      } else {
        val num = nums(i)
        val complement = target - num
        val i2 = map.getOrElse(complement, -1)
        if ((i2 >= 0) && (i2 != i)) {
          Array(i, i2)
        } else {
          loop(i + 1)
        }
      }
    }
    loop(0)
  }

  println(twoSum(Array(1, 2, 3, 4, 5, 6, 7), 10).toList)
}