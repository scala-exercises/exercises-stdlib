/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name composition
 *
 */
object Composition
    extends FlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** Function `composition` is a functional programming and mathematical transformation that through the combination of two existing functions generates a new function. Mathematically speaking we refer at composition as: `g(x) O f(x) = f(g(x))`
    * Scala provides a method called compose that can be used this way:
   */
  def composeFunctions(res0: String) {
    def f(s: String) = "f(" + s + ")"
    def g(s: String) = "g(" + s + ")"

    val composedFunction = f _ compose g _  //Here we compose the functions

    composedFunction("Scala Exercises") should be(res0)
  }

  /**
    * There is also a method andThen, closely related to compose.
    * The only difference between andThen and compose is that the order of evaluation for compose is right to left.
    */
  def andThenFunctions(res0: String) {
    def f(s: String) = "f(" + s + ")"
    def g(s: String) = "g(" + s + ")"

    val composedFunction = g _ andThen f _

    composedFunction("Scala Exercises") should be(res0)
  }
}
