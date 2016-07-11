package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class ForExpressionsSpec extends Spec with Checkers {

  def `nested for expressions` = {
    check(
      Test.testSuccess(
        ForExpressions.canBeNestedForExpressions _,
        3 :: 1 :: HNil
      )
    )
  }

  def `readable for expressions` = {
    val result: List[Int] = List(2, 4)

    check(
      Test.testSuccess(
        ForExpressions.readableCodeForExpressions _,
        result :: HNil
      )
    )
  }
}
