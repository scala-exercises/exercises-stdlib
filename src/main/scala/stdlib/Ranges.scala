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
 *   ranges
 */
object Ranges extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * A Range is an ordered sequence of integers that are equally spaced apart. For example, "1, 2,
   * 3" is a range, as is "5, 8, 11, 14". To create a range in Scala, use the predefined methods
   * `to`, `until`, and `by`. `1 to 3` generates "1, 2, 3" and `5 to 14 by 3` generates "5, 8, 11,
   * 14".
   *
   * If you want to create a range that is exclusive of its upper limit, then use `until` instead of
   * `to`: `1 until 3` generates "1, 2".
   *
   * Note that `Range(a, b, c)` is the same as `a until b by c`
   *
   * Ranges are represented in constant space, because they can be defined by just three numbers:
   * their start, their end, and the stepping value. Because of this representation, most operations
   * on ranges are extremely fast.
   *
   * A range's upper bound is not inclusive:
   */
  def upperNotInclusiveRangeExercises(res0: Int, res1: Int, res2: Int) = {
    val someNumbers = Range(0, 10)
    val second      = someNumbers(1)
    val last        = someNumbers.last

    someNumbers.size should be(res0)
    second should be(res1)
    last should be(res2)
  }

  /**
   * Ranges can be specified using 'until':
   */
  def untilRangeExercises(res0: Boolean) = {
    val someNumbers = Range(0, 10)
    val otherRange  = 0 until 10

    (someNumbers == otherRange) should be(res0)
  }

  /**
   * Range can specify a step for an increment:
   */
  def incrementsRangeExercises(res0: Int, res1: Int, res2: Int) = {
    val someNumbers = Range(2, 10, 3)
    val second      = someNumbers(1)
    val last        = someNumbers.last

    someNumbers.size should be(res0)
    second should be(res1)
    last should be(res2)
  }

  /**
   * A range does not include its upper bound, even in a step increment:
   */
  def upperInIncrementRangeExercises(res0: Boolean, res1: Boolean, res2: Boolean) = {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(res0)
    someNumbers.contains(32) should be(res1)
    someNumbers.contains(34) should be(res2)
  }

  /**
   * Range can specify to include its upper bound value:
   */
  def specifyUpperRangeExercises(res0: Boolean) = {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(res0)
  }

  /**
   * Inclusive ranges can be specified using 'to':
   */
  def inclusiveWithToRangeExercises(res0: Boolean) = {
    val someNumbers = Range(0, 34).inclusive
    val otherRange  = 0 to 34

    (someNumbers == otherRange) should be(res0)
  }

}
