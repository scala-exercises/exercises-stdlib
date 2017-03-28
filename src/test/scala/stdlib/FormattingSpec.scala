/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class FormattingSpec extends Spec with Checkers {
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
        "a" :: "a" :: "\"" :: "\\" :: HNil
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
