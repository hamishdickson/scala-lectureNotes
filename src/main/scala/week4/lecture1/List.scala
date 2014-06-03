package week4.lecture1

/**
 * Created by hamishdickson on 22/05/2014.
 *
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// Adding val here lets you use it as a var
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  // note that head and tail are implemented in the args
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))

  def apply[T]() = new Nil
}