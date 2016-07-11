package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class TuplesSpec extends Spec with Checkers {
  def `are indexed` = {
    check(
      Test.testSuccess(
        Tuples.oneIndexedTuples _,
        "apple" :: "dog" :: HNil
      )
    )
  }

  def `are heterogeneous` = {
    check(
      Test.testSuccess(
        Tuples.mixedTypeTuples _,
        1 :: "five" :: HNil
      )
    )
  }

  def `support multiple assignment` = {
    check(
      Test.testSuccess(
        Tuples.assignVariablesTuples _,
        "Sean Rogers" :: 21 :: 3.5D :: HNil
      )
    )
  }

  def `two tuple elements can be swapped` = {
    check(
      Test.testSuccess(
        Tuples.swappedTuples _,
        3 :: "apple" :: HNil
      )
    )
  }
}
