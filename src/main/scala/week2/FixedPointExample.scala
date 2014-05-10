package week2

import math.abs

/**
 * Created by hamishdickson on 07/05/2014.
 *
 */
object FixedPointExample {
  /**
   * a number x is a fixed point if
   *
   * f(x) = x
   */

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def badSqrt(x: Double) =
    fixedPoint(y => x/y)(1.0) // sadly this doesn't converge

  // use some damping to stop oscillation
  def sqrt(x: Double) =
    fixedPoint(y => (y + x/y)/2)(1.0)

  /**
   * damping is really useful, so what does it look like as it's own function?
   */
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

  /**
   * very cool.
   */
  def sqrtAveDamp(x: Double) = fixedPoint(averageDamp(y => x/y))(1)
}
