package week2

/**
 * Created by hamishdickson on 07/05/2014.
 *
 */
object
Currying {

  /**
   * sum tail recursive
   */
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0 // do this first
      else f(a) + sumF(a + 1, b)
    }
    sumF // then this
  }

  /**
   * this gives us
   */
  def sumInts = sum(x => x)
  def sumCubes = sum(x => x * x * x)

  def cube(x: Int): Int = x * x * x

  // then can use
  // sum (cube) (1, 10)

  /**
   * rewrite
   */
  def sum1(f: Int => Int)(a: Int, b: Int): Int =
    if (a < b) 0 else f(a) + sum(f)(a + 1, b)

  /**
   * product example
   */
  def product(f: Int => Int)(a: Int, b:Int): Int =
    if (a < b) 1
    else f(a) * product(f)(a + 1, b)

  def fact(n: Int) = product(x => x)(1, n)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}
