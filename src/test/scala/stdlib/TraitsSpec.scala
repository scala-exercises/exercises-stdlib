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

class TraitsSpec extends RefSpec with Checkers {
  def `are similar to interfaces` = {
    check(
      Test.testSuccess(
        Traits.similarToInterfacesTraits _,
        "An unfortunate moose stampede occurred" :: HNil
      )
    )
  }

  def `classes can only extend one class or trait` = {
    check(
      Test.testSuccess(
        Traits.extendsFromOneTraits _,
        "An unfortunate woodchuck stampede occurred" :: HNil
      )
    )
  }

  def `are polymorphic` = {
    check(
      Test.testSuccess(
        Traits.polymorphicTraits _,
        true :: true :: true :: true :: HNil
      )
    )
  }

}
