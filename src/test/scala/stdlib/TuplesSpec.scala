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

class TuplesSpec extends RefSpec with Checkers {
  def `are indexed` = {
    check(
      Test.testSuccess(
        Tuples.oneIndexedTuples _,
        "apple" :: "dog" :: HNil
      )
    )
  }

  def `are heterogeneous` = {
    check(
      Test.testSuccess(
        Tuples.mixedTypeTuples _,
        1 :: "five" :: HNil
      )
    )
  }

  def `support multiple assignment` = {
    check(
      Test.testSuccess(
        Tuples.assignVariablesTuples _,
        "Sean Rogers" :: 21 :: 3.5D :: HNil
      )
    )
  }

  def `two tuple elements can be swapped` = {
    check(
      Test.testSuccess(
        Tuples.swappedTuples _,
        3 :: "apple" :: HNil
      )
    )
  }
}
