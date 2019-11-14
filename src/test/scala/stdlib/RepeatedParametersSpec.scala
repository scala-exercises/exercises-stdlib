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

class RepeatedParametersSpec extends RefSpec with Checkers {
  def `multiple last parameters` = {
    check(
      Test.testSuccess(
        RepeatedParameters.theLastParameterRepeatedParameters _,
        "3 eggs can give you a delicious sandwich, protein, high cholesterol" :: HNil
      )
    )
  }

  def `collection as repeated parameter` = {
    check(
      Test.testSuccess(
        RepeatedParameters.acceptCollectionRepeatedParameters _,
        "3 eggs can give you List(a delicious sandwich, protein, high cholesterol)" :: HNil
      )
    )
  }

  def `we can spread a collection into positional parameters` = {
    check(
      Test.testSuccess(
        RepeatedParameters.expandCollectionRepeatedParameters _,
        "3 eggs can give you a delicious sandwich, protein, high cholesterol" :: HNil
      )
    )
  }
}
