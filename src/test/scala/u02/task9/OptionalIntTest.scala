package u02.task9

import org.junit.*
import org.junit.Assert.*
import u02.myimplementations.task9.Optionals.*
import u02.myimplementations.task9.Optionals.OptionalInt.{filter, isEmpty, mapInt, orElse}

class OptionalIntTest:
  val empty = OptionalInt.Empty()
  val nonEmptyValue = 0
  val nonEmpty = OptionalInt.Just(nonEmptyValue)
  val plusOne: Int => Int = _ + 1

  @Test def emptyOptionalShouldBeEmpty(): Unit =
    assertTrue(isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    assertFalse(isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    assertEquals(0, orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    assertEquals(1, orElse(empty, 1))

  /** Task 5: do test for map * */
  @Test def emptyOptionalMappedShouldReturnEmpty(): Unit =
    val mappedEmpty = mapInt(empty)(plusOne)
    assertTrue(isEmpty(mappedEmpty))

  @Test def nonEmptyOptionalMappedShouldExecuteTheMapping(): Unit =
    val mappedNonEmpty = mapInt(nonEmpty)(plusOne)
    val expectedValue = plusOne(nonEmptyValue)
    val realValue = orElse(mappedNonEmpty, -1)
    assertEquals(expectedValue, realValue)

  @Test def filteredEmptyOptionalShouldBeEmpty(): Unit =
    assertTrue(isEmpty(filter(empty)(_ > 10)))

  @Test def filteredNonEmptyOptionalShouldBeEmptyWhenPredicateIsFalse(): Unit =
    assertTrue(isEmpty(filter(nonEmpty)(_ != nonEmptyValue)))

  @Test def filteredNonEmptyOptionalShouldBeNotBeEmptyWhenPredicateIsTrue(): Unit =
    assertFalse(isEmpty(filter(nonEmpty)(_ == nonEmptyValue)))