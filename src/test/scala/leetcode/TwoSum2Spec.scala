package leetcode

class TwoSum2Spec extends Spec {
  "twoSum" should "return the correct value" in {
    TwoSum2.twoSum(Array(2, 7, 11, 15), 9) should be (Array(1, 2))
    TwoSum2.twoSum(Array(2, 3, 4), 6) should be (Array(1, 3))
    TwoSum2.twoSum(Array(-1, 0), -1) should be (Array(1, 2))
  }
}
