package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class OptionsSpec extends Spec with Checkers {
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
        20D :: 0D :: HNil
      )
    )
  }

  def `mapping` = {
    val theNone: Option[Double] = None

    check(
      Test.testSuccess(
        Options.mapOptions _,
        Option(4.5D) :: theNone :: HNil
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
