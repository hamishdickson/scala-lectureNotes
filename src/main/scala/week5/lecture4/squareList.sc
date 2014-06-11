object squareList {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  }

  def squareList2(xs: List[Int]): List[Int] = xs map (x => x * x)
}