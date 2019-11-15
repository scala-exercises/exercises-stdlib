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

class TypeSignaturesSpec extends RefSpec with Checkers {
  def `type signatures` = {
    check(
      Test.testSuccess(
        TypeSignatures.typeSignatureTypeSignatures _,
        true :: HNil
      )
    )
  }

  def `class metainformation` = {
    check(
      Test.testSuccess(
        TypeSignatures.retrieveMetaInformationTypeSignatures _,
        "java.lang.String" :: "String" :: HNil
      )
    )
  }

  def `class metainformation derivation` = {
    check(
      Test.testSuccess(
        TypeSignatures.deriveMetaInformationTypeSignatures _,
        true :: "java.lang.String" :: "String" :: HNil
      )
    )
  }

  def `instanceof class` = {
    check(
      Test.testSuccess(
        TypeSignatures.isInstanceOfFunctionTypeSignatures _,
        true :: true :: true :: HNil
      )
    )
  }

}
