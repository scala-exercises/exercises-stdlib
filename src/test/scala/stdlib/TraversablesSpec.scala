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

class TraversablesSpec extends RefSpec with Checkers {
  def `are at the top of collection hierarchy` = {
    check(
      Test.testSuccess(
        Traversables.topOfCollectionTraversables _,
        7 :: 8 :: HNil
      )
    )
  }

  def `can be mapped over` = {
    check(
      Test.testSuccess(
        Traversables.mapFunctionTraversables _,
        Option(24) :: HNil
      )
    )
  }

  def `can be flattened` = {
    check(
      Test.testSuccess(
        Traversables.flattenFunctionTraversables _,
        List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) :: HNil
      )
    )
  }

  def `can be flatmapped` = {
    check(
      Test.testSuccess(
        Traversables.flatMapFunctionTraversables _,
        List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40) :: HNil
      )
    )
  }

  def `can be collected` = {
    check(
      Test.testSuccess(
        Traversables.collectFunctionTraversables _,
        List(12, 18, 24, 42) :: HNil
      )
    )
  }

  def `can be collected part two` = {
    check(
      Test.testSuccess(
        Traversables.collectFunctionIITraversables _,
        List(12, 18, 28, 24, 36, 52, 42) :: HNil
      )
    )
  }

  def `foreach function` = {
    check(
      Test.testSuccess(
        Traversables.foreachFunctionTraversables _,
        List(4, 6, 7, 8, 9, 13, 14) :: HNil
      )
    )
  }

  def `to array function` = {
    check(
      Test.testSuccess(
        Traversables.toArrayFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to list function` = {
    check(
      Test.testSuccess(
        Traversables.toListFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to list function part two` = {
    check(
      Test.testSuccess(
        Traversables.toListFunctionIITraversables _,
        true :: HNil
      )
    )
  }

  def `to iterable function` = {
    check(
      Test.testSuccess(
        Traversables.toIterableFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to seq function` = {
    check(
      Test.testSuccess(
        Traversables.toSeqFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to indexed seq function` = {
    check(
      Test.testSuccess(
        Traversables.toIndexedSeqFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to stream function` = {
    check(
      Test.testSuccess(
        Traversables.toLazyListFunctionTraversables _,
        true :: LazyList(4, 6, 7) :: HNil
      )
    )
  }

  def `to set function` = {
    check(
      Test.testSuccess(
        Traversables.toSetFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to map function` = {
    check(
      Test.testSuccess(
        Traversables.toMapFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `to map function part two` = {
    check(
      Test.testSuccess(
        Traversables.toMapFunctionIITraversables _,
        true :: HNil
      )
    )
  }

  def `nonEmpty function` = {
    check(
      Test.testSuccess(
        Traversables.nonEmptyFunctionTraversables _,
        true :: false :: HNil
      )
    )
  }

  def `size function` = {
    check(
      Test.testSuccess(
        Traversables.sizeFunctionTraversables _,
        2 :: HNil
      )
    )
  }

  def `knownSize function` = {
    check(
      Test.testSuccess(
        Traversables.knownSizeFunctionTraversables _,
        2 :: -1 :: HNil
      )
    )
  }

  def `head function` = {
    check(
      Test.testSuccess(
        Traversables.headFunctionTraversables _,
        10 :: HNil
      )
    )
  }

  def `headOption function` = {
    val theNone: Option[Int] = None

    check(
      Test.testSuccess(
        Traversables.headOptionFunctionTraversables _,
        Option(10) :: theNone :: HNil
      )
    )
  }

  def `last function` = {
    check(
      Test.testSuccess(
        Traversables.lastFunctionTraversables _,
        22 :: HNil
      )
    )
  }

  def `lastOption function` = {
    val theNone: Option[Int] = None

    check(
      Test.testSuccess(
        Traversables.lastOptionFunctionTraversables _,
        Option(22) :: theNone :: HNil
      )
    )
  }

  def `find function` = {
    val theNone: Option[Int] = None

    check(
      Test.testSuccess(
        Traversables.findFunctionTraversables _,
        Option(19) :: theNone :: HNil
      )
    )
  }

  def `tail function` = {
    check(
      Test.testSuccess(
        Traversables.tailFunctionTraversables _,
        List(19, 45, 1, 22) :: HNil
      )
    )
  }

  def `init function` = {
    check(
      Test.testSuccess(
        Traversables.initFunctionTraversables _,
        List(10, 19, 45, 1) :: HNil
      )
    )
  }

  def `slice function` = {
    check(
      Test.testSuccess(
        Traversables.sliceFunctionTraversables _,
        List(19, 45) :: HNil
      )
    )
  }

  def `take function` = {
    check(
      Test.testSuccess(
        Traversables.takeFunctionTraversables _,
        List(10, 19, 45) :: HNil
      )
    )
  }

  def `take function part two` = {
    check(
      Test.testSuccess(
        Traversables.takeFunctionIITraversables _,
        List(2, 3, 4) :: HNil
      )
    )
  }

  def `drop function` = {
    check(
      Test.testSuccess(
        Traversables.dropFunctionTraversables _,
        List(8, 9, 10) :: HNil
      )
    )
  }

  def `takeWhile function` = {
    check(
      Test.testSuccess(
        Traversables.takeWhileFunctionTraversables _,
        List(87, 44, 5, 4) :: HNil
      )
    )
  }

  def `dropWhile function` = {
    check(
      Test.testSuccess(
        Traversables.dropWhileFunctionTraversables _,
        List(200, 10, 39, 100) :: HNil
      )
    )
  }

  def `filter function` = {
    check(
      Test.testSuccess(
        Traversables.filterFunctionTraversables _,
        Array(87, 44, 5, 4, 10, 39) :: HNil
      )
    )
  }

  def `filterNot function` = {
    check(
      Test.testSuccess(
        Traversables.filterNotFunctionTraversables _,
        Array(200, 100) :: HNil
      )
    )
  }

  def `splitAt function` = {
    check(
      Test.testSuccess(
        Traversables.splitAtFunctionTraversables _,
        Array(87, 44, 5) :: Array(4, 200, 10, 39, 100) :: HNil
      )
    )
  }

  def `span function` = {
    check(
      Test.testSuccess(
        Traversables.spanFunctionTraversables _,
        Array(87, 44, 5, 4) :: Array(200, 10, 39, 100) :: HNil
      )
    )
  }

  def `partition function` = {
    check(
      Test.testSuccess(
        Traversables.partitionFunctionTraversables _,
        Array(87, 44, 5, 4, 10, 39) :: Array(200, 100) :: HNil
      )
    )
  }

  def `groupBy function` = {
    check(
      Test.testSuccess(
        Traversables.groupByFunctionTraversables _,
        3 :: 2 :: HNil
      )
    )
  }

  def `forall function` = {
    check(
      Test.testSuccess(
        Traversables.forallFunctionTraversables _,
        false :: HNil
      )
    )
  }

  def `exists function` = {
    check(
      Test.testSuccess(
        Traversables.existsFunctionTraversables _,
        true :: HNil
      )
    )
  }

  def `count function` = {
    check(
      Test.testSuccess(
        Traversables.countFunctionTraversables _,
        6 :: HNil
      )
    )
  }

  def `foldLeft function` = {
    check(
      Test.testSuccess(
        Traversables.foldLeftFunctionTraversables _,
        -15 :: -15 :: -15 :: HNil
      )
    )
  }

  def `foldRight function` = {
    check(
      Test.testSuccess(
        Traversables.foldRightFunctionTraversables _,
        3 :: 3 :: 3 :: HNil
      )
    )
  }

  def `reduceLeft function` = {
    check(
      Test.testSuccess(
        Traversables.reduceLeftFunctionTraversables _,
        15 :: "DoReMeFaSoLaTeDo" :: HNil
      )
    )
  }

  def `reduceRight function` = {
    check(
      Test.testSuccess(
        Traversables.reduceRightFunctionTraversables _,
        15 :: "DoReMeFaSoLaTeDo" :: HNil
      )
    )
  }

  def `sum function and friends` = {
    check(
      Test.testSuccess(
        Traversables.sumFunctionTraversables _,
        15 :: 120 :: 5 :: 1 :: HNil
      )
    )
  }

  def `reduceRight as reduceLeft` = {
    check(
      Test.testSuccess(
        Traversables.reduceRightAsReduceLeft _,
        3 :: 3 :: 3 :: HNil
      )
    )
  }

  def `transpose function` = {
    check(
      Test.testSuccess(
        Traversables.transposeFunctionTraversables _,
        List(1, 4, 7) :: List(2, 5, 8) :: List(3, 6, 9) :: List(1, 4) :: HNil
      )
    )
  }

  def `mkString function` = {
    check(
      Test.testSuccess(
        Traversables.mkStringFunctionTraversables _,
        "1,2,3,4,5" :: HNil
      )
    )
  }

  def `mkString function part two` = {
    check(
      Test.testSuccess(
        Traversables.mkStringFunctionIITraversables _,
        ">1,2,3,4,5<" :: HNil
      )
    )
  }

  def `addString function` = {
    check(
      Test.testSuccess(
        Traversables.addStringFunctionTraversables _,
        "I want all numbers 6-12: 6,7,8,9,10,11,12" :: HNil
      )
    )
  }

}
