package leetcode

class BinarySearchSpec extends Spec {
  "search" should "find a number correctly" in {
    BinarySearch.search(Array(1, 4, 7, 9, 12), 7) should be (2)
  }

  it should "return -1 when the target is not found" in {
    BinarySearch.search(Array(1, 4, 7, 9, 12), 18) should be (-1)
    BinarySearch.search(Array(1, 4, 7, 9, 12), -1) should be (-1)
  }
}
