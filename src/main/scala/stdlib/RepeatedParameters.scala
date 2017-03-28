/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import RepeatedParametersHelper._
import org.scalatest._

/** @param name repeated_parameters
 *
 */
object RepeatedParameters
    extends FlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** A repeated parameter must be the last parameter and this will let you add as many extra parameters as needed.
   *
   * Given:
   *
   * {{{
   * def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
   * "%d %ss can give you %s".format(x, y, z.mkString(", "))
   * }
   * }}}
   * Resolve:
   *
   */
  def theLastParameterRepeatedParameters(res0: String) {
    repeatedParameterMethod(3, "egg", "a delicious sandwich", "protein", "high cholesterol") should be(
      res0)
  }

  /** A repeated parameter can accept a collection as the last parameter but will be considered a single object:
   */
  def acceptCollectionRepeatedParameters(res0: String) {
    repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol")) should be(
      res0)
  }

  /** A repeated parameter can accept a collection - if you want it expanded, add `:_*`
   */
  def expandCollectionRepeatedParameters(res0: String) {
    repeatedParameterMethod(
      3,
      "egg",
      List("a delicious sandwich", "protein", "high cholesterol"): _*) should be(res0)
  }

}
