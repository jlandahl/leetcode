package leetcode

class LongestPalindromicSubstringSpec extends Spec {
  "longestPalindrome" should "return the correct value" in {
    LongestPalindromicSubstring.longestPalindrome("babad") should be ("bab")
  }

  "menacher" should "return the correct value" in {
    LongestPalindromicSubstring.menacher("babad") should be ("bab")
  }
}
