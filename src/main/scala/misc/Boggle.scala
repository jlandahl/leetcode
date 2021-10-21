package misc
/*
  O A A N
  E T A E
  I H K R
  I F L V

  OAT
  TOE
*/

object Boggle {

  def main(args: Array[String]): Unit = {
    choices(0, 0).foreach(println)
  }

  def find(word: String, letters: Array[Array[Char]]): Boolean = {
    def loop(i: Int, row: Int, col: Int): Boolean = {
      if (row >= 0 && row < letters.length && col >= 0 && col < letters(0).length) {
        if (i < word.length) {
          if (word(i) == letters(row)(col)) {
            choices(row, col).exists { case (rowDelta, colDelta) => loop(i + 1, row + rowDelta, col + colDelta) }
          } else {
            false
          }
        } else {
          true
        }
      } else {
        false
      }
    }
    val results = for {
      row <- letters.indices
      col <- letters(0).indices
    } yield loop(0, row, col)
    results.exists(identity)
  }

  def choices(row: Int, col: Int): List[(Int, Int)] = {
    for {
      r <- List(row - 1, row, row + 1)
      c <- List(col - 1, col, col + 1)
      if !(r == row && c == col)
    } yield (r, c)
  }
}