package leetcode

class ReverseLinkedListSpec extends Spec {
  "reverseList" should "return the correct value" in {
    val l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
    ReverseLinkedList.reverseList(l).toList should be (List(4, 3, 2, 1))
  }
}
