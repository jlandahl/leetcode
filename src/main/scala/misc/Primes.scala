package misc

object Primes extends App {
  // Lazy list of primes computed by brute force
  val primes: LazyList[Int] =
    2 #:: LazyList.from(3, 2).filter(n => primes.takeWhile(p => p * p <= n).forall(p => n % p > 0))

  /**
   * Number of primes less than or equal to a given number
   */
  def primeCount(n: Int): Int = {
    primes.takeWhile(_ <= n).size
  }

  /*
    Sieve of Eratosthenes up to n
   */
  def sieve(n: Int): Seq[Int] = {
    val primes = collection.mutable.ListBuffer.empty[Int]

    val isPrime = new java.util.BitSet(n)
    isPrime.set(2, n)  // start with 2..n set to true

    (2 to n).foreach { i =>
      if (isPrime.get(i)) {
        primes.addOne(i)
        ((i * i) to n by i).foreach(isPrime.clear)
      }
    }
    primes.toSeq
  }

  println(primes.takeWhile(_ <= 12).toList) // List(2, 3, 5, 7, 11)
  println(primeCount(12)) // 5

  println(sieve(12)) // List(2, 3, 5, 7, 11)
}
