/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class UniformAccessPrincipleSpec extends Spec with Checkers {
  def `uniform access principle` = {
    check(
      Test.testSuccess(
        UniformAccessPrinciple.uniformAccessPrincipleUniformAccessPrinciple _,
        10 :: 11 :: HNil
      )
    )
  }

}
