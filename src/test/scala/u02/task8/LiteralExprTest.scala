package u02.task8

import org.junit.Assert.assertEquals
import u02.myimplementations.task8.Expr
import u02.myimplementations.task8.Expr.{evaluate, show}
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.{Arguments, MethodSource}

import java.util.stream.Stream
import scala.annotation.static

class LiteralExprTest:
  @ParameterizedTest
  @MethodSource(Array("csvLiteralProvider"))
  def testLiteralShow(constantValue: Int, expectedString: String): Unit =
    assertEquals(expectedString, show(Expr.Literal(constantValue)))

  @ParameterizedTest
  @MethodSource(Array("csvLiteralProvider"))
  def testLiteralEvaluate(constantValue: Int, expectedValue: Int): Unit =
    assertEquals(expectedValue, evaluate(Expr.Literal(constantValue)))

object LiteralExprTest {
  @static
  def csvLiteralProvider(): Stream[Arguments] =
    Stream.of(
      Arguments.of(0, "0"),
      Arguments.of(1, "1"),
      Arguments.of(2, "2"),
      Arguments.of(3, "3"),
      Arguments.of(4, "4")
    )
}