object ClassHierachies2 {

  /**
   * example of overriding variables
   */
  abstract class Base {
    def foo = 1
    def bar: Int
  }

  class Sub extends Base {
    override def foo = 1
    def bar = 3
  }

  /////

  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
  }

  /**
   * so to create a singleton object - just use an object (not a class!)
   *
   * singleton objects are values -
   */
  object Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  }
  
}
