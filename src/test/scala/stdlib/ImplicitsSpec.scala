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

class ImplicitsSpec extends RefSpec with Checkers {
  def `implicit parameters` = {
    check(
      Test.testSuccess(
        Implicits.implicitsParametersImplicits _,
        true :: false :: HNil
      )
    )
  }

  def `imported implicits` = {
    check(
      Test.testSuccess(
        Implicits.importedImplicits _,
        true :: false :: HNil
      )
    )
  }

  def `type conversion implicits` = {
    check(
      Test.testSuccess(
        Implicits.convertTypeImplicits _,
        true :: false :: true :: true :: true :: HNil
      )
    )
  }

  def `implicits for default parameters` = {
    val fstAnswer: BigDecimal = 1020

    check(
      Test.testSuccess(
        Implicits.asDefaultImplicits _,
        fstAnswer :: HNil
      )
    )
  }

  def `multiple implicits for default parameters` = {
    check(
      Test.testSuccess(
        Implicits.listOfImplicitsImplicits _,
        "1020 Dollars" :: HNil
      )
    )
  }

  def `default arguments instead of implicits` = {
    check(
      Test.testSuccess(
        Implicits.defaultArgumentsImplicits _,
        "1020 Dollars" :: "2850 Dollars" :: HNil
      )
    )
  }
}
