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

class EmptyValuesSpec extends Spec with Checkers {
  def `empty values` = {
    check(
      Test.testSuccess(
        EmptyValues.emptyValuesEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is equal to none` = {
    check(
      Test.testSuccess(
        EmptyValues.avoidingNullEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is identical to none` = {
    check(
      Test.testSuccess(
        EmptyValues.identicalNoneEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none to string` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToStringEmptyValues _,
        "None" :: HNil
      )
    )
  }

  def `none to list` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is empty` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none can be casted` = {
    check(
      Test.testSuccess(
        EmptyValues.noneToAnyEmptyValues _,
        true :: true :: true :: HNil
      )
    )
  }

  def `none is an option` = {
    val theOption: Option[String] = None

    check(
      Test.testSuccess(
        EmptyValues.noneWithOptionEmptyValues _,
        true :: theOption :: HNil
      )
    )
  }

  def `some vs none` = {
    check(
      Test.testSuccess(
        EmptyValues.someAgainstNoneEmptyValues _,
        false :: false :: HNil
      )
    )
  }

  def `getOrElse on none` = {
    check(
      Test.testSuccess(
        EmptyValues.getOrElseEmptyValues _,
        "Some Value" :: "No Value" :: HNil
      )
    )
  }
}
