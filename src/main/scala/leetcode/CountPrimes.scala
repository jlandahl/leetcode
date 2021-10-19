package leetcode

object CountPrimes extends App {
  // Given an integer n, return the number of prime numbers that are strictly less than n.
  def countPrimes(n: Int): Int = {
    if (n < 2) {
      0
    } else {
      val isPrime = new java.util.BitSet(n)
      isPrime.set(2, n)  // start with 2..n set to true

      var i = 2L
      while (i * i <= n) {
        if (isPrime.get(i.toInt)) {
          ((i * i) to n by i).foreach(j => isPrime.clear(j.toInt))
        }
        i += 1
      }
      isPrime.cardinality()
    }
  }

  println(countPrimes(0))
  println(countPrimes(1))
  println(countPrimes(2))
  println(countPrimes(3))
  println(countPrimes(4))
  println(countPrimes(6))
  println(countPrimes(1000000))
}
