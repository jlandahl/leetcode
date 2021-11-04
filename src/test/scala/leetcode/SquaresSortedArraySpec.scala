package leetcode

class SquaresSortedArraySpec extends Spec {
  "sortedSquares" should "return the correct value" in {
    SquaresSortedArray.sortedSquares2(Array(-4,-1,0,3,10)) should be (Array(0, 1, 9, 16, 100))
  }
}
