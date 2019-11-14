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

class HigherOrderFunctionsSpec extends RefSpec with Checkers {
  def `anonymous function` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.meetLambdaHigherOrderFunctions _,
        4 :: 4 :: 5 :: 6 :: 2 :: 4 :: HNil
      )
    )
  }

  def `anonymous function with different syntax` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.differentLookHigherOrderFunctions _,
        6 :: HNil
      )
    )
  }

  def `anonymous function with closure` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.meetClosureHigherOrderFunctions _,
        11 :: 12 :: HNil
      )
    )
  }

  def `anonymous functions hold the environment` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.holdEnvironmentHigherOrderFunctions _,
        13 :: 14 :: HNil
      )
    )
  }

  def `returning functions` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.returningFunctionHigherOrderFunctions _,
        true :: 5 :: 10 :: HNil
      )
    )
  }

  def `returning anonymous functions` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.returningAnonymousFunctionHigherOrderFunctions _,
        true :: 5 :: 10 :: HNil
      )
    )
  }

  def `is instance of method` = {
    check(
      Test.testSuccess(
        HigherOrderFunctions.isInstanceOfMethodHigherOrderFunctions _,
        true :: HNil
      )
    )
  }

  def `function as a parameter` = {
    check(
      Test
        .testSuccess(
          HigherOrderFunctions.functionAsParameterHigherOrderFunctions _,
          List("ABC", "XYZ", "123") :: List("abc", "xyz", "123") ::
            List("My name is John", "My name is Mark") :: List(5, 6, 7) :: HNil
        )
    )
  }
}
