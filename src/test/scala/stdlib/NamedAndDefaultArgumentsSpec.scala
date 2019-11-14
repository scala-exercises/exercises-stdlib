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

class NamedAndDefaultArgumentsSpec extends RefSpec with Checkers {
  val Arguments = NamedandDefaultArguments

  def `class without parameters` = {
    check(
      Test.testSuccess(
        Arguments.classWithoutParametersNamedandDefaultArguments _,
        255 :: 0 :: 0 :: HNil
      )
    )
  }

  def `default arguments` = {
    check(
      Test.testSuccess(
        Arguments.defaultArgumentsNamedandDefaultArguments _,
        0 :: 255 :: 0 :: HNil
      )
    )
  }

  def `arguments in any order` = {
    check(
      Test.testSuccess(
        Arguments.anyOrderNamedandDefaultArguments _,
        100 :: 100 :: 100 :: HNil
      )
    )
  }

  def `access to class parameters` = {
    check(
      Test.testSuccess(
        Arguments.accessClassParametersNamedandDefaultArguments _,
        10 :: 90 :: 30 :: HNil
      )
    )
  }

  def `parameters in class definition` = {
    check(
      Test.testSuccess(
        Arguments.defaultClassArgumentsNamedandDefaultArguments _,
        0 :: 325 :: 100 :: HNil
      )
    )
  }

  def `functional default parameters` = {
    check(
      Test.testSuccess(
        Arguments.functionalDefaulParametersNamedandDefaultArguments _,
        10 :: 25 :: HNil
      )
    )
  }
}
