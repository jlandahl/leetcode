package leetcode

object MergeTwoSortedLists extends App {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

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

  def toList(head: ListNode): List[Int] = {
    val l = collection.mutable.ListBuffer.empty[Int]
    var cur = head
    while (cur != null) {
      l.addOne(cur.x)
      cur = cur.next
    }
    l.toList
  }

  val l1 = new ListNode(1, new ListNode(2, new ListNode(4)))
  val l2 = new ListNode(1, new ListNode(3, new ListNode(4)))

  println(toList(mergeTwoLists(l1, l2)))
}
