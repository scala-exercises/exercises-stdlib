package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class ParentClassesSpec extends Spec with Checkers {
  def `all values are objects` = {
    check(
      Test.testSuccess(
        ParentClasses.allValuesAreObjectsParentClasses _,
        "John" :: "Yossarian" :: HNil
      )
    )
  }

  def `subtyping` = {
    check(
      Test.testSuccess(
        ParentClasses.polymorphicParentClasses _,
        "John" :: "Yossarian" :: HNil
      )
    )
  }

  def `abstract classes` = {
    check(
      Test.testSuccess(
        ParentClasses.abstractClassParentClasses _,
        22 :: HNil
      )
    )
  }
}
