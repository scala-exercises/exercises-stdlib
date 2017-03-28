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

class ExtractorsSpec extends Spec with Checkers {
  def `extractors` = {
    check(
      Test.testSuccess(
        Extractors.extractorsExtractors _,
        "Where's Batman?" :: HNil
      )
    )
  }

  def `unapply` = {
    check(
      Test.testSuccess(
        Extractors.calledUnapplyExtractors _,
        "Chevy" :: "Camaro" :: 1978 :: 120 :: HNil
      )
    )
  }

  def `pattern matching` = {
    check(
      Test.testSuccess(
        Extractors.patternMatchingExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `wildcards` = {
    check(
      Test.testSuccess(
        Extractors.withWildcardExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `multiple extractors` = {
    check(
      Test.testSuccess(
        Extractors.multipleUnapplyExtractors _,
        "c: Kurt, d: Vonnegut" :: HNil
      )
    )
  }

  def `any object as extractor` = {
    check(
      Test.testSuccess(
        Extractors.anyObjectExtractors _,
        "make: Chevy, model: Camaro" :: HNil
      )
    )
  }

  def `extractor in companion object` = {
    val theOption: Option[String] = None

    check(
      Test.testSuccess(
        Extractors.asAssignmentExtractors _,
        "Keerthi" :: theOption :: "Singri" :: HNil
      )
    )
  }

  def `unapply for pattern matching extractors` = {
    check(
      Test.testSuccess(
        Extractors.unapplyForPatternMatchingExtractors _,
        "I don't care, going on break" :: HNil
      )
    )
  }
}
