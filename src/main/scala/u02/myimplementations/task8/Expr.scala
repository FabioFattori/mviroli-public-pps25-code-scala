package u02.myimplementations.task8

enum Expr {
  case Literal(constant: Int)
  case Add(expr1: Expr, expr2: Expr)
  case Multiply(expr1: Expr, expr2: Expr)
}

object Expr {
  def evaluate(expr: Expr): Int = expr match
    case Literal(constant) => constant
    case Add(expr1, expr2) => evaluate(expr1) + evaluate(expr2)
    case Multiply(expr1, expr2) => evaluate(expr1) * evaluate(expr2)

  def show(expr: Expr): String =
    expr match
      case Literal(constant) => s"$constant"
      case Add(expr1, expr2) => s"${show(expr1)} + ${show(expr2)}"
      case Multiply(expr1, expr2) => s"${show(expr1)} * ${show(expr2)}"
}
