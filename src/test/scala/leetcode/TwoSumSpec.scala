package leetcode

class TwoSumSpec extends Spec {
  "twoSum" should "return the correct value" in {
    TwoSum.twoSum(Array(1, 2, 3, 4, 5, 6, 7), 10) should be (Array(2, 6))
  }
}
