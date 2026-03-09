package u02.myimplementations.task7

import scala.annotation.tailrec

object Task7 extends App {
  @tailrec
  private def reverse(toReverse: Int, currentReversedNumber: String = ""): String = {
    def buildStringWithNewChar(char: Any, string: String): String = s"$string$char"
    val numberToString = toReverse.toString

    numberToString.length match
      case 0 => currentReversedNumber
      case 1 => buildStringWithNewChar(numberToString, currentReversedNumber)
      case _ =>
        val indexOfNextChar = numberToString.length - 1
        val char = numberToString.charAt(indexOfNextChar)
        reverse(numberToString.replaceFirst(s"$char", "").toInt, buildStringWithNewChar(char, currentReversedNumber))
  }

  val x1 = 54321
  val x2 = 987654321
  println(s"revers of $x1 : ${reverse(x1)}")
  println(s"revers of $x2 : ${reverse(x2)}")
}
