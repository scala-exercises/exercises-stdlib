/*
 * Copyright 2016-2020 47 Degrees Open Source <https://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package stdlib

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.language.postfixOps

/**
 * @param name infix_prefix_and_postfix_operators
 */
object InfixPrefixandPostfixOperators
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * Any method which takes a single parameter can be used as an infix operator: `a.m(b)` can also be written as `a m b`.
   */
  def singleParameterInfixPrefixandPostfixOperators(res0: Int, res1: Int) = {
    val g: Int = 3
    (g + 4) should be(res0) // + is an infix operator
    g.+(4) should be(res1)  // same result but not using the infix operator
  }

  /**
   * Infix operators do NOT work if an object has a method that takes two parameters:
   */
  def notWithTwoInfixPrefixandPostfixOperators(res0: Int, res1: Int) = {
    val g: String = "Check out the big brains on Brad!"

    g indexOf 'o' should be(res0) //indexOf(Char) can be used as an infix operator

    // g indexOf 'o', 4 should be (6) //indexOf(Char, Int) cannot be used as an infix operator

    g.indexOf('o', 7) should be(res1) //indexOf(Char, Int) must use standard java/scala calls
  }

  /**
   * Any method which does not require a parameter can be used as a postfix operator: `a.m` can be written as `a m`.
   *
   * For instance, `a.+(b)` is equivalent to `a + b` and `a.!` is the same as `a!`.
   *
   * Postfix operators have lower precedence than infix operators, so:
   *  - `foo bar baz` means `foo.bar(baz)`.
   *  - `foo bar baz bam` means `(foo.bar(baz)).bam`
   *  - `foo bar baz bam bim` means `(foo.bar(baz)).bam(bim)`.
   */
  def postfixOperatorInfixPrefixandPostfixOperators(res0: String) = {
    val g: Int = 31
    (g toHexString) should be(
      res0
    ) //toHexString takes no params therefore can be called as a postfix operator.
    //Hint: The answer is "1f"
  }

  /**
   * Prefix operators work if an object has a method name that starts with `unary_` :
   */
  def startsWithUnaryInfixPrefixandPostfixOperators(res0: Int) = {
    val g: Int = 31
    (-g) should be(res0)
  }

  /**
   * Here's how to create a prefix operator for our own class. The only identifiers that can be used as prefix operators are `+`, `-`, `!`, and `~`:
   */
  def ourOwnOperatorInfixPrefixandPostfixOperators(res0: String, res1: String) = {
    class Stereo {
      def unary_+ = "on"

      def unary_- = "off"
    }

    val stereo = new Stereo
    (+stereo) should be(res0)
    (-stereo) should be(res1)
  }

}
