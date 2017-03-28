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

class SetsSpec extends Spec with Checkers {
  def `have no duplicates` = {
    check(
      Test.testSuccess(
        Sets.noDuplicatesSets _,
        4 :: HNil
      )
    )
  }

  def `all their values are distinct` = {
    check(
      Test.testSuccess(
        Sets.distinctValuesSets _,
        3 :: HNil
      )
    )
  }

  def `adding values to sets` = {
    check(
      Test.testSuccess(
        Sets.easilyAddedSets _,
        true :: false :: HNil
      )
    )
  }

  def `sets accept mixed types` = {
    check(
      Test.testSuccess(
        Sets.mixedTypeSets _,
        true :: false :: HNil
      )
    )
  }

  def `we can check for member existence` = {
    check(
      Test.testSuccess(
        Sets.checkExistenceSets _,
        true :: false :: HNil
      )
    )
  }

  def `we can remove members` = {
    check(
      Test.testSuccess(
        Sets.easilyRemovedSets _,
        false :: true :: HNil
      )
    )
  }

  def `we can remove multiple members` = {
    check(
      Test.testSuccess(
        Sets.multipleRemovingSets _,
        false :: true :: 2 :: HNil
      )
    )
  }

  def `we can remove multiple members with tuples` = {
    check(
      Test.testSuccess(
        Sets.tupleRemovingSets _,
        false :: true :: 2 :: HNil
      )
    )
  }

  def `we can remove values that are not part of the set` = {
    check(
      Test.testSuccess(
        Sets.nonexistentRemovalSets _,
        true :: HNil
      )
    )
  }

  def `set intersection` = {
    check(
      Test.testSuccess(
        Sets.easilyIntersectedSets _,
        true :: HNil
      )
    )
  }

  def `set union` = {
    check(
      Test.testSuccess(
        Sets.easilyJoinedSets _,
        true :: HNil
      )
    )
  }

  def `subsets` = {
    check(
      Test.testSuccess(
        Sets.subsetSets _,
        false :: true :: HNil
      )
    )
  }

  def `set difference` = {
    check(
      Test.testSuccess(
        Sets.easilyObtainedDifferencesSets _,
        true :: HNil
      )
    )
  }

  def `set equality` = {
    check(
      Test.testSuccess(
        Sets.equivalencySets _,
        true :: HNil
      )
    )
  }
}
