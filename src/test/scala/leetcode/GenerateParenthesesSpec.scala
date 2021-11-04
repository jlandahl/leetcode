package leetcode

class GenerateParenthesesSpec extends Spec {
  "generateParenthesis" should "return the correct result for n = 0" in {
    GenerateParentheses.generateParenthesis(0) should be (List(""))
  }

  it should "return the correct result for n = 1" in {
    GenerateParentheses.generateParenthesis(1) should be (List("()"))
  }

  it should "return the correct result for n = 3" in {
    GenerateParentheses.generateParenthesis(3).toSet should be (Set("((()))", "(()())", "(())()", "()(())", "()()()"))
  }
}
