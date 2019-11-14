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

class InfixTypesSpec extends RefSpec with Checkers {
  def `infix type` = {
    check(
      Test.testSuccess(
        InfixTypes.infixTypeInfixTypes _,
        "Romeo is in love with Juliet" :: HNil
      )
    )
  }

  def `infix type operators` = {
    check(
      Test.testSuccess(
        InfixTypes.infixOperatorInfixTypes _,
        "Romeo is in love with Juliet" :: HNil
      )
    )
  }
}
