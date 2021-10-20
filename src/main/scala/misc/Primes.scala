package misc

object Primes extends App {
  // Lazy list of primes computed by brute force
  val primes: LazyList[Int] =
    2 #:: LazyList.from(3, 2).filter(n => primes.takeWhile(p => p * p <= n).forall(p => n % p > 0))

  /**
   * Number of primes less than or equal to a given number
   */
  def primeCount(n: Int): Int = {
    sieve(n).cardinality()
  }

  /*
    Sieve of Eratosthenes up to n
   */
  def sieve(n: Int): java.util.BitSet = {
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
    isPrime
  }

  println(primes.takeWhile(_ <= 12).toList) // List(2, 3, 5, 7, 11)
  println(primeCount(12)) // 5
}
