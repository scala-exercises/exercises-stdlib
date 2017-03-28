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

class IterablesSpec extends Spec with Checkers {
  def `collection iterables` = {
    check(
      Test.testSuccess(
        Iterables.collectionIterablesIterables _,
        3 :: HNil
      )
    )
  }

  def `grouped iterables` = {
    check(
      Test.testSuccess(
        Iterables.groupedIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: 21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `sliding iterables` = {
    check(
      Test.testSuccess(
        Iterables.slidingIterables _,
        3 :: 5 :: 9 :: 5 :: 9 :: 11 :: 9 :: 11 :: 15 :: HNil
      )
    )
  }

  def `sliding window iterables` = {
    check(
      Test.testSuccess(
        Iterables.slidingWindowIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: 21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `take right on iterables` = {
    check(
      Test.testSuccess(
        Iterables.takeRightIterables _,
        21 :: 24 :: 32 :: HNil
      )
    )
  }

  def `drop right on iterables` = {
    check(
      Test.testSuccess(
        Iterables.dropRightIterables _,
        3 :: 5 :: 9 :: 11 :: 15 :: 19 :: HNil
      )
    )
  }

  def `zipping iterables` = {
    check(
      Test.testSuccess(
        Iterables.zipIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: 9 :: "Stella" :: HNil
      )
    )
  }

  def `zipping different size iterables` = {
    check(
      Test.testSuccess(
        Iterables.sameSizeZipIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: HNil
      )
    )
  }

  def `zipping with zipAll` = {
    check(
      Test.testSuccess(
        Iterables.zipAllIterables _,
        3 :: "Bob" :: 5 :: "Ann" :: 9 :: 3 :: "Bob" :: 5 :: "Ann" :: "Stella" :: HNil
      )
    )
  }

  def `zipping with index` = {
    check(
      Test.testSuccess(
        Iterables.zipWithIndexIterables _,
        "Manny" :: "Moe" :: 1 :: "Jack" :: HNil
      )
    )
  }

  def `zipping with sameElements` = {
    check(
      Test.testSuccess(
        Iterables.sameElementsIterables _,
        true :: false :: true :: false :: HNil
      )
    )
  }
}
