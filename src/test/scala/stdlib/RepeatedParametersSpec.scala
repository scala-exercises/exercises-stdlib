/*
 * Copyright 2016-2020 47 Degrees Open Source <https://www.47deg.com>
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

class RepeatedParametersSpec extends RefSpec with Checkers {
  def `multiple last parameters` = {
    check(
      Test.testSuccess(
        RepeatedParameters.theLastParameterRepeatedParameters _,
        "3 eggs can give you a delicious sandwich, protein, high cholesterol" :: HNil
      )
    )
  }

  def `collection as repeated parameter` = {
    check(
      Test.testSuccess(
        RepeatedParameters.acceptCollectionRepeatedParameters _,
        "3 eggs can give you List(a delicious sandwich, protein, high cholesterol)" :: HNil
      )
    )
  }

  def `we can spread a collection into positional parameters` = {
    check(
      Test.testSuccess(
        RepeatedParameters.expandCollectionRepeatedParameters _,
        "3 eggs can give you a delicious sandwich, protein, high cholesterol" :: HNil
      )
    )
  }
}
