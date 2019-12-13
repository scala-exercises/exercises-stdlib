/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
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
  
  def `reverse lists` = {
    check(
      Test.testSuccess(
        Lists.reverseLists _,
        List(9, 7, 5, 3, 1) :: HNil
      )
    )
  }

  def `filter lists` = {
    check(
      Test.testSuccess(
        Lists.filterLists _,
        List(3, 9) :: List(2) :: List(1, 3, 5, 7, 9) :: HNil
      )
    )
  }

  def `map lists` = {
    check(
      Test.testSuccess(
        Lists.mapLists _,
        List(2, 6, 10, 14, 18) :: HNil
      )
    )
  }

  def `flatten lists` = {
    check(
      Test.testSuccess(
        Lists.flattenLists _,
        List(1, 2, 3, 4) :: List(1, 1, 4, 8) :: HNil
      )
    )
  }

  def `flatMap lists` = {
    check(
      Test.testSuccess(
        Lists.flatMapLists _,
        List(1, 1, 4, 8) :: true :: HNil
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
