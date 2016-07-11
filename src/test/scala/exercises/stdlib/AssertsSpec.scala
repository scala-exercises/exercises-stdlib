package exercises

import stdlib._
import shapeless.HNil

import org.scalatest.Spec
import org.scalatest.prop.Checkers
import org.scalaexercises.Test

import org.scalacheck.Shapeless._

class AssertsSpec extends Spec with Checkers {
  def `scalatest asserts` = {
    check(Test.testSuccess(Asserts.scalaTestAsserts _, true :: HNil))
  }

  def `boolean asserts` = {
    check(Test.testSuccess(Asserts.booleanAsserts _, 4 :: HNil))
  }

  def `values asserts` = {
    check(Test.testSuccess(Asserts.valuesAsserts _, 2 :: HNil))
  }
}
