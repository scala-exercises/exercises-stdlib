package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class LiteralStringsSpec extends Spec with Checkers {
  def `character literals` = {
    check(
      Test.testSuccess(
        LiteralStrings.characterLiteralsLiteralStrings _,
        "a" :: "B" :: HNil
      )
    )
  }

  def `unicode character literals` = {
    check(
      Test.testSuccess(
        LiteralStrings.characterLiteralsUnicodeLiteralStrings _,
        "a" :: HNil
      )
    )
  }

  def `octal character literals` = {
    check(
      Test.testSuccess(
        LiteralStrings.characterLiteralsOctalLiteralStrings _,
        "a" :: HNil
      )
    )
  }

  def `escape sequence character literals` = {
    check(
      Test.testSuccess(
        LiteralStrings.escapeSequenceLiteralStrings _,
        "\"" :: "\\" :: HNil
      )
    )
  }

  def `one line literal strings` = {
    check(
      Test.testSuccess(
        LiteralStrings.oneLineLiteralStrings _,
        "To be or not to be" :: HNil
      )
    )
  }
}
