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

import RepeatedParametersHelper._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * @param name
 *   repeated_parameters
 */
object RepeatedParameters
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * A repeated parameter must be the last parameter and this will let you add as many extra
   * parameters as needed.
   *
   * Given:
   *
   * {{{
   * def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
   * "%d %ss can give you %s".format(x, y, z.mkString(", "))
   * }
   * }}}
   * Resolve:
   */
  def theLastParameterRepeatedParameters(res0: String) =
    repeatedParameterMethod(
      3,
      "egg",
      "a delicious sandwich",
      "protein",
      "high cholesterol"
    ) should be(
      res0
    )

  /**
   * A repeated parameter can accept a collection as the last parameter but will be considered a
   * single object:
   */
  def acceptCollectionRepeatedParameters(res0: String) =
    repeatedParameterMethod(
      3,
      "egg",
      List("a delicious sandwich", "protein", "high cholesterol")
    ) should be(
      res0
    )

  /**
   * A repeated parameter can accept a collection - if you want it expanded, add `:_*`
   */
  def expandCollectionRepeatedParameters(res0: String) = {
    repeatedParameterMethod(
      3,
      "egg",
      List("a delicious sandwich", "protein", "high cholesterol"): _*
    ) should be(res0)
  }

}
