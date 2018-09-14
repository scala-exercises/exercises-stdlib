/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name lists
 *
 */
object Lists extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** Scala Lists are quite similar to arrays, which means all the elements of a list have the same type - but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat. The type of a list that has elements of type `T` is written as `List[T]`.
   *
   * `eq` tests identity (same object):
   */
  def similarToArraysLists(res0: Boolean) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a eq b) should be(res0)
  }

  /** `==` tests equality (same content):
   */
  def sameContentLists(res0: Boolean) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a == b) should be(res0)
  }

  /** Nil lists are identical, even of different types:
   */
  def nilListsLists(
      res0: Boolean,
      res1: Boolean,
      res2: Boolean,
      res3: Boolean,
      res4: Boolean,
      res5: Boolean) {
    val a: List[String] = Nil
    val b: List[Int]    = Nil

    (a == Nil) should be(res0)
    (a eq Nil) should be(res1)

    (b == Nil) should be(res2)
    (b eq Nil) should be(res3)

    (a == b) should be(res4)
    (a eq b) should be(res5)
  }

  /** Lists can be easily created:
   */
  def easilyCreatedLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 2, 3)
    a should equal(List(res0, res1, res2))
  }

  /** Lists can be accessed via `head`, `headOption` and `tail`. Accessing a list via `head` is unsafe and may result in a `IndexOutOfBoundsException`.
   */
  def headAndTailLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 2, 3)
    a.headOption should equal(Some(res0))
    a.tail should equal(List(res1, res2))
  }

  /** Lists can be accessed by position:
   */
  def byPositionLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 3, 5, 7, 9)
    a(0) should equal(res0)
    a(2) should equal(res1)
    a(4) should equal(res2)

    intercept[IndexOutOfBoundsException] {
      println(a(5))
    }
  }

  /** Lists are immutable:
   */
  def areImmutableLists(res0: Int, res1: Int, res2: Int, res3: Int) {
    val a = List(1, 3, 5, 7, 9)
    val b = a.filterNot(v ⇒ v == 5) // remove where value is 5

    a should equal(List(1, 3, 5, 7, 9))
    b should equal(List(res0, res1, res2, res3))
  }

  /** Lists have many useful utility methods.
    *
    * `reverse` return a reversed copy of the list:
    */
  def reverseLists(res0: Int, res1: List[Int]) {
    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(res0)

    // reverse the list
    a.reverse should equal(res1)
  }

  /** `filter` tests each element of the List by applying a function you supply:
    */
  def filterLists(res0: List[Int], res1: List[Int], res2: List[Int]) {
    val a = List(1, 3, 5, 7, 9)

    // filter any values divisible by 3 in the list
    a.filter { v ⇒
      v % 3 == 0
    } should equal(res0)

    // Functions over lists can use _ as shorthand
    a.filter {
      _ % 2 == 0
    } should equal(res1)

    // Functions over lists can use () instead of {}
    a.filter(_ % 2 != 0) should equal(res2)
  }

  /** `map` works by applying a function to each element in the list:
    */
  def mapLists(res0: List[Int], res1: List[Int], res2: List[Int]) {
    val a = List(1, 3, 5, 7, 9)

    // map a function to double the numbers over the list
    a.map { v ⇒
      v * 2
    } should equal(res0)

    // Functions over lists can use _ as shorthand
    a.map {
      _ + 2
    } should equal(res1)

    // Functions over lists can use () instead of {}
    a.map(_ * 2) should equal(res2)
  }

  /** `flatten` The flatten method takes a list of lists and flattens it out to a single list:
    */
  def flattenLists(res0: List[Int], res1: List[Int]) {
    val a = List(List(1,2), List(3,4))
    val b = List(1,2)

    a.flatten should equal(res0)

    b.map { v =>
      List(v*v, v*v*v)
    }.flatten should equal(res1)
  }

  /** `flatMap` works by applying a function which returns a sequence of each element in the list:
    */
  def flatMapLists(res0: List[Int], res1: Boolean) {
    val a = List(1,2)

    // The flatMap operator is similar to map, but it takes a function returning a list of elements
    a.flatMap { v =>
      List(v*v, v*v*v)
    } should equal(res0)

    // flatMap is same as you apply map first and then flatten
    val b = a.flatMap { v =>
              List(v*v, v*v*v)
            }

    val c = a.map { v =>
              List(v*v, v*v*v)
            }.flatten

    (b == c) should be(res1)
  }
  
  /** Lists can be reduced with a mathematical operation:
   */
  def reducingListsLists(res0: Int, res1: Int) {
    val a = List(1, 3, 5, 7)
    a.reduceLeft(_ + _) should equal(res0)
    a.reduceLeft(_ * _) should equal(res1)
  }

  /** `foldLeft` is like `reduce`, but with an explicit starting value:
   */
  def foldLeftLists(res0: Int, res1: Int, res2: Int, res3: Int) {
    val a = List(1, 3, 5, 7)
    // NOTE: foldLeft uses a form called currying that we will explore later
    a.foldLeft(0)(_ + _) should equal(res0)
    a.foldLeft(10)(_ + _) should equal(res1)
    a.foldLeft(1)(_ * _) should equal(res2)
    a.foldLeft(0)(_ * _) should equal(res3)
  }

  /** You can create a list from a range:
   */
  def fromRangeLists(res0: List[Int]) {
    val a = (1 to 5).toList
    a should be(res0)
  }

  /** You can prepend elements to a List to get a new List:
   */
  def addElementsLists(res0: List[Int]) {
    val a = List(1, 3, 5, 7)

    0 :: a should be(res0)
  }

  /** Lists can be concatened and Nil is an empty List:
   */
  def concatenateLists(res0: List[Int], res1: List[Int]) {
    val head = List(1, 3)
    val tail = List(5, 7)

    head ::: tail should be(res0)
    head ::: Nil should be(res1)
  }

  /** Lists reuse their tails:
   */
  def reuseTailsLists(
      res0: Int,
      res1: Int,
      res2: Int,
      res3: List[Int],
      res4: List[Int],
      res5: List[Int]) {
    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b

    a should be(List(res0, res1, res2))
    a.tail should be(res3)
    b.tail should be(res4)
    c.tail should be(res5)
  }
}
