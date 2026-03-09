package u02.myimplementations.task4

object Task4 extends App {
  val p1: Int => Int => Int => Boolean = x => y => z => x + y <= z

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x + y <= z

  private def p3(x: Int)(y: Int)(z: Int): Boolean = x + y <= z

  private def p4(x: Int, y: Int, z: Int): Boolean = x + y <= z

  val x1 = 1
  val y1 = 2
  private val z1 = x1 + y1

  val x2 = 3
  val y2 = 4
  private val z2 = 1

  println("should be true => " + p1(x1)(y1)(z1))
  println("should be false => " + p1(x2)(y2)(z2))

  println("should be true => " + p2(x1, y1, z1))
  println("should be false => " + p2(x2, y2, z2))

  println("should be true => " + p3(x1)(y1)(z1))
  println("should be false => " + p3(x2)(y2)(z2))

  println("should be true => " + p4(x1, y1, z1))
  println("should be false => " + p4(x2, y2, z2))
}
