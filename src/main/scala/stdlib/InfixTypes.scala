/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name infix_types
 *
 */
object InfixTypes extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** An infix type `T1 op T2` consists of an infix operator `op` which gets applied to two
   * type operands `T1` and `T2`. The type is equivalent to the type application `op[T1,T2]`.
   *
   * The infix operator `op` may be an arbitrary identifier, except for `*`, which is reserved
   * as a postfix modifier denoting a repeated parameter type.
   *
   * We can make a type infix, meaning that the type can be displayed in complement between two types in order to make a readable declaration:
   */
  def infixTypeInfixTypes(res0: String) {
    case class Person(name: String)
    class Loves[A, B](val a: A, val b: B)

    def announceCouple(couple: Person Loves Person) =
      //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name

    val romeo  = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(new Loves(romeo, juliet)) should be(res0)
  }

  /** Of course we can make this a bit more elegant by creating an infix operator method to use with our infix type:
   */
  def infixOperatorInfixTypes(res0: String) {
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
