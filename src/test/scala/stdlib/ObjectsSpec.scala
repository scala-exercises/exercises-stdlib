/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatest.prop.Checkers
import shapeless.HNil

class ObjectsSpec extends RefSpec with Checkers {
  def `singleton` = {
    check(
      Test.testSuccess(
        Objects.singletonObjects _,
        "Hi" :: "Hola" :: HNil
      )
    )
  }

  def `they are unique` = {
    check(
      Test.testSuccess(
        Objects.notStaticMethodObjects _,
        true :: true :: HNil
      )
    )
  }

  def `companion objects` = {
    check(
      Test.testSuccess(
        Objects.companionObjectObjects _,
        "Grand Hotel" :: HNil
      )
    )
  }

  // FIXME: can't test properly because it relies on a shared mutable var :_)
  // def `shared variables` = {
  //   check(
  //     Test.testSuccess(
  //       Objects.sharingVariablesObjects _,
  //       1500 :: HNil
  //     )
  //   )
  // }

  def `private members` = {
    check(
      Test.testSuccess(
        Objects.privateValuesObjects _,
        "Superman" :: "Spider-Man" :: HNil
      )
    )
  }
}
