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

class PatternMatchingSpec extends RefSpec with Checkers {
  def `pattern matching` = {
    check(
      Test.testSuccess(
        PatternMatching.patternMatchingMechanismPatternMatching _,
        2 :: HNil
      )
    )
  }

  def `pattern matching with complex result` = {
    check(
      Test.testSuccess(
        PatternMatching.returnComplexPatternMatching _,
        0 :: 0 :: 255 :: HNil
      )
    )
  }

  def `pattern matching with complex expressions` = {
    check(
      Test.testSuccess(
        PatternMatching.complexExpressionsPatternMatching _,
        "Mama eating porridge" :: HNil
      )
    )
  }

  def `pattern matching with wildcard parts` = {
    check(
      Test.testSuccess(
        PatternMatching.wildcardParsPatternMatching _,
        "eating" :: "sitting" :: HNil
      )
    )
  }

  def `pattern matching with substitution in parts` = {
    check(
      Test.testSuccess(
        PatternMatching.substitutePartsPatternMatching _,
        "Papa said someone's been eating my porridge" :: "Mama said someone's been sitting in my chair" :: HNil
      )
    )
  }

  def `pattern matching with scoped variables` = {
    check(
      Test.testSuccess(
        PatternMatching.createCaseStatementPatternMatching _,
        "eating" :: "sitting" :: "eating" :: "what?" :: HNil
      )
    )
  }

  def `pattern matching with parameterized variables` = {
    check(
      Test.testSuccess(
        PatternMatching.stableVariablePatternMatching _,
        true :: false :: true :: HNil
      )
    )
  }

  def `pattern matching lists` = {
    check(
      Test.testSuccess(
        PatternMatching.againstListsPatternMatching _,
        2 :: HNil
      )
    )
  }

  def `pattern matching lists part two` = {
    check(
      Test.testSuccess(
        PatternMatching.againstListsIIPatternMatching _,
        2 :: HNil
      )
    )
  }

  def `pattern matching lists part three` = {
    check(
      Test.testSuccess(
        PatternMatching.againstListsIIIPatternMatching _,
        0 :: HNil
      )
    )
  }

  def `pattern matching lists part four` = {
    check(
      Test.testSuccess(
        PatternMatching.againstListsIVPatternMatching _,
        0 :: HNil
      )
    )
  }

  def `pattern matching lists part five` = {
    check(
      Test.testSuccess(
        PatternMatching.againstListsVPatternMatching _,
        true :: HNil
      )
    )
  }

}
