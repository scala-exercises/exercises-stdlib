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

class NamedAndDefaultArgumentsSpec extends RefSpec with Checkers {
  val Arguments = NamedandDefaultArguments

  def `class without parameters` = {
    check(
      Test.testSuccess(
        Arguments.classWithoutParametersNamedandDefaultArguments _,
        255 :: 0 :: 0 :: HNil
      )
    )
  }

  def `default arguments` = {
    check(
      Test.testSuccess(
        Arguments.defaultArgumentsNamedandDefaultArguments _,
        0 :: 255 :: 0 :: HNil
      )
    )
  }

  def `arguments in any order` = {
    check(
      Test.testSuccess(
        Arguments.anyOrderNamedandDefaultArguments _,
        100 :: 100 :: 100 :: HNil
      )
    )
  }

  def `access to class parameters` = {
    check(
      Test.testSuccess(
        Arguments.accessClassParametersNamedandDefaultArguments _,
        10 :: 90 :: 30 :: HNil
      )
    )
  }

  def `parameters in class definition` = {
    check(
      Test.testSuccess(
        Arguments.defaultClassArgumentsNamedandDefaultArguments _,
        0 :: 325 :: 100 :: HNil
      )
    )
  }

  def `functional default parameters` = {
    check(
      Test.testSuccess(
        Arguments.functionalDefaulParametersNamedandDefaultArguments _,
        10 :: 25 :: HNil
      )
    )
  }
}
