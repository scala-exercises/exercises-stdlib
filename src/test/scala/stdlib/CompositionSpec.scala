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

class CompositionSpec extends Spec with Checkers {
  def `compose functions` = {
    check(
      Test.testSuccess(
        Composition.composeFunctions _,
        "f(g(Scala Exercises))" :: HNil
      )
    )
  }

  def `andthen functions` = {
    check(
      Test.testSuccess(
        Composition.andThenFunctions _,
        "f(g(Scala Exercises))" :: HNil
      )
    )
  }

}
