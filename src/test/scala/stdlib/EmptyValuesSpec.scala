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

class EmptyValuesSpec extends RefSpec with Checkers {
  def `empty values` = {
    check(
      Test.testSuccess(
        EmptyValues.emptyValuesEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is equal to none` = {
    check(
      Test.testSuccess(
        EmptyValues.avoidingNullEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is identical to none` = {
    check(
      Test.testSuccess(
        EmptyValues.identicalNoneEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none to string` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToStringEmptyValues _,
        "None" :: HNil
      )
    )
  }

  def `none to list` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is empty` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none can be casted` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToAnyEmptyValues _,
        true :: true :: true :: HNil
      )
    )
  }

  def `none is an option` = {
    val theOption: Option[String] = None

    check(
      Test.testSuccess(
        EmptyValues.noneWithOptionEmptyValues _,
        true :: theOption :: HNil
      )
    )
  }

  def `some vs none` = {
    check(
      Test.testSuccess(
        EmptyValues.someAgainstNoneEmptyValues _,
        false :: false :: HNil
      )
    )
  }

  def `getOrElse on none` = {
    check(
      Test.testSuccess(
        EmptyValues.getOrElseEmptyValues _,
        "Some Value" :: "No Value" :: HNil
      )
    )
  }
}
