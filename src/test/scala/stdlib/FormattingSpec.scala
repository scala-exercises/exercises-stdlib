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

class FormattingSpec extends RefSpec with Checkers {
  def `strings` = {
    check(
      Test.testSuccess(
        Formatting.placedInFormatFormatting _,
        "Application Hello World" :: HNil
      )
    )
  }

  def `characters` = {
    check(
      Test.testSuccess(
        Formatting.characterFormatting _,
        "a" :: "B" :: HNil
      )
    )
  }

  def `escape sequences` = {
    check(
      Test.testSuccess(
        Formatting.escapeSequenceFormatting _,
        "a" :: "\"" :: "\\" :: HNil
      )
    )
  }

  def `formatting numbers` = {
    check(
      Test.testSuccess(
        Formatting.includingNumbersFormatting _,
        "90 bottles of beer on the wall" :: HNil
      )
    )
  }

  def `formatting variable numbers of items` = {
    check(
      Test.testSuccess(
        Formatting.anyNumberOfItemsFormatting _,
        "90 bottles of vodka on the wall" :: HNil
      )
    )
  }
}
