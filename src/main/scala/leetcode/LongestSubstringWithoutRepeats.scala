package leetcode

object LongestSubstringWithoutRepeats {
  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("dvdf"))
  }

  // Given a string s, find the length of the longest substring without repeating characters.

  def lengthOfLongestSubstring(s: String): Int = {
    val (_, _, len) = s.zipWithIndex.foldLeft(Map.empty[Char, Int], 0, 0) { case ((map, start, len), (c, i)) =>
      val pos = map.getOrElse(c, -1)
      val newStart = if (pos >= start)
        pos + 1
      else
        start
      val newLen = len.max(i - newStart + 1)
      (map.updated(c, i), newStart, newLen)
    }
    len
  }
}