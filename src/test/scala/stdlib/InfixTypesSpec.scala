package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class InfixTypesSpec extends Spec with Checkers {
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
