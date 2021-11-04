package leetcode

class MergeKSortedListsSpec extends Spec {
  "mergeKLists" should "return the correct value with three lists" in {
    val array = Array(
      new ListNode(1, new ListNode(4, new ListNode(5))),
      new ListNode(1, new ListNode(3, new ListNode(4))),
      new ListNode(2, new ListNode(6))
    )
    MergeKSortedLists.mergeKLists(array).toList should be (List(1, 1, 2, 3, 4, 4, 5, 6))
  }

  it should "return null when given an empty array" in {
    MergeKSortedLists.mergeKLists(Array.empty[ListNode]) should be (null)
  }
}
