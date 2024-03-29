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

import java.util.Date

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * @param name
 *   tuples
 */
object Tuples extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * Scala tuple combines a fixed number of items together so that they can be passed around as a
   * whole. They are one-indexed. Unlike an array or list, a tuple can hold objects with different
   * types but they are also immutable. Here is an example of a tuple holding an integer, a string,
   * and the console:
   *
   * {{{
   * val t = (1, "hello", Console)
   * }}}
   *
   * Which is syntactic sugar (short cut) for the following:
   *
   * {{{
   * val t = new Tuple3(1, "hello", Console)
   * }}}
   * As you can see, tuples can be created easily:
   */
  def oneIndexedTuples(res0: String, res1: String) = {
    val tuple  = ("apple", "dog")
    val fruit  = tuple._1
    val animal = tuple._2

    fruit should be(res0)
    animal should be(res1)
  }

  /**
   * Tuples may be of mixed type:
   */
  def mixedTypeTuples(res0: Int, res1: String) = {
    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._2 should be(res0)
    tuple5._5 should be(res1)
  }

  /**
   * You can assign multiple variables at once using tuples:
   */
  def assignVariablesTuples(res0: String, res1: Int, res2: Double) = {
    val student          = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student

    name should be(res0)
    age should be(res1)
    gpa should be(res2)
  }

  /**
   * The `swap` method can be used to swap the elements of a Tuple2:
   */
  def swappedTuples(res0: Int, res1: String) = {
    val tuple = ("apple", 3).swap
    tuple._1 should be(res0)
    tuple._2 should be(res1)
  }

}
