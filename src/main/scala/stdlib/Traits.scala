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
 * @param name traits
 */
object Traits extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * Similar to interfaces in Java, traits are used to define object types by specifying the signature of the supported methods. In traits methods can have default implementations. In contrast to classes, traits may not have constructor parameters.
   *
   * Here is an example:
   *
   * {{{
   * trait Similarity {
   * def isSimilar(x: Any): Boolean
   * def isNotSimilar(x: Any): Boolean = !isSimilar(x)
   * }
   * }}}
   *
   * This trait consists of two methods `isSimilar` and `isNotSimilar`. While `isSimilar` does not provide a concrete method implementation (it is abstract in the terminology of Java), method `isNotSimilar` defines a concrete implementation. Consequently, classes that integrate this trait only have to provide a concrete implementation for `isSimilar`. The behavior for `isNotSimilar` gets inherited directly from the trait.
   *
   * A class uses the `extends` keyword to mixin a trait if it is the only relationship the class inherits:
   */
  def similarToInterfacesTraits(res0: String) = {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") =>
            "An unfortunate moose stampede occurred"
          case _ => "Nothing of importance occurred"
        }
      }
    }

    val evt        = Event("Moose Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be(res0)
  }

  /**
   * A class can only extend from one class or trait, any subsequent extension should use the keyword `with`:
   */
  def extendsFromOneTraits(res0: String) = {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class OurListener

    class MyListener extends OurListener with EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Woodchuck Stampede") =>
            "An unfortunate woodchuck stampede occurred"
          case _ => "Nothing of importance occurred"
        }
      }
    }

    val evt        = Event("Woodchuck Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be(res0)
  }

  /**
   * Traits are polymorphic. Any type can be referred to by another type if related by extension:
   */
  def polymorphicTraits(res0: Boolean, res1: Boolean, res2: Boolean, res3: Boolean) = {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") =>
            "An unfortunate moose stampede occurred"
          case _ => "Nothing of importance occurred"
        }
      }
    }

    val myListener = new MyListener

    myListener.isInstanceOf[MyListener] should be(res0)
    myListener.isInstanceOf[EventListener] should be(res1)
    myListener.isInstanceOf[Any] should be(res2)
    myListener.isInstanceOf[AnyRef] should be(res3)
  }

  /**
   * Traits also can use self-types.  A self-type lists the required dependencies for mixing in the trait.  When mixing in the main trait, all self-type dependencies of that trait must also be mixed in, otherwise a compile-time error is thrown.
   *
   * Also, the dependencies can't have identical method/property names or else you'll get an `illegal inheritance` error.
   */
  def selfTypeTraits(res0: Int) = {
    trait B {
      def bId = 2
    }

    trait A { self: B =>

      def aId = 1
    }

    //val a = new A  //***does not compile!!!***
    val obj = new A with B
    (obj.aId + obj.bId) should be(res0)
  }
}
