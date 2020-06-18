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

class MapsSpec extends RefSpec with Checkers {
  def `size` = {
    check(
      Test.testSuccess(
        Maps.keyAndValueMaps _,
        4 :: HNil
      )
    )
  }

  def `repeated keys` = {
    check(
      Test.testSuccess(
        Maps.distinctPairingsMaps _,
        3 :: HNil
      )
    )
  }

  def `adding to maps` = {
    check(
      Test.testSuccess(
        Maps.easilyAddedMaps _,
        true :: HNil
      )
    )
  }

  def `iterating over maps` = {
    check(
      Test.testSuccess(
        Maps.canBeIteratedMaps _,
        3 :: "Michigan" :: "Wisconsin" :: HNil
      )
    )
  }

  def `map key access` = {
    check(
      Test.testSuccess(
        Maps.mayBeAccessedMaps _,
        "Michigan" :: "Iowa" :: HNil
      )
    )
  }

  def `duplicate keys` = {
    check(
      Test.testSuccess(
        Maps.duplicatedKeyInsertionMaps _,
        3 :: "Meechigan" :: HNil
      )
    )
  }

  def `mixed key types` = {
    check(
      Test.testSuccess(
        Maps.mixedTypeKeysMaps _,
        "MI" :: "MI" :: HNil
      )
    )
  }

  def `map default value access` = {
    check(
      Test.testSuccess(
        Maps.defaultValuesMayBeProvidedMaps _,
        "missing data" :: "missing data" :: HNil
      )
    )
  }

  def `map element removal` = {
    check(
      Test.testSuccess(
        Maps.easilyRemovedMaps _,
        false :: true :: HNil
      )
    )
  }

  def `multiple key removal` = {
    check(
      Test.testSuccess(
        Maps.removedInMultipleMaps _,
        false :: true :: true :: 2 :: 4 :: HNil
      )
    )
  }

  def `non-existent element removal` = {
    check(
      Test.testSuccess(
        Maps.attemptedRemovalMaps _,
        true :: HNil
      )
    )
  }

  def `maps dont have ordering` = {
    check(
      Test.testSuccess(
        Maps.orderIndependentMaps _,
        true :: HNil
      )
    )
  }
}
