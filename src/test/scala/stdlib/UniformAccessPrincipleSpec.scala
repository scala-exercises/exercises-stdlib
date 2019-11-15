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

class UniformAccessPrincipleSpec extends RefSpec with Checkers {
  def `uniform access principle` = {
    check(
      Test.testSuccess(
        UniformAccessPrinciple.uniformAccessPrincipleUniformAccessPrinciple _,
        10 :: 11 :: HNil
      )
    )
  }

}
