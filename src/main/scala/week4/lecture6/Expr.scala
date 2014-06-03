package week4.lecture6

/**
 * Created by hamishdickson on 01/06/2014.
 */
trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr