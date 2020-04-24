/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** @param name literal_booleans
 *
 */
object LiteralBooleans
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** Boolean literals are either true or false, using the `true` or `false` keyword:
   */
  def literalBooleanLiteralBooleans(
      res0: Boolean,
      res1: Boolean,
      res2: Boolean,
      res3: Boolean,
      res4: Boolean,
      res5: Boolean
  ) = {
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(res0)
    b should be(res1)
    c should be(res2)
    d should be(res3)
    e should be(res4)
    f should be(res5)
  }

}
