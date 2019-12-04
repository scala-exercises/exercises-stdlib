/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
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
  def typeSignatureTypeSignatures(res0: Boolean) {
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
  def retrieveMetaInformationTypeSignatures(res0: String, res1: String) {
    classOf[String].getCanonicalName should be(res0)
    classOf[String].getSimpleName should be(res1)
  }

  /** Class meta-information can be derived from an object reference using `getClass()`:
   */
  def deriveMetaInformationTypeSignatures(res0: Boolean, res1: String, res2: String) {
    val zoom = "zoom"
    zoom.isInstanceOf[String] should be(res0)
    zoom.getClass.getCanonicalName should be(res1)
    zoom.getClass.getSimpleName should be(res2)
  }

  /** `isInstanceOf[className]` is used to determine if an object reference is an instance of a given class:
   */
  def isInstanceOfFunctionTypeSignatures(res0: Boolean, res1: Boolean, res2: Boolean) {
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
