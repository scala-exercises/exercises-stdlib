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

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapeless.HNil

class HigherOrderFunctionsSpec extends RefSpec with Checkers {
  def `anonymous function` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.meetLambdaHigherOrderFunctions _,
        4 :: 4 :: 5 :: 6 :: 2 :: 4 :: HNil
      )
    )
  }

  def `anonymous function with different syntax` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.differentLookHigherOrderFunctions _,
        6 :: HNil
      )
    )
  }

  def `anonymous function with closure` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.meetClosureHigherOrderFunctions _,
        11 :: 12 :: HNil
      )
    )
  }

  def `anonymous functions hold the environment` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.holdEnvironmentHigherOrderFunctions _,
        13 :: 14 :: HNil
      )
    )
  }

  def `returning functions` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.returningFunctionHigherOrderFunctions _,
        true :: 5 :: 10 :: HNil
      )
    )
  }

  def `returning anonymous functions` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.returningAnonymousFunctionHigherOrderFunctions _,
        true :: 5 :: 10 :: HNil
      )
    )
  }

  def `is instance of method` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.isInstanceOfMethodHigherOrderFunctions _,
        true :: HNil
      )
    )
  }

  def `function as a parameter` = {
    check(
      Test
        .testSuccess(
          HigherOrderFunctions.functionAsParameterHigherOrderFunctions _,
          List("ABC", "XYZ", "123") :: List("abc", "xyz", "123") ::
            List("My name is John", "My name is Mark") :: List(5, 6, 7) :: HNil
        )
    )
  }
}
