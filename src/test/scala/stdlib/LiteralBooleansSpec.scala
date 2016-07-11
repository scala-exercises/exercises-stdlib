package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class LiteralBooleansSpec extends Spec with Checkers {
  def `are either true or false` = {
    check(
      Test.testSuccess(
        LiteralBooleans.literalBooleanLiteralBooleans _,
        true :: false :: false :: true :: false :: false :: HNil
      )
    )
  }
}
