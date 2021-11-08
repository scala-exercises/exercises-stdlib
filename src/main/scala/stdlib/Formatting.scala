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
 * @param name
 *   formatting
 */
object Formatting extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * String can be placed in format:
   */
  def placedInFormatFormatting(res0: String) = {
    val s = "Hello World"
    "Application %s".format(s) should be(res0)
  }

  /**
   * Character Literals can be a single character:
   */
  def characterFormatting(res0: String, res1: String) = {
    val a = 'a'
    val b = 'B'

    // format(a) is a string format, meaning the "%c".format(x)
    // will return the string representation of the char.

    "%c".format(a) should be(res0)
    "%c".format(b) should be(res1)
  }

  /**
   * Character Literals can be an escape sequence, including hexidecimal:
   */
  def escapeSequenceFormatting(res0: String, res1: String, res2: String) = {
    val c = '\u0061' // \u0061 -unicode for a
    val e = '\"'
    val f = '\\'

    "%c".format(c) should be(res0) // your ANSWER should have form: "ANSWER"
    "%c".format(e) should be(res1) // your ANSWER should have form: "\ANSWER"
    "%c".format(f) should be(res2) // your ANSWER should have form: "\ANSWER"
  }

  /**
   * Formatting can also include numbers:
   */
  def includingNumbersFormatting(res0: String) = {
    val j = 190
    "%d bottles of beer on the wall" format j - 100 should be(res0)
  }

  /**
   * Formatting can be used for any number of items, like a string and a number:
   */
  def anyNumberOfItemsFormatting(res0: String) = {
    val j = 190
    val k = "vodka"

    "%d bottles of %s on the wall".format(j - 100, k) should be(res0)
  }

}
