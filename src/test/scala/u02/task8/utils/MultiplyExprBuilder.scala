package u02.task8.utils

import u02.myimplementations.task8.Expr

trait MultiplyExprBuilder {
  val constantUsedForAllTheMultipleMultiply: Int = 2

  val expectedResultOfEvaluationOfMultipleMultiplyExpr: Int = 256

  val expectedStringOfMultipleMultiplyExpression: String =
    val c = constantUsedForAllTheMultipleMultiply
    s"$c * $c * $c * $c * $c * $c * $c * $c"

  def getExprWithMultipleMultiply: Expr.Multiply =
    val simpleMultiply =
      exprMultiplyBuilder(constantUsedForAllTheMultipleMultiply, constantUsedForAllTheMultipleMultiply)

    Expr.Multiply(
      Expr.Multiply(simpleMultiply, simpleMultiply),
      Expr.Multiply(simpleMultiply, simpleMultiply),
    )
  
  def exprMultiplyBuilder(constant1:Int, constant2:Int) : Expr.Multiply =
    Expr.Multiply(Expr.Literal(constant1), Expr.Literal(constant2))
}
