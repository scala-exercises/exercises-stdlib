/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class PartiallyAppliedFunctionsSpec extends Spec with Checkers {
  def `partially applied functions` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.partiallyAppliedPartiallyAppliedFunctions _,
        17 :: 15 :: HNil
      )
    )
  }

  def `accept any number of arguments` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.anyNumberArgumentsPartiallyAppliedFunctions _,
        15 :: 15 :: HNil
      )
    )
  }

  def `currying` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.curryingPartiallyAppliedFunctions _,
        true :: 20 :: 6 :: 8 :: 16 :: HNil
      )
    )
  }

  def `specialization` = {
    check(
      Test.testSuccess(
        PartiallyAppliedFunctions.specializedVersionPartiallyAppliedFunctions _,
        List(12, 20, 2) :: List(11, 5, 3, 13) :: HNil
      )
    )
  }
}
