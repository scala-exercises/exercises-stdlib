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

class ClassesSpec extends RefSpec with Checkers {
  def `classes with val parameters` = {
    check(
      Test.testSuccess(
        Classes.classWithValParameterClasses _,
        "Gandalf" :: HNil
      )
    )
  }

}
