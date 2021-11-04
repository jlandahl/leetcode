package leetcode

class CountPrimesSpec extends Spec {
  "countPrimes" should "return 0 if n < 2" in {
    CountPrimes.countPrimes(-1) should be (0)
    CountPrimes.countPrimes(0) should be (0)
    CountPrimes.countPrimes(1) should be (0)
  }

  it should "return 5 when n is 12" in {
    CountPrimes.countPrimes(12) should be (5)
  }

  it should "return 78498 when n is 1000000" in {
    CountPrimes.countPrimes(1000000) should be (78498)
  }
}
