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
 *   literal_strings
 */
object LiteralStrings
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * Character literals are quoted with single quotes:
   */
  def characterLiteralsLiteralStrings(res0: String, res1: String) = {
    val a = 'a'
    val b = 'B'

    a.toString should be(res0)
    b.toString should be(res1)
  }

  /**
   * Character literals can use hexadecimal Unicode:
   */
  def characterLiteralsUnicodeLiteralStrings(res0: String) = {
    val c = '\u0061' // unicode for a

    c.toString should be(res0)
  }

  /**
   * Character literals can use escape sequences:
   */
  def escapeSequenceLiteralStrings(res0: String, res1: String) = {
    val e = '\"'
    val f = '\\'

    e.toString should be(res0)
    f.toString should be(res1)
  }

  /**
   * One-line String literals are surrounded by quotation marks:
   */
  def oneLineLiteralStrings(res0: String) = {
    val a = "To be or not to be"
    a should be(res0)
  }
  /* TODO rework exercise compiler issue where multiline string literals are not
  /** multilineLiteralStrings
   *
   * Multiline String literals are surrounded by three quotation marks.
   */
  def multilineLiteralStrings(res0: Int) = {
    val a =
      """An apple a day
  keeps the doctor away"""
    a.split('\n').size should be(res0) //a.split('\n').size determines the number of lines
  }

  /** stripMarginLiteralStrings
   *
   * Use stripMargin to prettify multi-line strings:
   * Multiline String literals can use | to specify the starting position
   * of subsequent lines, then use stripMargin to remove the surplus indentation.
   */
  def stripMarginLiteralStrings(res0: String) = {

    val a = """An apple a day keeps
| the doctor away"""
    a.stripMargin.split('\n')(1).charAt(0) should be(res0)

  }
   */

}
