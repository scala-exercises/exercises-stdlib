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
 *   extractors
 */
object Extractors extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * In Scala, patterns can be defined independently of case classes. To this end, a method named
   * `unapply` is defined to yield a so-called extractor.
   *
   * For instance, the following code defines an extractor object `Twice`.
   *
   * {{{
   * object Twice {
   * def apply(x: Int): Int = x * 2
   * def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
   * }
   *
   * object TwiceTest extends Application {
   * val x = Twice(21)
   * x match { case Twice(n) => Console.println(n) } // prints 21
   * }
   * }}}
   *
   * There are two syntactic conventions at work here:
   *
   *   - The pattern `case Twice(n)` will cause an invocation of `Twice.unapply`, which is used to
   *     match even number; the return value of the `unapply` signals whether the argument has
   *     matched or not, and any sub-values that can be used for further matching. Here, the
   *     sub-value is `z/2`
   *   - The `apply` method is not necessary for pattern matching. It is only used to mimick a
   *     constructor. `val x = Twice(21)` expands to `val x = Twice.apply(21)`.
   *
   * The code in the preceding example would be expanded as follows:
   *
   * {{{
   * object TwiceTest extends Application {
   * val x = Twice.apply(21)
   * Twice.unapply(x) match { case Some(n) => Console.println(n) } // prints 21
   * }
   * }}}
   * The return type of an `unapply` should be chosen as follows:
   *
   *   - If it is just a test, return a `Boolean`. For instance `case even()`
   *   - If it returns a single sub-value of type `T`, return a `Option[T]`
   *   - If you want to return several sub-values `T1,...,Tn`, group them in an optional tuple
   *     `Option[(T1,...,Tn)]`.
   *
   * Sometimes, the number of sub-values isn't fixed and we would like to return a sequence. For
   * this reason, you can also define patterns through `unapplySeq`. The last sub-value type `Tn`
   * has to be `Seq[S]`. This mechanism is used for instance in pattern `case List(x1, ..., xn)`.
   *
   * When you create a case class, it automatically can be used with pattern matching since it has
   * an extractor:
   */
  def extractorsExtractors(res0: String) = {
    case class Employee(firstName: String, lastName: String)

    val rob = new Employee("Robin", "Williams")
    val result = rob match {
      case Employee("Robin", _) => "Where's Batman?"
      case _                    => "No Batman Joke For You"
    }

    result should be(res0)
  }

  /**
   * What's an extractor? In Scala it's a method in any `object` called `unapply`, and that method
   * is used to disassemble the object given by returning a tuple wrapped in an option. Extractors
   * can be used to assign values:
   */
  def calledUnapplyExtractors(res0: String, res1: String, res2: Int, res3: Int) = {
    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

    object ChopShop {
      def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
    }

    val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)

    a should be(res0)
    b should be(res1)
    c should be(res2)
    d should be(res3)
  }

  /**
   * An extractor can also be used in pattern matching:
   */
  def patternMatchingExtractors(res0: String, res1: String) = {
    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

    object ChopShop {
      def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
    }

    val x = new Car("Chevy", "Camaro", 1978, 120) match {
      case ChopShop(s, t, u, v) => (s, t)
      case _                    => ("Ford", "Edsel")
    }

    x._1 should be(res0)
    x._2 should be(res1)
  }

  /**
   * Since we aren't really using `u` and `v` in the previous pattern matching, they can be replaced
   * with `_`:
   */
  def withWildcardExtractors(res0: String, res1: String) = {
    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

    object ChopShop {
      def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))
    }

    val x = new Car("Chevy", "Camaro", 1978, 120) match {
      case ChopShop(s, t, _, _) => (s, t)
      case _                    => ("Ford", "Edsel")
    }

    x._1 should be(res0)
    x._2 should be(res1)
  }

  /**
   * As long as the method signatures aren't the same, you can have as many unapply methods as you
   * want:
   */
  def multipleUnapplyExtractors(res0: String) = {
    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)
    class Employee(val firstName: String, val middleName: Option[String], val lastName: String)

    object Tokenizer {
      def unapply(x: Car) = Some((x.make, x.model, x.year, x.topSpeed))

      def unapply(x: Employee) = Some((x.firstName, x.lastName))
    }

    val result = new Employee("Kurt", None, "Vonnegut") match {
      case Tokenizer(c, d) => "c: %s, d: %s".format(c, d)
      case _               => "Not found"
    }

    result should be(res0)
  }

  /**
   * An extractor can be any stable object, including instantiated classes with an unapply method:
   */
  def anyObjectExtractors(res0: String) = {
    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short) {
      def unapply(x: Car) = Some((x.make, x.model))
    }

    val camaro = new Car("Chevy", "Camaro", 1978, 122)

    val result = camaro match {
      case camaro(make, model) => "make: %s, model: %s".format(make, model)
      case _                   => "unknown"
    }

    result should be(res0)
  }

  /**
   * A custom extractor is typically created in the companion object of the class. In this exercise,
   * we use it as an assignment:
   */
  def asAssignmentExtractors(res0: String, res1: Option[String], res2: String) = {
    class Employee(
        val firstName: String,
        val middleName: Option[String],
        val lastName: String
    )

    object Employee {
      //factory methods, extractors, apply
      //Extractor: Create tokens that represent your object
      def unapply(x: Employee) =
        Some((x.lastName, x.middleName, x.firstName))
    }

    val singri = new Employee("Singri", None, "Keerthi")

    val Employee(a, b, c) = singri

    a should be(res0)
    b should be(res1)
    c should be(res2)
  }

  /**
   * In this exercise we use `unapply` for pattern matching employee objects:
   */
  def unapplyForPatternMatchingExtractors(res0: String) = {
    class Employee(
        val firstName: String,
        val middleName: Option[String],
        val lastName: String
    )

    object Employee {
      //factory methods, extractors, apply
      //Extractor: Create tokens that represent your object
      def unapply(x: Employee) =
        Some((x.lastName, x.middleName, x.firstName))
    }

    val singri = new Employee("Singri", None, "Keerthi")

    val result = singri match {
      case Employee("Singri", None, x) =>
        "Yay, Singri %s! with no middle name!".format(x)
      case Employee("Singri", Some(x), _) =>
        "Yay, Singri with a middle name of %s".format(x)
      case _ => "I don't care, going on break"
    }

    result should be(res0)
  }

}
