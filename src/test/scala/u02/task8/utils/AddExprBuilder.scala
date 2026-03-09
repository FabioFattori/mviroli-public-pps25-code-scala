package u02.task8.utils

import u02.myimplementations.task8.Expr

trait AddExprBuilder {
  val constantUsedForAllTheMultipleAdds: Int = 5
  
  val expectedStringOfMultipleAddExpression : String =
    val c = constantUsedForAllTheMultipleAdds
    s"$c + $c + $c + $c + $c + $c + $c + $c"
    
  val expectedResultOfEvaluationOfMultipleAddExpr: Int = constantUsedForAllTheMultipleAdds * 8

  def getExprWithMultipleAdds: Expr.Add =
    val simpleAdd =
      exprAddBuilder(constantUsedForAllTheMultipleAdds, constantUsedForAllTheMultipleAdds)

    Expr.Add(
      Expr.Add(simpleAdd, simpleAdd),
      Expr.Add(simpleAdd, simpleAdd),
    )

  def exprAddBuilder(constant1: Int, constant2: Int): Expr.Add =
    Expr.Add(Expr.Literal(constant1), Expr.Literal(constant2))
}
