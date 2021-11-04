package leetcode

object MergeTwoSortedLists {
  // Merge two sorted linked lists and return it as a sorted list. The list should be made
  // by splicing together the nodes of the first two lists.

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    @annotation.tailrec
    def loop(tail: ListNode, l1: ListNode, l2: ListNode): Unit = {
      if (l1 == null && l2 == null) {
        ()
      } else if (l1 == null) {
        tail.next = l2
        loop(tail.next, l1, l2.next)
      } else if (l2 == null) {
        tail.next = l1
        loop(tail.next, l1.next, l2)
      } else {
        if (l1.x <= l2.x) {
          tail.next = l1
          loop(tail.next, l1.next, l2)
        } else {
          tail.next = l2
          loop(tail.next, l1, l2.next)
        }
      }
    }
    val head = new ListNode(0)
    loop(head, l1, l2)
    head.next
  }
}
