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

class IterablesSpec extends RefSpec with Checkers {
  def `collection iterables` = {
    check(
      Test.testSuccess(
        Iterables.collectionIterablesIterables _,
        3 :: HNil
      )
    )
  }

  def `grouped iterables` = {
    check(
      Test.testSuccess(
        Iterables.groupedIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: 21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `sliding iterables` = {
    check(
      Test.testSuccess(
        Iterables.slidingIterables _,
        3 :: 5 :: 9 :: 5 :: 9 :: 11 :: 9 :: 11 :: 15 :: HNil
      )
    )
  }

  def `sliding window iterables` = {
    check(
      Test.testSuccess(
        Iterables.slidingWindowIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: 21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `take right on iterables` = {
    check(
      Test.testSuccess(
        Iterables.takeRightIterables _,
        21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `drop right on iterables` = {
    check(
      Test.testSuccess(
        Iterables.dropRightIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: HNil
      )
    )
  }

  def `zipping iterables` = {
    check(
      Test.testSuccess(
        Iterables.zipIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: 9 :: "Stella" :: HNil
      )
    )
  }

  def `zipping different size iterables` = {
    check(
      Test.testSuccess(
        Iterables.sameSizeZipIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: HNil
      )
    )
  }

  def `zipping with zipAll` = {
    check(
      Test.testSuccess(
        Iterables.zipAllIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: 9 :: 3 :: "Bob" :: 5 :: "Ann" :: "Stella" :: HNil
      )
    )
  }

  def `zipping with index` = {
    check(
      Test.testSuccess(
        Iterables.zipWithIndexIterables _,
        "Manny" :: "Moe" :: 1 :: "Jack" :: HNil
      )
    )
  }

  def `zipping with sameElements` = {
    check(
      Test.testSuccess(
        Iterables.sameElementsIterables _,
        true :: false :: true :: false :: HNil
      )
    )
  }
}
