package leetcode

class MergeTwoSortedListsSpec extends Spec {
  "mergeTwoLists" should "return the correct value" in {
    val l1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val l2 = new ListNode(1, new ListNode(3, new ListNode(4)))

    MergeTwoSortedLists.mergeTwoLists(l1, l2).toList should be (List(1, 1, 2, 3, 4, 4))
  }
}
