package u02.task8

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.{Arguments, MethodSource}
import u02.myimplementations.task8.Expr
import u02.task8.utils.MultiplyExprBuilder

import java.util.stream.Stream
import scala.annotation.static

class MultiplyExprTest extends MultiplyExprBuilder:
  @ParameterizedTest
  @MethodSource(Array("csvMultiplyProvider"))
  def testAddShow(constant1:Int, constant2:Int, expressionExpected: String): Unit =
    assertEquals(
      expressionExpected,
      Expr.show(exprMultiplyBuilder(constant1, constant2))
    )

  @ParameterizedTest
  @MethodSource(Array("csvMultiplyProvider"))
  def testAddEvaluate(constant1: Int, constant2: Int): Unit =
    assertEquals(
      constant1 * constant2,
      Expr.evaluate(exprMultiplyBuilder(constant1, constant2))
    )

  @Test
  def testExpressionWithMultipleAddsIsShowCorrectly(): Unit = {
    assertEquals(expectedStringOfMultipleMultiplyExpression, Expr.show(getExprWithMultipleMultiply))
  }

  @Test
  def testExpressionWithMultipleAddsIsEvaluatedCorrectly(): Unit = {
    assertEquals(expectedResultOfEvaluationOfMultipleMultiplyExpr, Expr.evaluate(getExprWithMultipleMultiply))
  }

object MultiplyExprTest {
  @static
  def csvMultiplyProvider(): Stream[Arguments] =
    Stream.of(
      Arguments.of(0, 0, "0 * 0"),
      Arguments.of(1, 1, "1 * 1"),
      Arguments.of(2, 2, "2 * 2"),
      Arguments.of(3, 3, "3 * 3"),
      Arguments.of(4, 4, "4 * 4")
    )
}
