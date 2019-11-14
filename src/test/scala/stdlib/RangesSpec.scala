/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatest.prop.Checkers
import shapeless.HNil

class RangesSpec extends RefSpec with Checkers {
  def `upper bounds are not inclusive` = {
    check(
      Test.testSuccess(
        Ranges.upperNotInclusiveRangeExercises _,
        10 :: 1 :: 9 :: HNil
      )
    )
  }

  def `until for creating ranges` = {
    check(
      Test.testSuccess(
        Ranges.untilRangeExercises _,
        true :: HNil
      )
    )
  }

  def `ranges with step` = {
    check(
      Test.testSuccess(
        Ranges.incrementsRangeExercises _,
        3 :: 5 :: 8 :: HNil
      )
    )
  }

  def `ranges with step dont include upper bound` = {
    check(
      Test.testSuccess(
        Ranges.upperInIncrementRangeExercises _,
        false :: true :: false :: HNil
      )
    )
  }

  def `ranges which include upper bound` = {
    check(
      Test.testSuccess(
        Ranges.specifyUpperRangeExercises _,
        true :: HNil
      )
    )
  }

  def `ranges which include upper bound with to` = {
    check(
      Test.testSuccess(
        Ranges.inclusiveWithToRangeExercises _,
        true :: HNil
      )
    )
  }
}
