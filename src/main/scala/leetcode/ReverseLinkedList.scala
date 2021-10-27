package leetcode

object ReverseLinkedList extends App {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

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

  def toList(head: ListNode): List[Int] = {
    val l = collection.mutable.ListBuffer.empty[Int]
    var cur = head
    while (cur != null) {
      l.addOne(cur.x)
      cur = cur.next
    }
    l.toList
  }

  val l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
  println(toList(reverseList(l1)))
}
