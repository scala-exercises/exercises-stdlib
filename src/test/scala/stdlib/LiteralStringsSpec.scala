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

class LiteralStringsSpec extends RefSpec with Checkers {
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
