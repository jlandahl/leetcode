package leetcode

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  def toList: List[Int] = {
    import collection.mutable.ListBuffer
    @annotation.tailrec
    def loop(node: ListNode, list: ListBuffer[Int]): List[Int] = {
      if (node == null) {
        list.toList
      } else {
        list.addOne(node.x)
        loop(node.next, list)
      }
    }
    loop(next, ListBuffer(x))
  }
}
