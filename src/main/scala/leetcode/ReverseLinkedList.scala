package leetcode

object ReverseLinkedList extends App {
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

  val l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
  println(reverseList(l1).toList)
}
