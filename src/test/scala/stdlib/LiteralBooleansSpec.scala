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

class LiteralBooleansSpec extends Spec with Checkers {
  def `are either true or false` = {
    check(
      Test.testSuccess(
        LiteralBooleans.literalBooleanLiteralBooleans _,
        true :: false :: false :: true :: false :: false :: HNil
      )
    )
  }
}
