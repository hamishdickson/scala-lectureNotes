// in scala you can replace any method with an infix parameter

/**
 * note that in scala, precedence is given by
 *
 * (all letters)
 * |
 * &#94;
 * &
 * < >
 * &#61; !
 * :
 * + -
 * * / %
 * (all other special characters)
 */

object rationals3 {
  val x = new Rational(1, 3)
  x.numer
  val bob = x + new Rational(3, 4)
  bob.numer
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  val a = x - y - z
  y + y
  x < y
  x max y // cool - in java you would have to have x.max(y)

  new Rational(2)
  // so it sounds like this should be outside the object .. but I
  // can't get it to work
  class Rational(x: Int, y: Int) {
    /**
     * Would like to return the simplest possible rational number
     * best place to simplify is in the constructor
     */

    // this is a explicit constructor in scala
    def this(x: Int) = this(x, 1)

    // test performed when class initialized
    /**
     * require is used to enforce a precondition (rather than an assert, which is used
     * to check the code in the function itself)
     */
    require(y != 0, "denominator must be non zero")

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // this is an un-explicit constructor
    def numer = x
    def denom = y

    def < (that: Rational) = numer * that.denom < that.numer * denom

    def max(that: Rational) = if (this < that) that else this

    def + (that: Rational) =
      new Rational(
        this.numer * that.denom + that.numer * this.denom,
        this.denom * that.denom
      )

    override def toString = {
      val g = gcd(numer, denom)
      this.numer / g + "/" + this.denom / g
    }

    /**
     * unary_ lets you prefix - special thing in scala
     */
    def unary_- : Rational = new Rational(-numer, denom)

    def - (that: Rational) = this + -that
  }
}

