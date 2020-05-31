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

class PartiallyAppliedFunctionsSpec extends RefSpec with Checkers {
  def `partially applied functions` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.partiallyAppliedPartiallyAppliedFunctions _,
        17 :: 15 :: HNil
      )
    )
  }

  def `accept any number of arguments` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.anyNumberArgumentsPartiallyAppliedFunctions _,
        15 :: 15 :: HNil
      )
    )
  }

  def `currying` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.curryingPartiallyAppliedFunctions _,
        true :: 20 :: 6 :: 8 :: 16 :: HNil
      )
    )
  }

  def `specialization` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.specializedVersionPartiallyAppliedFunctions _,
        List(12, 20, 2) :: List(11, 5, 3, 13) :: HNil
      )
    )
  }

  def `composing` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.curriedForComposition _,
        7 :: 9 :: HNil
      )
    )
  }
}
