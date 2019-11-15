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

class TypeVarianceSpec extends RefSpec with Checkers {
  def `type variance` = {
    check(
      Test.testSuccess(
        TypeVariance.syntacticOverheadTypeVariance _,
        "Orange" :: HNil
      )
    )
  }

  def `explicit type declarations` = {
    check(
      Test.testSuccess(
        TypeVariance.typeVariableTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `coercions` = {
    check(
      Test.testSuccess(
        TypeVariance.coerceObjectTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `variance` = {
    check(
      Test.testSuccess(
        TypeVariance.polymorphismTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `variance restrictions` = {
    check(
      Test.testSuccess(
        TypeVariance.covarianceInmutableTypeVariance _,
        "Orange" :: HNil
      )
    )
  }

  def `contravariance` = {
    check(
      Test.testSuccess(
        TypeVariance.contravarianceVarianceTypeVariance _,
        "Citrus" :: "Citrus" :: "Citrus" :: "Fruit" :: HNil
      )
    )
  }

  def `invariance` = {
    check(
      Test.testSuccess(
        TypeVariance.invarianceVarianceTypeVariance _,
        "Citrus" :: HNil
      )
    )
  }

}
