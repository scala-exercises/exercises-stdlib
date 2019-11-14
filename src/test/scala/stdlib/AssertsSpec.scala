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

class AssertsSpec extends RefSpec with Checkers {
  def `scalatest asserts` =
    check(Test.testSuccess(Asserts.scalaTestAsserts _, true :: HNil))

  def `boolean asserts` =
    check(Test.testSuccess(Asserts.booleanAsserts _, 4 :: HNil))

  def `values asserts` =
    check(Test.testSuccess(Asserts.valuesAsserts _, 2 :: HNil))
}
