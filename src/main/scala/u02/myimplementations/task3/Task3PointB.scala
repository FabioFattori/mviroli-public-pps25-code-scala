package u02.myimplementations.task3

object Task3PointB extends Task3Point {
  override def execute(): Unit = {
    def neg(pred: String => Boolean): String => Boolean = !pred(_)

    val negLambda: (String => Boolean) => String => Boolean = f => !f(_)

    val empty: String => Boolean = _ == ""
    val notEmpty = neg(empty)
    val notEmptyLambda = negLambda(empty)

    println("Should Be false => " + notEmpty(""))
    println("Should Be true => " + notEmpty("foo"))
    println()
    println("Should Be false => " + notEmptyLambda(""))
    println("Should Be true => " + notEmptyLambda("foo"))
  }
}
