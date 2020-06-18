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

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * @param name byname_parameter
 */
object ByNameParameter
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * `() => Int` is a Function type that takes a `Unit` type. `Unit` is known as `void` to a Java programmer. The function returns an `Int`. You can place this as a method parameter so that you can you use it as a block, but still it doesn't look quite right:
   */
  def takesUnitByNameParameter(res0: Either[Throwable, Int]) = {
    def calc(x: () => Int): Either[Throwable, Int] = {
      try Right(x()) // An explicit call of the x function
      catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc { () => // explicitly declaring that Unit is a parameter with ()
      14 + 15
    }

    y should be(res0)
  }

  /**
   * A by-name parameter does the same thing as the previous koan but there is no need to explicitly handle `Unit` or `()`. This is used extensively in Scala to create blocks:
   */
  def byNameParameter(res0: Either[Throwable, Int]) = {
    def calc(x: => Int): Either[Throwable, Int] = {
      // x is a call by-name parameter
      try Right(x)
      catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc {
      // This looks like a natural block
      println("Here we go!") // Some superfluous call
      val z = List(1, 2, 3, 4) // Another superfluous call
      49 + 20
    }

    y should be(res0)
  }

  /**
   * By-name parameters can also be used with `object` and `apply` to make interesting block-like calls:
   */
  def withApplyByNameParameter(res0: String) = {
    object PigLatinizer {
      def apply(x: => String) = x.tail + x.head + "ay"
    }

    val result = PigLatinizer {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }

    result should be(res0)
  }

}
