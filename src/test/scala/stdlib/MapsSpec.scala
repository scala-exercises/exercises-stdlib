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

class MapsSpec extends Spec with Checkers {
  def `size` = {
    check(
      Test.testSuccess(
        Maps.keyAndValueMaps _,
        4 :: HNil
      )
    )
  }

  def `repeated keys` = {
    check(
      Test.testSuccess(
        Maps.distinctPairingsMaps _,
        3 :: HNil
      )
    )
  }

  def `adding to maps` = {
    check(
      Test.testSuccess(
        Maps.easilyAddedMaps _,
        true :: HNil
      )
    )
  }

  def `iterating over maps` = {
    check(
      Test.testSuccess(
        Maps.canBeIteratedMaps _,
        3 :: "Michigan" :: "Wisconsin" :: HNil
      )
    )
  }

  def `map key access` = {
    check(
      Test.testSuccess(
        Maps.mayBeAccessedMaps _,
        "Michigan" :: "Iowa" :: HNil
      )
    )
  }

  def `duplicate keys` = {
    check(
      Test.testSuccess(
        Maps.duplicatedKeyInsertionMaps _,
        3 :: "Meechigan" :: HNil
      )
    )
  }

  def `mixed key types` = {
    check(
      Test.testSuccess(
        Maps.mixedTypeKeysMaps _,
        "MI" :: "MI" :: HNil
      )
    )
  }

  def `map default value access` = {
    check(
      Test.testSuccess(
        Maps.defaultValuesMayBeProvidedMaps _,
        "missing data" :: "missing data" :: HNil
      )
    )
  }

  def `map element removal` = {
    check(
      Test.testSuccess(
        Maps.easilyRemovedMaps _,
        false :: true :: HNil
      )
    )
  }

  def `multiple key removal` = {
    check(
      Test.testSuccess(
        Maps.removedInMultipleMaps _,
        false :: true :: true :: 2 :: 4 :: HNil
      )
    )
  }

  def `key removal with tuples` = {
    check(
      Test.testSuccess(
        Maps.removedWithTupleMaps _,
        false :: true :: true :: 2 :: 4 :: HNil
      )
    )
  }

  def `non-existent element removal` = {
    check(
      Test.testSuccess(
        Maps.attemptedRemovalMaps _,
        true :: HNil
      )
    )
  }

  def `maps dont have ordering` = {
    check(
      Test.testSuccess(
        Maps.orderIndependentMaps _,
        true :: HNil
      )
    )
  }
}
