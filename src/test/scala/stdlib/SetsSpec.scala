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

class SetsSpec extends RefSpec with Checkers {
  def `have no duplicates` = {
    check(
      Test.testSuccess(
        Sets.noDuplicatesSets _,
        4 :: HNil
      )
    )
  }

  def `all their values are distinct` = {
    check(
      Test.testSuccess(
        Sets.distinctValuesSets _,
        3 :: HNil
      )
    )
  }

  def `adding values to sets` = {
    check(
      Test.testSuccess(
        Sets.easilyAddedSets _,
        true :: false :: HNil
      )
    )
  }

  def `sets accept mixed types` = {
    check(
      Test.testSuccess(
        Sets.mixedTypeSets _,
        true :: false :: HNil
      )
    )
  }

  def `we can check for member existence` = {
    check(
      Test.testSuccess(
        Sets.checkExistenceSets _,
        true :: false :: HNil
      )
    )
  }

  def `we can remove members` = {
    check(
      Test.testSuccess(
        Sets.easilyRemovedSets _,
        false :: true :: HNil
      )
    )
  }

  def `we can remove multiple members` = {
    check(
      Test.testSuccess(
        Sets.multipleRemovingSets _,
        false :: true :: 2 :: HNil
      )
    )
  }

  def `we can remove values that are not part of the set` = {
    check(
      Test.testSuccess(
        Sets.nonexistentRemovalSets _,
        true :: HNil
      )
    )
  }

  def `set intersection` = {
    check(
      Test.testSuccess(
        Sets.easilyIntersectedSets _,
        true :: HNil
      )
    )
  }

  def `set union` = {
    check(
      Test.testSuccess(
        Sets.easilyJoinedSets _,
        true :: HNil
      )
    )
  }

  def `subsets` = {
    check(
      Test.testSuccess(
        Sets.subsetSets _,
        false :: true :: HNil
      )
    )
  }

  def `set difference` = {
    check(
      Test.testSuccess(
        Sets.easilyObtainedDifferencesSets _,
        true :: HNil
      )
    )
  }

  def `set equality` = {
    check(
      Test.testSuccess(
        Sets.equivalencySets _,
        true :: HNil
      )
    )
  }
}
