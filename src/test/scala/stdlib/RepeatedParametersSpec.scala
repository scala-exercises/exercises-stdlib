package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class RepeatedParametersSpec extends Spec with Checkers {
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
