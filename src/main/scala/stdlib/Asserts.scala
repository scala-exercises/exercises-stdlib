/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name asserts
 */
object Asserts extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** ScalaTest makes three assertions available by default in any style trait. You can use:
   *
   *  - `assert` for general assertions;
   *  - `assertResult` to differentiate expected from actual values;
   *  - `intercept` to ensure a bit of code throws an expected exception.
   *
   * In any Scala program, you can write assertions by invoking `assert` and passing in a `Boolean` expression:
   *
   * {{{
   * val left = 2
   * val right = 1
   * assert(left == right)
   * }}}
   *
   * If the passed expression is `true`, `assert` will return normally. If `false`,
   * Scala's `assert` will complete abruptly with an `AssertionError`. This behavior is provided by
   * the `assert` method defined in object `Predef`, whose members are implicitly imported into every Scala source file.
   *
   *
   * ScalaTest provides a domain specific language (DSL) for expressing assertions in tests
   * using the word `should`. ScalaTest matchers provides five different ways to check equality, each designed to address a different need. They are:
   *
   * {{{
   * result should equal (3) // can customize equality
   * result should === (3)   // can customize equality and enforce type constraints
   * result should be (3)    // cannot customize equality, so fastest to compile
   * result shouldEqual 3    // can customize equality, no parentheses required
   * result shouldBe 3       // cannot customize equality, so fastest to compile, no parentheses required
   * }}}
   *
   * Come on, your turn: true and false values can be compared with should matchers:
   */
  def scalaTestAsserts(res0: Boolean) {
    true should be(res0)
  }

  /** Booleans in asserts can test equality:
   */
  def booleanAsserts(res0: Int) {
    val v1 = 4
    v1 shouldEqual res0

    /** `shouldEqual` is an assertion. It is from ScalaTest, not from the Scala language. */
  }

  /** Sometimes we expect you to fill in the values:
   */
  def valuesAsserts(res0: Int) {
    assert(res0 == 1 + 1)
  }

}
