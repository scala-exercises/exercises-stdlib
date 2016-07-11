package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class TypeSignaturesSpec extends Spec with Checkers {
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
        true :: HNil
      )
    )
  }

}
