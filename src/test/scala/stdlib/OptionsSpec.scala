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

class OptionsSpec extends RefSpec with Checkers {
  def `none and some` = {
    val theNone: Option[String] = None

    check(
      Test.testSuccess(
        Options.conceptOptions _,
        Option("I am wrapped in something") :: theNone :: HNil
      )
    )
  }

  def `getOrElse method` = {
    check(
      Test.testSuccess(
        Options.getOrElseOptions _,
        "Found value" :: "No value" :: "default function" :: HNil
      )
    )
  }

  def `isEmpty method` = {
    check(
      Test.testSuccess(
        Options.isEmptyOptions _,
        false :: true :: HNil
      )
    )
  }

  def `pattern matching` = {
    check(
      Test.testSuccess(
        Options.matchOptions _,
        20d :: 0d :: HNil
      )
    )
  }

  def `mapping` = {
    val theNone: Option[Double] = None

    check(
      Test.testSuccess(
        Options.mapOptions _,
        Option(4.5d) :: theNone :: HNil
      )
    )
  }

  def `folding` = {
    check(
      Test.testSuccess(
        Options.foldOptions _,
        9 :: 0 :: HNil
      )
    )
  }
}
