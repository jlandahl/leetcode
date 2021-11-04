package leetcode

object AddTwoNumbers {
  // You are given two non-empty linked lists representing two non-negative integers.
  // The digits are stored in reverse order, and each of their nodes contains a single digit.
  // Add the two numbers and return the sum as a linked list.
  //
  // You may assume the two numbers do not contain any leading zero, except the number 0 itself.

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int): ListNode = {
      if (l1 == null && l2 == null && carry == 0) {
        null
      } else {
        val (a, l1next) = if (l1 == null) (0, null) else (l1.x, l1.next)
        val (b, l2next) = if (l2 == null) (0, null) else (l2.x, l2.next)
        val sum = a + b + carry
        new ListNode(sum % 10, addTwoNumbers(l1next, l2next, sum / 10))
      }
    }
    addTwoNumbers(l1, l2, 0)
  }
}
