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

class ParentClassesSpec extends RefSpec with Checkers {
  def `all values are objects` = {
    check(
      Test.testSuccess(
        ParentClasses.allValuesAreObjectsParentClasses _,
        "John" :: "Yossarian" :: HNil
      )
    )
  }

  def `subtyping` = {
    check(
      Test.testSuccess(
        ParentClasses.polymorphicParentClasses _,
        "John" :: "Yossarian" :: HNil
      )
    )
  }

  def `abstract classes` = {
    check(
      Test.testSuccess(
        ParentClasses.abstractClassParentClasses _,
        22 :: HNil
      )
    )
  }
}
