package leetcode

object FirstBadVersion {
  def main(args: Array[String]): Unit = {
    println(firstBadVersion(300))
  }

  def firstBadVersion(n: Int): Int = {
    @annotation.tailrec
    def loop(left: Int, right: Int): Int = {
      if (left == right) {
        left
      } else {
        val mid = (right - left) / 2 + left
        if (isBadVersion(mid))
          loop(left, mid)
        else
          loop(mid + 1, right)
      }
    }
    loop(1, n)
  }

  def isBadVersion(version: Int): Boolean = {
    version >= 243
  }
}