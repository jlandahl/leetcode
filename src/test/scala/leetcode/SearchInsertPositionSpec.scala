package leetcode

class SearchInsertPositionSpec extends Spec {
  "searchInsert" should "find an existing number" in {
    SearchInsertPosition.searchInsert(Array(1, 2, 3, 7, 9, 10), 9) should be (4)
  }

  it should "find the correct insert position" in {
    SearchInsertPosition.searchInsert(Array(1, 2, 3, 7, 9, 10), 8) should be (4)
  }
}
