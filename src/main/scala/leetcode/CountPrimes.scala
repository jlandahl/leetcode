package leetcode

object CountPrimes extends App {
  // Given an integer n, return the number of prime numbers that are strictly less than n.
  def countPrimes(n: Int): Int = {
    if (n < 2) {
      0
    } else {
      val isPrime = new java.util.BitSet(n)
      isPrime.set(2, n)  // start with 2..n set to true

      @annotation.tailrec
      def loop(i: Long): Unit = {
        val isquared = i * i
        if (isquared <= n) {
          (isquared to n by i).foreach(j => isPrime.clear(j.toInt))
          val next = isPrime.nextSetBit((i + 1).toInt)
          if (next != -1)
            loop(next)
        }
      }
      loop(2L)
      isPrime.cardinality()
    }
  }

  println(countPrimes(0))
  println(countPrimes(1))
  println(countPrimes(2))
  println(countPrimes(3))
  println(countPrimes(4))
  println(countPrimes(6))
  val time = System.currentTimeMillis()
  println(countPrimes(1_000_000_000))
  println(System.currentTimeMillis() - time)
}
