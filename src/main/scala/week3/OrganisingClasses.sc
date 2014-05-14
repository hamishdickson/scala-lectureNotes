/**
 * note _ for all
 */
import week3._

object OrganisingClasses {
  /**
   * trait
   *
   * scala is single inheritance
   *
   * a trait is like an abstract class
   */
  trait Planar {
    def height: Int // abstract
    def width: Int // abstract
    def surface = height * width
  }

  /**
   * classes can inherit from multiple traits
   */
  // class Square extends Shape with Planar with Movable ...

  // traits like an interface, but with implemtations
  // traits cannot have parameters

  /**
   * exceptions are the same as java
   */
  def error(msg: String) = throw new Error(msg)
}