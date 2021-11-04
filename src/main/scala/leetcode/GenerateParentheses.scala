package leetcode

object GenerateParentheses {
  // Given n pairs of parentheses, write a function to generate all combinations of
  // well-formed parentheses.

  def generateParenthesis(n: Int): List[String] = {
    import collection.mutable

    def generate(result: mutable.ListBuffer[String], cur: mutable.StringBuilder, open: Int, close: Int): Unit = {
      if (cur.size == n * 2) {
        result.addOne(cur.toString())
      } else {
        if (open < n) {
          cur.append("(")
          generate(result, cur, open + 1, close)
          cur.deleteCharAt(cur.size - 1)
        }
        if (close < open) {
          cur.append(")")
          generate(result, cur, open, close + 1)
          cur.deleteCharAt(cur.size - 1)
        }
      }
    }

    val result = mutable.ListBuffer.empty[String]
    generate(result, new mutable.StringBuilder, 0, 0)
    result.toList
  }
}
