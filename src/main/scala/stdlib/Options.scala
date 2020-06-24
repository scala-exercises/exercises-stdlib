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

import OptionsHelper._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * @param name options
 */
object Options extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * If you have worked with Java at all in the past, it is very likely that you have come across a `NullPointerException` at some time (other languages will throw similarly named errors in such a case). Usually this happens because some method returns null when you were not expecting it and thus not dealing with that possibility in your client code. A value of `null` is often abused to represent an absent optional value.
   *
   * Scala tries to solve the problem by getting rid of `null` values altogether and providing its own type for representing optional values, i.e. values that may be present or not: the `Option[A]` trait.
   *
   * `Option[A]` is a container for an optional value of type `A`. If the value of type `A` is present, the `Option[A]` is an instance of `Some[A]`, containing the present value of type `A.` If the value is absent, the `Option[A]` is the object `None`.
   */
  def conceptOptions(res0: Option[String], res1: Option[String]) = {
    val someValue: Option[String] = Some("I am wrapped in something")
    someValue should be(res0)

    val emptyValue: Option[String] = None
    emptyValue should be(res1)
  }

  /**
   * Let's write a function that may or not give us a string, thus returning `Option[String]`:
   *
   * {{{
   * def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
   *   if (flag) Some("Found value") else None
   * }
   * }}}
   *
   * Using `getOrElse`, we can extract the value if it exists, or return a provided default value. If we have a `Some(x)` we return `x`, and for `None` we return the default value.
   */
  def getOrElseOptions(res0: String, res1: String, res2: String) = {
    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1 getOrElse "No value" should be(res0)
    value2 getOrElse "No value" should be(res1)
    value2 getOrElse {
      "default function"
    } should be(res2)

  }

  /**
   * Checking whether option has value:
   */
  def isEmptyOptions(res0: Boolean, res1: Boolean) = {
    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1.isEmpty should be(res0)
    value2.isEmpty should be(res1)
  }

  /**
   * Option can also be used with pattern matching:
   */
  def matchOptions(res0: Double, res1: Double) = {
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None    => 0.0
    }
    value should be(res0)
    val noValue: Option[Double] = None
    val value1 = noValue match {
      case Some(v) => v
      case None    => 0.0
    }
    value1 should be(res1)
  }

  /**
   * An alternative for pattern matching is performing collection style operations.
   * This is possible because an option could be looked at as a collection with either one or zero elements.
   *
   * One of these operations is `map`. This operation allows us to map the inner value to a different type while preserving the option:
   */
  def mapOptions(res0: Option[Double], res1: Option[Double]) = {
    val number: Option[Int]   = Some(3)
    val noNumber: Option[Int] = None
    val result1               = number.map(_ * 1.5)
    val result2               = noNumber.map(_ * 1.5)

    result1 should be(res0)
    result2 should be(res1)

    /**
     * Note that the type of result1 is now Option[Double], thanks to the scala type inference.
     */
  }

  /**
   * Another operation is `fold`. This operation will extract the value from the option, or provide a default if the value is `None`
   */
  def foldOptions(res0: Int, res1: Int) = {
    val number: Option[Int]   = Some(3)
    val noNumber: Option[Int] = None
    val result1               = number.fold(1)(_ * 3)
    val result2               = noNumber.fold(1)(_ * 3)

    result1 should be(res0)
    result2 should be(res1)
  }

}
