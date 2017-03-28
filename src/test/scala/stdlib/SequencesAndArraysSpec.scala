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

class SequencesAndArraysSpec extends Spec with Checkers {
  def `list to array` = {
    check(
      Test.testSuccess(
        SequencesandArrays.sequentialCollectionSequencesandArrays _,
        1 :: 2 :: 3 :: HNil
      )
    )
  }

  def `seq to list` = {
    check(
      Test.testSuccess(
        SequencesandArrays.orderedElementsSequencesandArrays _,
        List(1, 2, 3) :: HNil
      )
    )
  }

  def `sequences with for comprehensions` = {
    check(
      Test.testSuccess(
        SequencesandArrays.fromForComprehensionSequencesandArrays _,
        List(1, 2, 3, 4) :: HNil
      )
    )
  }

  def `sequences with for comprehension and conditions` = {
    check(
      Test.testSuccess(
        SequencesandArrays.withConditionSequencesandArrays _,
        List(3, 6, 9) :: HNil
      )
    )
  }

  def `filtered sequences` = {
    check(
      Test.testSuccess(
        SequencesandArrays.filterPredicateSequencesandArrays _,
        "hello" :: "you" :: HNil
      )
    )
  }

  def `filtered arrays` = {
    check(
      Test.testSuccess(
        SequencesandArrays.filterArraySequencesandArrays _,
        "hello" :: "again" :: HNil
      )
    )
  }

  def `map over a sequence` = {
    check(
      Test.testSuccess(
        SequencesandArrays.mapValuesSequencesandArrays _,
        List("olleh", "dlrow") :: HNil
      )
    )
  }
}
