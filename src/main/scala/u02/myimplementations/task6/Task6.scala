package u02.myimplementations.task6

import scala.annotation.tailrec

object Task6 extends App {
  private def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  @tailrec
  private def powerWithTail(base: Double, exponent: Int, currentProd: Double = 1): Double = exponent match
    case 0 => currentProd
    case _ => powerWithTail(base, exponent - 1, currentProd * base)

  println(s"2^3 => ${power(2, 3)}")
  println(s"5^2 => ${power(5, 2)}")

  println(s"2^3 => ${powerWithTail(2, 3)}")
  println(s"5^2 => ${powerWithTail(5, 2)}")
}
