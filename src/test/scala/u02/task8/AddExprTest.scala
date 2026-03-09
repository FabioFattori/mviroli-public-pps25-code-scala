package u02.task8

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.{Arguments, MethodSource}
import u02.myimplementations.task8.Expr
import u02.task8.utils.AddExprBuilder

import java.util.stream.Stream
import scala.annotation.static

class AddExprTest extends AddExprBuilder:

  @ParameterizedTest
  @MethodSource(Array("csvAddProvider"))
  def testAddShow(constant1: Int, constant2: Int, expressionExpected: String): Unit =
    assertEquals(
      expressionExpected,
      Expr.show(exprAddBuilder(constant1, constant2))
    )

  @ParameterizedTest
  @MethodSource(Array("csvAddProvider"))
  def testAddEvaluate(constant1: Int, constant2: Int): Unit =
    assertEquals(
      constant1 + constant2,
      Expr.evaluate(exprAddBuilder(constant1, constant2))
    )

  @Test
  def testExpressionWithMultipleAddsIsShowCorrectly(): Unit = {
    assertEquals(expectedStringOfMultipleAddExpression, Expr.show(getExprWithMultipleAdds))
  }

  @Test
  def testExpressionWithMultipleAddsIsEvaluatedCorrectly(): Unit = {
    assertEquals(expectedResultOfEvaluationOfMultipleAddExpr, Expr.evaluate(getExprWithMultipleAdds))
  }

object AddExprTest {
  @static
  def csvAddProvider(): Stream[Arguments] =
    Stream.of(
      Arguments.of(0, 0, "0 + 0"),
      Arguments.of(1, 1, "1 + 1"),
      Arguments.of(2, 2, "2 + 2"),
      Arguments.of(3, 3, "3 + 3"),
      Arguments.of(4, 4, "4 + 4")
    )
}
