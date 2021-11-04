package leetcode

object ReverseLinkedList {
  // Given the head of a singly linked list, reverse the list, and return the reversed list.

  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def loop(node: ListNode, head: ListNode): ListNode = {
      if (node == null) {
        head
      } else {
        val next = node.next
        node.next = head
        loop(next, node)
      }
    }
    loop(head, null)
  }
}
