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
 * @param name infix_types
 */
object InfixTypes extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * An infix type `T1 op T2` consists of an infix operator `op` which gets applied to two
   * type operands `T1` and `T2`. The type is equivalent to the type application `op[T1,T2]`.
   *
   * The infix operator `op` may be an arbitrary identifier, except for `*`, which is reserved
   * as a postfix modifier denoting a repeated parameter type.
   *
   * We can make a type infix, meaning that the type can be displayed in complement between two types in order to make a readable declaration:
   */
  def infixTypeInfixTypes(res0: String) = {
    case class Person(name: String)
    class Loves[A, B](val a: A, val b: B)

    def announceCouple(couple: Person Loves Person) =
      //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name

    val romeo  = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(new Loves(romeo, juliet)) should be(res0)
  }

  /**
   * Of course we can make this a bit more elegant by creating an infix operator method to use with our infix type:
   */
  def infixOperatorInfixTypes(res0: String) = {
    case class Person(name: String) {
      def loves(person: Person) = new Loves(this, person)
    }

    class Loves[A, B](val a: A, val b: B)

    def announceCouple(couple: Person Loves Person) =
      //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name

    val romeo  = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(romeo loves juliet) should be(res0)
  }

}
