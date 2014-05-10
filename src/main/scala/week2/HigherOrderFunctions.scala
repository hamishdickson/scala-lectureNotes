package week2

/**
 * Created by hamishdickson on 07/05/2014.
 *
 */
object HigherOrderFunctions {

  /**
   * Sum of ints between a and b
   */
  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  }

  /**
   * sum of cubes between a and b
   */
  def cube(x: Int): Int = x * x * x

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0
    else cube(a) + sumCubes(a + 1, b)
  }

  /**
   * use a HOF for this
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  /**
   * Then the sums become
   */
  def id(x: Int) = x
  def sumInts1(a: Int, b: Int) = sum(id, a, b)

  def sumCubes1(a: Int, b: Int) = sum(cube, a, b)

  /**
   * anonymous functions
   */
  def sumInts2(a: Int, b: Int) = sum(x => x, a, b)
  def sumCube2(a: Int, b: Int) = sum(x => x * x * x, a, b)

  /**
   * sum tail recursive
   */
  def sumTailRecursive(f: Int => Int)(a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc // do this first
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0) // then this
  }
}
