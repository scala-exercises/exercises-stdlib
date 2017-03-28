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

class PartialFunctionsSpec extends Spec with Checkers {
  def `partial functions` = {
    check(
      Test.testSuccess(
        PartialFunctions.partialFunctionPartialFunctions _,
        9 :: 8 :: HNil
      )
    )
  }

  def `partial functions with case` = {
    check(
      Test.testSuccess(
        PartialFunctions.caseStatementsPartialFunctions _,
        9 :: 8 :: HNil
      )
    )
  }

  def `andThen chaining` = {
    check(
      Test.testSuccess(
        PartialFunctions.andThenPartialFunctions _,
        14 :: 13 :: HNil
      )
    )
  }

  def `chaining of partial functions` = {
    check(
      Test.testSuccess(
        PartialFunctions.chainOfLogicPartialFunctions _,
        "Odd" :: "Even" :: HNil
      )
    )
  }
}
