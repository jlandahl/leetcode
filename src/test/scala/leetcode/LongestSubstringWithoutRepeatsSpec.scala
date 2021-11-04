package leetcode

class LongestSubstringWithoutRepeatsSpec extends Spec {
  "lengthOfLongestSubstring" should "return the correct value" in {
    LongestSubstringWithoutRepeats.lengthOfLongestSubstring("dvdf") should be (3)
  }
}
