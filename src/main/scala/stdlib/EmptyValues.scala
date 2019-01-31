/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name empty_values
 *
 */
object EmptyValues extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** ==null==
   *
   * Scala's `null` is the same as in Java. Any reference type can be `null`, like Strings, Objects, or your own classes. Also just like Java, value types like Ints can't be `null`.
   *
   * ==Null==
   *
   * [[https://www.scala-lang.org/api/current/scala/Null.html Null]] is a trait whose only instance is `null`. It is a subtype of all reference types, but not of value types. It purpose in existing is to make it so reference types can be assigned `null` and value types can't.
   *
   * ==Nothing==
   *
   * [[https://www.scala-lang.org/api/current/scala/Nothing.html Nothing]] is a trait that is guaranteed to have zero instances. It is a subtype of all other types. It has two main reasons for existing: to provide a return type for methods that never return normally (i.e. a method that always throws an exception). The other reason is to provide a type for Nil (explained below).
   *
   * ==Unit==
   *
   * [[https://www.scala-lang.org/api/current/scala/Unit.html Unit]] in Scala is the equivalent of `void` in Java. It's used in a function's signature when that function doesn't return a value.
   *
   * ==Nil==
   *
   * [[https://www.scala-lang.org/api/current/scala/collection/immutable/Nil$.html Nil]] is just an empty list, exactly like the result of `List()`. It is of type `List[Nothing]`. And since we know there are no instances of Nothing, we now have a list that is statically verifiable as empty. Nice to have.
   *
   * An empty list can be represented by another nothing value: `Nil`
   */
  def emptyValuesEmptyValues(res0: Boolean) {
    List() === Nil shouldBe res0
  }

  /** [[https://www.scala-lang.org/api/current/scala/None$.html None]] is the counterpart to [[https://www.scala-lang.org/api/current/scala/Some.html Some]], used when you're using Scala's [[https://www.scala-lang.org/api/current/scala/Option.html Option]] class to help avoid `null` references.
   *
   * `None` equals `None`:
   */
  def avoidingNullEmptyValues(res0: Boolean) {
    None === None shouldBe res0
  }

  /** `None` should be identical to `None`:
   */
  def identicalNoneEmptyValues(res0: Boolean) {
    None eq None shouldBe res0
  }

  /** `None` can be converted to a String:
   */
  def noneToStringEmptyValues(res0: String) {
    assert(None.toString === res0)
  }

  /** `None` can be converted to an empty list:
   */
  def noneToListEmptyValues(res0: Boolean) {
    None.toList === Nil shouldBe res0
  }

  /** `None` is considered empty:
   */
  def noneAsEmptyEmptyValues(res0: Boolean) {
    assert(None.isEmpty === res0)
  }

  /** `None` can be cast to `Any`, `AnyRef` or `AnyVal`:
   */
  def noneToAnyEmptyValues(res0: Boolean, res1: Boolean, res2: Boolean) {
    None.asInstanceOf[Any] === None shouldBe res0
    None.asInstanceOf[AnyRef] === None shouldBe res1
    None.asInstanceOf[AnyVal] === None shouldBe res2
  }

  /** `None` can be used with `Option` instead of null references:
   */
  def noneWithOptionEmptyValues(res0: Boolean, res1: Option[String]) {
    val optional: Option[String] = None
    assert(optional.isEmpty === res0)
    assert(optional === res1)
  }

  /** `Some` is the opposite of `None` for `Option` types:
   */
  def someAgainstNoneEmptyValues(res0: Boolean, res1: Boolean) {
    val optional: Option[String] = Some("Some Value")
    assert((optional == None) === res0, "Some(value) should not equal None")
    assert(optional.isEmpty === res1, "Some(value) should not be empty")
  }

  /** `Option.getOrElse` can be used to provide a default in the case of `None`:
   */
  def getOrElseEmptyValues(res0: String, res1: String) {
    val optional: Option[String]  = Some("Some Value")
    val optional2: Option[String] = None
    assert(optional.getOrElse("No Value") === res0, "Should return the value in the option")
    assert(optional2.getOrElse("No Value") === res1, "Should return the specified default value")
  }

}
