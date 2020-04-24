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

class OptionsSpec extends RefSpec with Checkers {
  def `none and some` = {
    val theNone: Option[String] = None

    check(
      Test.testSuccess(
        Options.conceptOptions _,
        Option("I am wrapped in something") :: theNone :: HNil
      )
    )
  }

  def `getOrElse method` = {
    check(
      Test.testSuccess(
        Options.getOrElseOptions _,
        "Found value" :: "No value" :: "default function" :: HNil
      )
    )
  }

  def `isEmpty method` = {
    check(
      Test.testSuccess(
        Options.isEmptyOptions _,
        false :: true :: HNil
      )
    )
  }

  def `pattern matching` = {
    check(
      Test.testSuccess(
        Options.matchOptions _,
        20d :: 0d :: HNil
      )
    )
  }

  def `mapping` = {
    val theNone: Option[Double] = None

    check(
      Test.testSuccess(
        Options.mapOptions _,
        Option(4.5d) :: theNone :: HNil
      )
    )
  }

  def `folding` = {
    check(
      Test.testSuccess(
        Options.foldOptions _,
        9 :: 0 :: HNil
      )
    )
  }
}
