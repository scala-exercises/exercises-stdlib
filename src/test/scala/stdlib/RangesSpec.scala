/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
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

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapeless.HNil

class RangesSpec extends RefSpec with Checkers {
  def `upper bounds are not inclusive` = {
    check(
      Test.testSuccess(
        Ranges.upperNotInclusiveRangeExercises _,
        10 :: 1 :: 9 :: HNil
      )
    )
  }

  def `until for creating ranges` = {
    check(
      Test.testSuccess(
        Ranges.untilRangeExercises _,
        true :: HNil
      )
    )
  }

  def `ranges with step` = {
    check(
      Test.testSuccess(
        Ranges.incrementsRangeExercises _,
        3 :: 5 :: 8 :: HNil
      )
    )
  }

  def `ranges with step dont include upper bound` = {
    check(
      Test.testSuccess(
        Ranges.upperInIncrementRangeExercises _,
        false :: true :: false :: HNil
      )
    )
  }

  def `ranges which include upper bound` = {
    check(
      Test.testSuccess(
        Ranges.specifyUpperRangeExercises _,
        true :: HNil
      )
    )
  }

  def `ranges which include upper bound with to` = {
    check(
      Test.testSuccess(
        Ranges.inclusiveWithToRangeExercises _,
        true :: HNil
      )
    )
  }
}
