package leetcode

class AddTwoNumbersSpec extends Spec {
  val l1 =
    new ListNode(9,
      new ListNode(9,
        new ListNode(9,
          new ListNode(9,
            new ListNode(9,
              new ListNode(9,
                new ListNode(9)))))))
  val l2 =
    new ListNode(9,
      new ListNode(9,
        new ListNode(9,
          new ListNode(9))))

  "addTwoNumbers" should "add numbers correctly" in {
    AddTwoNumbers.addTwoNumbers(l1, l2).toList should be (List(8, 9, 9, 9, 0, 0, 0, 1))
  }
}
