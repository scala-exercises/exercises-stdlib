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

class SequencesAndArraysSpec extends RefSpec with Checkers {
  def `list to array` = {
    check(
      Test.testSuccess(
        SequencesandArrays.sequentialCollectionSequencesandArrays _,
        1 :: 2 :: 3 :: HNil
      )
    )
  }

  def `seq to list` = {
    check(
      Test.testSuccess(
        SequencesandArrays.orderedElementsSequencesandArrays _,
        List(1, 2, 3) :: HNil
      )
    )
  }

  def `sequences with for comprehensions` = {
    check(
      Test.testSuccess(
        SequencesandArrays.fromForComprehensionSequencesandArrays _,
        List(1, 2, 3, 4) :: HNil
      )
    )
  }

  def `sequences with for comprehension and conditions` = {
    check(
      Test.testSuccess(
        SequencesandArrays.withConditionSequencesandArrays _,
        List(3, 6, 9) :: HNil
      )
    )
  }

  def `filtered sequences` = {
    check(
      Test.testSuccess(
        SequencesandArrays.filterPredicateSequencesandArrays _,
        "hello" :: "you" :: HNil
      )
    )
  }

  def `filtered arrays` = {
    check(
      Test.testSuccess(
        SequencesandArrays.filterArraySequencesandArrays _,
        "hello" :: "again" :: HNil
      )
    )
  }

  def `map over a sequence` = {
    check(
      Test.testSuccess(
        SequencesandArrays.mapValuesSequencesandArrays _,
        Seq("olleh", "dlrow") :: HNil
      )
    )
  }
}
