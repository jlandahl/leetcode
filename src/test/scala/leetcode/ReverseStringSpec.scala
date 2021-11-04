package leetcode

class ReverseStringSpec extends Spec {
  "reverseString" should "modify the array correctly" in {
    val arr1 = "hello".toCharArray
    ReverseString.reverseString(arr1)
    arr1.mkString should be ("olleh")

    val arr2 = "Hannah".toCharArray
    ReverseString.reverseString(arr2)
    arr2.mkString should be ("hannaH")
  }
}
