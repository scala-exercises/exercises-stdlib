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

class ByNameParameterSpec extends RefSpec with Checkers {
  def `takes unit by name parameter` = {
    val right: Either[Throwable, Int] = Right(29)

    check(
      Test.testSuccess(
        ByNameParameter.takesUnitByNameParameter _,
        right :: HNil
      )
    )
  }

  def `takes parameters by name` = {
    val right: Either[Throwable, Int] = Right(69)

    check(
      Test.testSuccess(
        ByNameParameter.byNameParameter _,
        right :: HNil
      )
    )
  }

  def `apply parameters` = {
    check(
      Test.testSuccess(
        ByNameParameter.withApplyByNameParameter _,
        "retzelpay" :: HNil
      )
    )
  }
}
