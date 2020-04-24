/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package stdlib

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapeless.HNil

class CaseClassesSpec extends RefSpec with Checkers {
  def `case classes comparisons` = {
    check(
      Test.testSuccess(
        CaseClasses.caseClassesSupportEquality _,
        false :: true :: false :: false :: HNil
      )
    )
  }

  def `hash codes` = {
    check(
      Test.testSuccess(
        CaseClasses.hashcodeMethodCaseClasses _,
        false :: true :: HNil
      )
    )
  }

  def `case class creation` = {
    check(
      Test.testSuccess(
        CaseClasses.creationCaseClasses _,
        true :: false :: false :: HNil
      )
    )
  }

  def `to string method` = {
    check(
      Test.testSuccess(
        CaseClasses.toStringMethodCaseClasses _,
        "Dog(Scooby,Doberman)" :: HNil
      )
    )
  }

  def `properties` = {
    check(
      Test.testSuccess(
        CaseClasses.propertiesCaseClasses _,
        "Scooby" :: "Doberman" :: HNil
      )
    )
  }

  def `mutable properties` = {
    check(
      Test.testSuccess(
        CaseClasses.mutablePropertiesCaseClasses _,
        "Scooby" :: "Doberman" :: "Scooby Doo" :: "Doberman" :: HNil
      )
    )
  }

  def `altering case classes` = {
    check(
      Test.testSuccess(
        CaseClasses.alteringCaseClasses _,
        "Scooby" :: "Doberman" :: "Scooby Doo" :: "Doberman" :: HNil
      )
    )
  }

  def `case class parameters` = {
    check(
      Test.testSuccess(
        CaseClasses.parametersCaseClasses _,
        "Fred" :: "Jones" :: 23 :: "111-22-3333" ::
          "Samantha" :: "Jones" :: 0 :: "" ::
          "Fred" :: "Jones" :: 0 :: "111-22-3333" :: true :: HNil
      )
    )
  }

  def `case classes as tuples` = {
    check(
      Test.testSuccess(
        CaseClasses.asTupleCaseClasses _,
        "Fred" :: "Jones" :: 23 :: "111-22-3333" :: HNil
      )
    )
  }

  def `case classes are serializable` = {
    check(
      Test.testSuccess(
        CaseClasses.serializableCaseClasses _,
        true :: false :: HNil
      )
    )
  }
}
