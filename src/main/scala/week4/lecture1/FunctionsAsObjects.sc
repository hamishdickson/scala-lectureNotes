object FunctionsAsObjects {
  /**
   * function A => B is really an abbreviation for a class
   *
   * trait Function[A, B] {
   *   def apply(x: A): B
   * }
   *
   * and
   *
   * (x: Int) => x * x
   *
   * is expanded as
   * { class AnonFun extends Function1[Int, Int] {
   *    def apply(x: Int) = x * x
   *   }
   *   new AnonFun
   * }
   */
}