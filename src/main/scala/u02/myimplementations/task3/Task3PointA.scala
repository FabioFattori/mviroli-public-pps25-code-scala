package u02.myimplementations.task3

object Task3PointA extends Task3Point {
  def execute(): Unit = {
    def getSignString(x: Int): String = x match
      case n if n >= 0 => "positive"
      case _ => "negative"

    val getSignStringLambda: Int => String =
      case n if n >= 0 => "positive"
      case _ => "negative"

    println(getSignString(10))
    println(getSignString(0))
    println(getSignString(-10))
    println()
    println(getSignStringLambda(10))
    println(getSignStringLambda(0))
    println(getSignStringLambda(-10))
  }
}
