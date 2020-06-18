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
 * @param name sequences_and_arrays
 */
object SequencesandArrays
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * Scala provides a data structure, the array, which stores a fixed-size sequential collection of elements of the same type. An array is used to store a collection of data, but it is often more useful to think of an array as a collection of variables of the same type.
   *
   * A list can be converted to an array:
   */
  def sequentialCollectionSequencesandArrays(res0: Int, res1: Int, res2: Int) = {
    val l = List(1, 2, 3)
    val a = l.toArray
    a should equal(Array(res0, res1, res2))
  }

  /**
   * Sequences are special cases of iterable collections of class `Iterable`. Unlike iterables, sequences always have a defined order of elements.
   *
   * Any sequence can be converted to a list:
   */
  def orderedElementsSequencesandArrays(res0: List[Int]) = {
    val a = Array(1, 2, 3)
    val s = a.toSeq
    val l = s.toList
    l should equal(res0)
  }

  /**
   * You can create a sequence from a `for` loop:
   */
  def fromForComprehensionSequencesandArrays(res0: List[Int]) = {
    val s = for (v <- 1 to 4) yield v
    s.toList should be(res0)
  }

  /**
   * You can create a sequence from a `for` loop with a filter:
   */
  def withConditionSequencesandArrays(res0: List[Int]) = {
    val s = for (v <- 1 to 10 if v % 3 == 0) yield v
    s.toList should be(res0)
  }

  /**
   * You can filter any sequence based on a predicate:
   */
  def filterPredicateSequencesandArrays(res0: String, res1: String) = {
    val s        = Seq("hello", "to", "you")
    val filtered = s.filter(_.length > 2)
    filtered should be(Seq(res0, res1))
  }

  /**
   * You can also filter Arrays in the same way:
   */
  def filterArraySequencesandArrays(res0: String, res1: String) = {
    val a        = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    filtered should be(Array(res0, res1))
  }

  /**
   * You can map values in a sequence through a function:
   */
  def mapValuesSequencesandArrays(res0: Seq[String]) = {
    val s = Seq("hello", "world")
    val r = s map {
      _.reverse
    }

    r should be(res0)
  }

}
