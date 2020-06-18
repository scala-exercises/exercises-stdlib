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

class ListsSpec extends RefSpec with Checkers {
  def `are homogeneous` = {
    check(
      Test.testSuccess(
        Lists.similarToArraysLists _,
        false :: HNil
      )
    )
  }

  def `can be compared for equality` = {
    check(
      Test.testSuccess(
        Lists.sameContentLists _,
        true :: HNil
      )
    )
  }

  def `empty lists are the same regardless of the types they hold` = {
    check(
      Test.testSuccess(
        Lists.nilListsLists _,
        true :: true :: true :: true :: true :: true :: HNil
      )
    )
  }

  def `lists are easily created` = {
    check(
      Test.testSuccess(
        Lists.easilyCreatedLists _,
        1 :: 2 :: 3 :: HNil
      )
    )
  }

  def `head and tail` = {
    check(
      Test.testSuccess(
        Lists.headAndTailLists _,
        1 :: 2 :: 3 :: HNil
      )
    )
  }

  def `access by position` = {
    check(
      Test.testSuccess(
        Lists.byPositionLists _,
        1 :: 5 :: 9 :: HNil
      )
    )
  }

  def `lists are immutable` = {
    check(
      Test.testSuccess(
        Lists.areImmutableLists _,
        1 :: 3 :: 7 :: 9 :: HNil
      )
    )
  }

  def `useful list methods` = {
    check(
      Test.testSuccess(
        Lists.usefulMethodsLists _,
        5 :: List(9, 7, 5, 3, 1) :: List(2, 6, 10, 14, 18) :: List(3, 9) :: HNil
      )
    )
  }

  def `wildcard for anonymous functions` = {
    check(
      Test.testSuccess(
        Lists.wildcardAsShorthandLists _,
        2 :: 4 :: 6 :: 2 :: HNil
      )
    )
  }

  def `functions over lists` = {
    check(
      Test.testSuccess(
        Lists.functionsOverListsLists _,
        2 :: 4 :: 6 :: 1 :: 3 :: HNil
      )
    )
  }

  def `reducing lists` = {
    check(
      Test.testSuccess(
        Lists.reducingListsLists _,
        16 :: 105 :: HNil
      )
    )
  }

  def `foldLeft on lists` = {
    check(
      Test.testSuccess(
        Lists.foldLeftLists _,
        16 :: 26 :: 105 :: 0 :: HNil
      )
    )
  }

  def `lists from range` = {
    check(
      Test.testSuccess(
        Lists.fromRangeLists _,
        List(1, 2, 3, 4, 5) :: HNil
      )
    )
  }

  def `add elements` = {
    check(
      Test.testSuccess(
        Lists.addElementsLists _,
        List(0, 1, 3, 5, 7) :: HNil
      )
    )
  }

  def `concatenate lists` = {
    check(
      Test.testSuccess(
        Lists.concatenateLists _,
        List(1, 3, 5, 7) :: List(1, 3) :: HNil
      )
    )
  }

  def `lists share tails` = {
    check(
      Test.testSuccess(
        Lists.reuseTailsLists _,
        1 :: 2 :: 3 :: List(2, 3) :: List(3) :: List.empty[Int] :: HNil
      )
    )
  }
}
