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

import NamedandDefaultArgumentsHelper._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * @param name
 *   named_and_default_arguments
 */
object NamedandDefaultArguments
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * When calling methods and functions, you can use the name of the variables explicitly in the
   * call, like so:
   *
   * {{{
   * def printName(first:String, last:String) = {
   * println(first + " " + last)
   * }
   *
   * printName("John","Smith") // Prints "John Smith"
   * printName(first = "John",last = "Smith") // Prints "John Smith"
   * printName(last = "Smith",first = "John") // Prints "John Smith"
   * }}}
   *
   * Note that once you are using parameter names in your calls, the order doesn't matter, so long
   * as all parameters are named. This feature works well with default parameter values:
   *
   * {{{
   * def printName(first:String = "John", last:String = "Smith") = {
   * println(first + " " + last)
   * }
   * printName(last = "Jones") // Prints "John Jones"
   * }}}
   *
   * Given the classes below:
   *
   * {{{
   * class WithoutClassParameters() = {
   * def addColors(red: Int, green: Int, blue: Int) = {
   * (red, green, blue)
   * }
   *
   * def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
   * (red, green, blue)
   * }
   * }
   *
   * class WithClassParameters(val defaultRed: Int, val defaultGreen: Int, val defaultBlue: Int) = {
   * def addColors(red: Int, green: Int, blue: Int) = {
   * (red + defaultRed, green + defaultGreen, blue + defaultBlue)
   * }
   *
   * def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
   * (red + defaultRed, green + defaultGreen, blue + defaultBlue)
   * }
   * }
   *
   * class WithClassParametersInClassDefinition(val defaultRed: Int = 0, val defaultGreen: Int = 255, val defaultBlue: Int = 100) {
   * def addColors(red: Int, green: Int, blue: Int) = {
   * (red + defaultRed, green + defaultGreen, blue + defaultBlue)
   * }
   *
   * def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
   * (red + defaultRed, green + defaultGreen, blue + defaultBlue)
   * }
   * }
   *
   * }}}
   *
   * You can specify arguments in any order if you use their names:
   */
  def classWithoutParametersNamedandDefaultArguments(res0: Int, res1: Int, res2: Int) = {
    val me = new WithoutClassParameters()

    // What happens if you change the order of these parameters? Nothing.
    val myColor = me.addColors(green = 0, red = 255, blue = 0)

    myColor should equal((res0, res1, res2))
  }

  /**
   * You can default arguments if you leave them off:
   */
  def defaultArgumentsNamedandDefaultArguments(res0: Int, res1: Int, res2: Int) = {
    val me      = new WithoutClassParameters()
    val myColor = me.addColorsWithDefaults(green = 255)

    myColor should equal((res0, res1, res2))
  }

  /**
   * You can access class parameters and specify arguments in any order if you use their names:
   */
  def anyOrderNamedandDefaultArguments(res0: Int, res1: Int, res2: Int) = {
    val me      = new WithClassParameters(40, 50, 60)
    val myColor = me.addColors(green = 50, red = 60, blue = 40)

    myColor should equal((res0, res1, res2))
  }

  /**
   * You can access class parameters and default arguments if you leave them off:
   */
  def accessClassParametersNamedandDefaultArguments(res0: Int, res1: Int, res2: Int) = {
    val me      = new WithClassParameters(10, 20, 30)
    val myColor = me.addColorsWithDefaults(green = 70)

    myColor should equal((res0, res1, res2))
  }

  /**
   * You can default class parameters and have default arguments too:
   */
  def defaultClassArgumentsNamedandDefaultArguments(res0: Int, res1: Int, res2: Int) = {
    val me      = new WithClassParametersInClassDefinition()
    val myColor = me.addColorsWithDefaults(green = 70)

    myColor should equal((res0, res1, res2))
  }

  /**
   * Default parameters can be functions too:
   */
  def functionalDefaulParametersNamedandDefaultArguments(res0: Int, res1: Int) = {
    def reduce(a: Int, f: (Int, Int) => Int = _ + _): Int = f(a, a)

    reduce(5) should equal(res0)
    reduce(5, _ * _) should equal(res1)
  }

}
