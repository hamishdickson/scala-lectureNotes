package week5.lecture3

/**
 * Created by hamishdickson on 10/06/2014.
 *
 */
object mergesort {
  def msort[T](xs: List[T])(ord: Ordering): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case(Nil, ys) => ys
        case(xs, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }

  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "pair")

  msort(nums)(Ordering.Int)
  msort(fruits)(Ordering.String)
}