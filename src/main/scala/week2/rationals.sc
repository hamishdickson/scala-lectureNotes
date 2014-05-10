object rationals {
  val x = new Rational(1, 3)
  x.numer
  val bob = x.add(new Rational(3, 4))
  bob.numer
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  val a = x.sub(y).sub(z)

  y.add(y)

  // so it sounds like this should be outside the object .. but I
  // can't get it to work
  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

    def add(that: Rational) =
      new Rational(
        this.numer * that.denom + that.numer * this.denom,
        this.denom * that.denom
      )

    override def toString = this.numer + "/" + this.denom

    def neg: Rational = new Rational(-numer, denom)

    def sub(that: Rational) = add(that.neg)
  }
}

