/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
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

/** @param name type_signatures
 */
object TypeSignatures
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** A method's type signature comprises its name; the number, order, and types of its parameters, if any; and its result type. The type signature of a class, trait, or singleton object comprises its name, the type signatures of all of its members and constructors, and its declared inheritance and mixin relations.
   *
   * In Java you declare a generic type within a `<>`, in Scala `[]` is used:
   *
   * {{{
   * val z: List[String] = "Do" :: "Re" :: "Mi" :: "Fa" :: "So" :: "La" :: "Te" :: "Do" :: Nil
   * }}}
   *
   * Most of the time, Scala will infer the type and `[]` are optional:
   *
   * {{{
   * val z = "Do" :: "Re" :: "Mi" :: "Fa" :: "So" :: "La" :: "Te" :: "Do" :: Nil //Infers that the list assigned to variable is of type List[String]
   * }}}
   *
   * A trait can be declared containing a type, where a concrete implementer will satisfy the type:
   *
   */
  def typeSignatureTypeSignatures(res0: Boolean) = {
    trait Randomizer[A] {
      def draw(): A
    }

    class IntRandomizer extends Randomizer[Int] {
      def draw() = {
        import util.Random
        Random.nextInt()
      }
    }

    val intRand = new IntRandomizer
    (intRand.draw <= Int.MaxValue) should be(res0)
  }

  /** Class meta-information can be retrieved by class name by using `classOf[className]`:
   */
  def retrieveMetaInformationTypeSignatures(res0: String, res1: String) = {
    classOf[String].getCanonicalName should be(res0)
    classOf[String].getSimpleName should be(res1)
  }

  /** Class meta-information can be derived from an object reference using `getClass()`:
   */
  def deriveMetaInformationTypeSignatures(res0: Boolean, res1: String, res2: String) = {
    val zoom = "zoom"
    zoom.isInstanceOf[String] should be(res0)
    zoom.getClass.getCanonicalName should be(res1)
    zoom.getClass.getSimpleName should be(res2)
  }

  /** `isInstanceOf[className]` is used to determine if an object reference is an instance of a given class:
   */
  def isInstanceOfFunctionTypeSignatures(res0: Boolean, res1: Boolean, res2: Boolean) = {
    trait Randomizer[A] {
      def draw(): A
    }

    class IntRandomizer extends Randomizer[Int] {
      def draw() = {
        import util.Random
        Random.nextInt()
      }
    }

    val intRand = new IntRandomizer
    intRand.isInstanceOf[IntRandomizer] should be(res0)
    intRand.isInstanceOf[Randomizer[Int]] should be(res1)
    intRand.draw.isInstanceOf[Int] should be(res2)
  }

}
