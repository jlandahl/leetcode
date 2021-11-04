package leetcode

object FirstBadVersion {
  // You are a product manager and currently leading a team to develop a new product.
  // Unfortunately, the latest version of your product fails the quality check. Since each version
  // is developed based on the previous version, all the versions after a bad version are also bad.
  //
  // Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
  // which causes all the following ones to be bad.
  //
  // You are given an API bool isBadVersion(version) which returns whether version is bad.
  // Implement a function to find the first bad version. You should minimize the number of calls
  // to the API.

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