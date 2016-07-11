package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

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
