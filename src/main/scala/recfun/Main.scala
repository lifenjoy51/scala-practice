package recfun
import common._

object Main {
  def main(args: Array[String]) {

    //ex1
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    //ex2
    println("Parentheses Balancing")
    val b = balance("(if (zero? x) max (/ 1 x))".toList)
    println(b)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def find(remains: List[Char], cnt: Int): Int = {
      if (cnt < 0) return 0
      if (remains.isEmpty) 0
      else {
        if (remains.head == '(') 1 + find(remains.tail, cnt + 1)
        else if (remains.head == ')') -1 + find(remains.tail, cnt - 1)
        else 0 + find(remains.tail, cnt)
      }
    }

    if (find(chars, 0) == 0) return true else return false
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???

}
