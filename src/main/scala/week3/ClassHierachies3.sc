object ClassHierachies3 {

  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
    def union(other: IntSet): IntSet
  }

  class Empty extends IntSet {
    override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
    override def contains(x: Int): Boolean = false

    override def toString = "."

    override def union(other: IntSet): IntSet = other
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x < elem) right contains x
      else true

    def incl(x: Int): IntSet =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, right, right incl x)
      else this

    //note this terminates because left < right
    override def union(other: IntSet): IntSet =
      ((left union right) union other) incl elem
  }

  /**
   * scala uses "dynamic method dispatch
   */
}