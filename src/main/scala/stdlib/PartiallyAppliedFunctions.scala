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

/**
 * @param name
 *   partially_applied_functions
 */
object PartiallyAppliedFunctions
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * A partially applied function is a function that you do not apply any or all the arguments,
   * creating another function. This partially applied function doesn't apply any arguments.
   */
  def partiallyAppliedPartiallyAppliedFunctions(res0: Int, res1: Int) = {
    def sum(a: Int, b: Int, c: Int) = a + b + c
    val sum3                        = sum _
    sum3(1, 9, 7) should be(res0)
    sum(4, 5, 6) should be(res1)
  }

  /**
   * Partially applied functions can replace any number of arguments:
   */
  def anyNumberArgumentsPartiallyAppliedFunctions(res0: Int, res1: Int) = {
    def sum(a: Int, b: Int, c: Int) = a + b + c
    val sumC                        = sum(1, 10, _: Int)
    sumC(4) should be(res0)
    sum(4, 5, 6) should be(res1)
  }

  /**
   * Currying is a technique to transform a function with multiple parameters into multiple
   * functions which each take one parameter:
   */
  def curryingPartiallyAppliedFunctions(
      res0: Boolean,
      res1: Int,
      res2: Int,
      res3: Int,
      res4: Int
  ) = {
    def multiply(x: Int, y: Int) = x * y
    (multiply _).isInstanceOf[Function2[_, _, _]] should be(res0)
    val multiplyCurried = (multiply _).curried
    multiply(4, 5) should be(res1)
    multiplyCurried(3)(2) should be(res2)
    val multiplyCurriedFour = multiplyCurried(4)
    multiplyCurriedFour(2) should be(res3)
    multiplyCurriedFour(4) should be(res4)
  }

  /**
   * Currying allows you to create specialized versions of generalized functions:
   */
  def specializedVersionPartiallyAppliedFunctions(res0: List[Int], res1: List[Int]) = {
    def customFilter(f: Int => Boolean)(xs: List[Int]) =
      xs filter f
    def onlyEven(x: Int) = x % 2 == 0
    val xs               = List(12, 11, 5, 20, 3, 13, 2)
    customFilter(onlyEven)(xs) should be(res0)

    val onlyEvenFilter = customFilter(onlyEven) _
    onlyEvenFilter(xs) should be(res1)
  }

}
