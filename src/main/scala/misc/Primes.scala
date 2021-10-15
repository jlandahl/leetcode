package misc

object Primes extends App {
  val primes: LazyList[Int] =
    2 #:: LazyList.from(3, 2).filter(n => primes.takeWhile(p => p * p <= n).forall(p => n % p > 0))

  /**
   * Number of primes less than or equal to a given number
   */
  def primeCount(n: Int): Int = {
    primes.takeWhile(_ <= n).size
  }

  println(primes.takeWhile(_ <= 12).toList) // List(2, 3, 5, 7, 11)
  println(primeCount(12)) // 5
}
