package leetcode

class ReverseWordsInAString3Spec extends Spec {
  "reverseWords" should "return the correct value" in {
    ReverseWordsInAString3.reverseWords("Let's take LeetCode contest") should be ("s'teL ekat edoCteeL tsetnoc")
  }
}
