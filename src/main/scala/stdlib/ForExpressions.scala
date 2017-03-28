/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name for_expressions
 *
 */
object ForExpressions extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** `for` expressions can nest, with later generators varying more rapidly than earlier ones:
   */
  def canBeNestedForExpressions(res0: Int, res1: Int) {
    val xValues = 1 to 4
    val yValues = 1 to 2
    val coordinates = for {
      x ← xValues
      y ← yValues
    } yield (x, y)
    coordinates(4) should be(res0, res1)
  }

  /** Using `for` we can make more readable code:
   */
  def readableCodeForExpressions(res0: List[Int]) {
    val nums = List(List(1), List(2), List(3), List(4), List(5))

    val result = for {
      numList ← nums
      num     ← numList
      if (num % 2 == 0)
    } yield (num)

    result should be(res0)

    // Which is the same as
    nums.flatMap(numList ⇒ numList).filter(_ % 2 == 0) should be(result)

    // or the same as
    nums.flatten.filter(_ % 2 == 0) should be(result)

  }

}
