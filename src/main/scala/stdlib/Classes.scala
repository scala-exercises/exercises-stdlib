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
 * @param name classes
 */
object Classes extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * Classes in Scala are static templates that can be instantiated into many objects at runtime.
   * Here is a class definition which defines a class Point:
   *
   * {{{
   * class Point(x: Int, y: Int) {
   * override def toString(): String = "(" + x + ", " + y + ")"
   * }
   * }}}
   * The class defines two variables `x` and `y` and one method `toString`.
   *
   * Classes in Scala are parameterized with constructor arguments. The code above defines two constructor arguments, `x` and `y`; they are both visible in the whole body of the class. In our example they are used to implement `toString`.
   *
   * Classes are instantiated with the `new` primitive, as the following example will show:
   *
   * {{{
   * object Classes {
   * def main(args: Array[String]) = {
   * val pt = new Point(1, 2)
   * println(pt)
   * }
   * }
   * }}}
   *
   * The program defines an executable application `Classes` in the form of a top-level singleton object with a `main` method. The `main` method creates a new `Point` and stores it in value `pt`.
   *
   * This also demonstrates the use of value parameters in `ClassWithValParameter(val name: String)`, which automatically creates an internal property `val name: String` in the class:
   */
  def classWithValParameterClasses(res0: String) = {
    class ClassWithValParameter(val name: String)
    val aClass = new ClassWithValParameter("Gandalf")
    aClass.name should be(res0)
  }

}
