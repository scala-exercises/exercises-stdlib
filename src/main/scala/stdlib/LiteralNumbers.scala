/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** @param name literal_numbers
 *
 */
object LiteralNumbers
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** Integer literals are 32-bit and can be created from decimals as well as hexadecimals:
   */
  def integerLiteralsLiteralNumbers(
      res0: Int,
      res1: Int,
      res2: Int,
      res3: Int,
      res4: Int,
      res5: Int,
      res6: Int) = {
    val a = 2
    val b = 31
    val c = 0x30F
    val e = 0
    val f = -2
    val g = -31
    val h = -0x30F
    a should be(res0)
    b should be(res1)
    c should be(res2) //Hint: 30F = 783
    e should be(res3)
    f should be(res4)
    g should be(res5)
    h should be(res6) //Hint: 30F = 783
  }

  /** Long literals are 64-bit. They are specified by appending an `L` at the end of the declaration:
   */
  def longLiteralsLiteralNumbers(
      res0: Long,
      res1: Long,
      res2: Long,
      res3: Long,
      res4: Long,
      res5: Long,
      res6: Long) = {
    val a = 2L
    val b = 31L
    val c = 0x30FL
    val e = 0L
    val f = -2L
    val g = -31L
    val h = -0x30FL

    a should be(res0)
    b should be(res1)
    c should be(res2) //Hint: 30F = 783
    e should be(res3)
    f should be(res4)
    g should be(res5)
    h should be(res6) //Hint: 30F = 783
  }

  /** Float and Double literals conform to [[https://en.wikipedia.org/wiki/IEEE_floating_point IEEE-754]]. Floats are 32-bit, while doubles are 64-bit.
   * Floats can be defined using a f or F suffix, while doubles use a d or D suffix.
   * Exponents are specified using e or E.
   */
  def floatsAndDoublesLiteralNumbers(
      res0: Double,
      res1: Double,
      res2: Double,
      res3: Double,
      res4: Double,
      res5: Double,
      res6: Double,
      res7: Double,
      res8: Double) = {
    val a = 3.0
    val b = 3.00
    val c = 2.73
    val d = 3f
    val e = 3.22d
    val f = 93e-9
    val g = 93E-9
    val h = 0.0
    val i = 9.23E-9D

    a should be(res0)
    b should be(res1)
    c should be(res2)
    d should be(res3)
    e should be(res4)
    f should be(res5)
    g should be(res6)
    h should be(res7)
    i should be(res8)
  }

}
