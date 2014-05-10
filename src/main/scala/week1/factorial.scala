package week1

/**
 * Created by hamish dickson on 06/05/2014.
 *
 */
object factorial {
  def factorial(input: Int): Int = {
    def loop(acc: Int, in: Int): Int = {
      if (in == 0) acc
      else loop(acc * in, in - 1)
    }

    loop(1, input)
  }
}
