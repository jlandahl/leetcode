package leetcode

class RotateArraySpec extends Spec {
  "rotate" should "modify the array correctly" in {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    RotateArray.rotate(array, 3)
    array should be (Array(5, 6, 7, 1, 2, 3, 4))
  }
}
