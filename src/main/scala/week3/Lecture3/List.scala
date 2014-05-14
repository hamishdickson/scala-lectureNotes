package week3.Lecture3

import java.util.NoSuchElementException

/**
 * Created by hamishdickson on 14/05/2014.
 *
 * Note [] is generics in scala
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