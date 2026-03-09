package u02.myimplementations.task5

object Task5 extends App {
  private def compose(f: Int => Int, g: Int => Int)(x: Int): Int = f(g(x))

  println(compose(_ - 1, _ * 2)(5))
}
