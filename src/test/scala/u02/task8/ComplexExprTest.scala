package u02.task8

import org.junit.Assert.assertEquals
import org.junit.Test
import u02.myimplementations.task8.Expr
import u02.task8.utils.{AddExprBuilder, MultiplyExprBuilder}

class ComplexExprTest extends AddExprBuilder, MultiplyExprBuilder {
  val x1 = 4
  val x2 = 2

  def getComplexExpr: Expr =
    val firstAdd = exprAddBuilder(x1, x2)
    val secondAdd = exprAddBuilder(x2, x1)
    val firstMultiply = exprMultiplyBuilder(x1, x2)
    val secondMultiply = exprMultiplyBuilder(x2, x1)
    val multiplyWithAdds = Expr.Multiply(firstAdd, secondAdd)
    val addWithMultiplies = Expr.Add(firstMultiply, secondMultiply)

    Expr.Add(multiplyWithAdds, addWithMultiplies)

  @Test
  def testEvaluationOfComplexAddAndMultiplyExpr(): Unit = {
    val expectedExpressionResult = ((x1 + x2) * (x2 + x1)) + ((x1 * x2) + (x2 * x1))
    val finalExpression = getComplexExpr

    assertEquals(expectedExpressionResult, Expr.evaluate(finalExpression))
  }


  @Test
  def testShowOfComplexAddAndMultiplyExpr(): Unit = {
    val expectedExpressionResult = s"$x1 + $x2 * $x2 + $x1 + $x1 * $x2 + $x2 * $x1"
    val finalExpression = getComplexExpr

    assertEquals(expectedExpressionResult, Expr.show(finalExpression))
  }
}
