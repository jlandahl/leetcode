package leetcode

object MergeKSortedLists extends App {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  // You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
  //
  // Merge all the linked-lists into one sorted linked-list and return it.

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    import collection.mutable

    implicit val ordering: Ordering[ListNode] = (a: ListNode, b: ListNode) => b.x - a.x
    val pq = mutable.PriorityQueue.empty[ListNode]

    // Add each head to the priority queue
    lists.filter(_ != null).foreach(pq.addOne)

    // Start off with a dummy node
    val head = new ListNode(0)
    var tail = head

    while (pq.nonEmpty) {
      tail.next = pq.dequeue()
      tail = tail.next
      if (tail.next != null)
        pq.addOne(tail.next)
    }

    head.next
  }

  def mergeKLists0(lists: Array[ListNode]): ListNode = {
    @annotation.tailrec
    def findSmallestNode(smallestNode: Option[(Int, ListNode)], i: Int): Option[(Int, ListNode)] = {
      if (i >= lists.length) {
        smallestNode
      } else if (lists(i) == null) {
        findSmallestNode(smallestNode, i + 1)
      } else {
        smallestNode match {
          case Some((_, node)) =>
            if (lists(i).x < node.x) {
              findSmallestNode(Some(i, lists(i)), i + 1)
            } else {
              findSmallestNode(smallestNode, i + 1)
            }
          case None =>
            findSmallestNode(Some(i, lists(i)), i + 1)
        }
      }
    }

    @annotation.tailrec
    def loop(head: ListNode, tail: ListNode): ListNode = {
      findSmallestNode(None, 0) match {
        case Some((index, node)) =>
          // increment the list where the smallest value was found
          lists(index) = lists(index).next

          if (head == null) {
            loop(node, node)
          } else {
            tail.next = node
            loop(head, tail.next)
          }
        case None =>
          head
      }
    }

    loop(null, null)
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

  val arr1 = Array(
    new ListNode(1, new ListNode(4, new ListNode(5))),
    new ListNode(1, new ListNode(3, new ListNode(4))),
    new ListNode(2, new ListNode(6))
  )

  println(toList(mergeKLists(arr1)))
  println(toList(mergeKLists(Array.empty[ListNode])))
}
