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

import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapeless.HNil

// FIXME: get rid of this if possible
import org.scalacheck.ScalacheckShapeless._

class InfixPrefixAndPostfixOperatorsSpec extends RefSpec with Checkers {
  val Operators = InfixPrefixandPostfixOperators

  def `single parameter infix operators` = {
    check(
      Test.testSuccess(
        Operators.singleParameterInfixPrefixandPostfixOperators _,
        7 :: 7 :: HNil
      )
    )
  }

  def `infix operators dont work with two params` = {
    check(
      Test.testSuccess(
        Operators.notWithTwoInfixPrefixandPostfixOperators _,
        6 :: 25 :: HNil
      )
    )
  }

  def `postfix operators` = {
    check(
      Test.testSuccess(
        Operators.postfixOperatorInfixPrefixandPostfixOperators _,
        "1f" :: HNil
      )
    )
  }

  def `unary operators` = {
    check(
      Test.testSuccess(
        Operators.startsWithUnaryInfixPrefixandPostfixOperators _,
        -31 :: HNil
      )
    )
  }

  def `defining your own operators` = {
    check(
      Test.testSuccess(
        Operators.ourOwnOperatorInfixPrefixandPostfixOperators _,
        "on" :: "off" :: HNil
      )
    )
  }
}
