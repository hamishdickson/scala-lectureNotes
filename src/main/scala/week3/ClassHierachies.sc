object ClassHierachies {


  /**
   * Empty and NonEmpty both extend class IntSet
   * -> they "conform" to type IntSet
   * -> meaning they can be used anywhere IntSet can
   */

  /**
   * base classes - all the super classes
   *
   */

  /**
   * cool, you can have abstract classes
   *
   * pretty much the same as java - can't instantiated
   */
  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
  }

  /**
   * lets implement as a binary tree
   *
   * two possible trees:
   * 1. a tree for an empty set
   * 2. a tree consisting of an integer and two sub-trees
   *
   * Note: right node always higher than node above, left node always less
   */
  class Empty extends IntSet {
    override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
    override def contains(x: Int): Boolean = false

    override def toString = "."
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

    override def toString = "{" + left + elem + right + "}"
  }

  /**
   * cool - lets play with it!
   */
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4

}
