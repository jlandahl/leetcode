package leetcode

class MoveZeroesSpec extends Spec {
  "moveZeroes" should "modify the array correctly" in {
    val a = Array(0,1,0,3,12)
    MoveZeroes.moveZeroes(a)
    a should be (Array(1, 3, 12, 0, 0))
  }
}
