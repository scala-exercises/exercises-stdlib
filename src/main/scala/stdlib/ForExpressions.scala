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
 *   for_expressions
 */
object ForExpressions
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * `for` expressions can nest, with later generators varying more rapidly than earlier ones:
   */
  def canBeNestedForExpressions(res0: Int, res1: Int) = {
    val xValues = 1 to 4
    val yValues = 1 to 2
    val coordinates = for {
      x <- xValues
      y <- yValues
    } yield (x, y)
    coordinates(4) should be((res0, res1))
  }

  /**
   * Using `for` we can make more readable code:
   */
  def readableCodeForExpressions(res0: List[Int]) = {
    val nums = List(List(1), List(2), List(3), List(4), List(5))

    val result = for {
      numList <- nums
      num     <- numList
      if (num % 2 == 0)
    } yield (num)

    result should be(res0)

    // Which is the same as
    nums.flatMap(numList => numList).filter(_ % 2 == 0) should be(result)

    // or the same as
    nums.flatten.filter(_ % 2 == 0) should be(result)

  }

}
