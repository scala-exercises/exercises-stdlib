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

class ExtractorsSpec extends RefSpec with Checkers {
  def `extractors` = {
    check(
      Test.testSuccess(
        Extractors.extractorsExtractors _,
        "Where's Batman?" :: HNil
      )
    )
  }

  def `unapply` = {
    check(
      Test.testSuccess(
        Extractors.calledUnapplyExtractors _,
        "Chevy" :: "Camaro" :: 1978 :: 120 :: HNil
      )
    )
  }

  def `pattern matching` = {
    check(
      Test.testSuccess(
        Extractors.patternMatchingExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `wildcards` = {
    check(
      Test.testSuccess(
        Extractors.withWildcardExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `multiple extractors` = {
    check(
      Test.testSuccess(
        Extractors.multipleUnapplyExtractors _,
        "c: Kurt, d: Vonnegut" :: HNil
      )
    )
  }

  def `any object as extractor` = {
    check(
      Test.testSuccess(
        Extractors.anyObjectExtractors _,
        "make: Chevy, model: Camaro" :: HNil
      )
    )
  }

  def `extractor in companion object` = {
    val theOption: Option[String] = None

    check(
      Test.testSuccess(
        Extractors.asAssignmentExtractors _,
        "Keerthi" :: theOption :: "Singri" :: HNil
      )
    )
  }

  def `unapply for pattern matching extractors` = {
    check(
      Test.testSuccess(
        Extractors.unapplyForPatternMatchingExtractors _,
        "I don't care, going on break" :: HNil
      )
    )
  }
}
