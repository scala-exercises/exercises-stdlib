/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

import org.scalatest._
import scala.language.postfixOps

import Stream.cons

/** @param name traversables
 */
object Traversables extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** At the top of the collection hierarchy is the trait `Traversable`. Its only abstract operation is `foreach`:
   *
   * {{{
   * def foreach[U](f: Elem => U)
   * }}}
   *
   * Collection classes that implement `Traversable` just need to define this method; all other methods can be inherited from `Traversable`.
   *
   * The `foreach` method is meant to traverse all elements of the collection, and apply the given operation, `f`, to each element. The type of the operation is `Elem => U`, where `Elem` is the type of the collection's elements and `U` is an arbitrary result type. The invocation of `f` is done for its side effect only; in fact any function result of `f` is discarded by `foreach`.
   *
   * Traversables are the superclass of `List`, `Array`, `Map`, `Set`, `Stream` and more.  The methods involved can be applied to each other in a different type.
   `++` appends two `Traversable`s together. The resulting `Traversable` is the same type of the first element.
   */
  def topOfCollectionTraversables(res0: Int, res1: Int) {
    val set    = Set(1, 9, 10, 22)
    val list   = List(3, 4, 5, 10)
    val result = set ++ list
    result.size should be(res0)

    val result2 = list ++ set
    result2.size should be(res1)
  }

  /** `map` will apply the given function on all elements of a `Traversable` and return a new collection of the result:
   */
  def mapFunctionTraversables(res0: Option[Int]) {
    val set    = Set(1, 3, 4, 6)
    val result = set.map(_ * 4)
    result.lastOption should be(res0)
  }

  /** `flatten` will "pack" all child `Traversables` into a single `Traversable`:
   */
  def flattenFunctionTraversables(res0: List[Int]) {
    val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
    list.flatten should be(res0)
  }

  /** `flatMap` will not only apply the given function on all elements of a `Traversable`, but all elements within the elements and `flatten` the results:
   */
  def flatMapFunctionTraversables(res0: List[Int]) {
    val list   = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
    val result = list.flatMap(_.map(_ * 4))
    result should be(res0)
  }

  /** `flatMap` of `Options` will filter out all `None`s but keep the `Some`s:
   */
  def flatMapOfOptionsTraversables(res0: List[Int]) {
    val list   = List(1, 2, 3, 4, 5)
    val result = list.flatMap(it ⇒ if (it % 2 == 0) Some(it) else None)
    result should be(res0)
  }

  /** `collect` will apply a partial function to all elements of a `Traversable` and return a different collection. In this exercise, a case fragment is a partial function:
   */
  def collectFunctionTraversables(res0: List[Int]) {
    val list = List(4, 6, 7, 8, 9, 13, 14)
    val result = list.collect {
      case x: Int if (x % 2 == 0) ⇒ x * 3
    }
    result should be(res0)
  }

  /** Two case fragments can be chained to create a more robust result:
   */
  def collectFunctionIITraversables(res0: List[Int]) {
    val list = List(4, 6, 7, 8, 9, 13, 14)
    val partialFunction1: PartialFunction[Int, Int] = {
      case x: Int if x % 2 == 0 ⇒ x * 3
    }
    val partialFunction2: PartialFunction[Int, Int] = {
      case y: Int if y % 2 != 0 ⇒ y * 4
    }
    val result = list.collect(partialFunction1 orElse partialFunction2)
    result should be(res0)
  }

  /** `foreach` will apply a function to all elements of a `Traversable`, but unlike the `map` function, it will not return anything since the return type is `Unit` - an equivalent to a `void` return type in Java/C++:
   */
  def foreachFunctionTraversables(res0: List[Int]) {
    val list = List(4, 6, 7, 8, 9, 13, 14)
    list.foreach(num ⇒ println(num * 4))
    list should be(res0)
  }

  /** `toArray` will convert any `Traversable` to an `Array`, which is a special wrapper around a primitive Java array:
   */
  def toArrayFunctionTraversables(res0: Boolean) {
    val set    = Set(4, 6, 7, 8, 9, 13, 14)
    val result = set.toArray
    result.isInstanceOf[Array[Int]] should be(res0)
  }

  /** `toList` will convert any `Traversable` to a `List`.
   */
  def toListFunctionTraversables(res0: Boolean) {
    val set    = Set(4, 6, 7, 8, 9, 13, 14)
    val result = set.toList

    result.isInstanceOf[List[_]] should be(res0)
  }

  /** `toList`, as well as other conversion methods such as `toSet` and `toArray`, will not convert if the collection type is the same:
   */
  def toListFunctionIITraversables(res0: Boolean) {
    val list   = List(5, 6, 7, 8, 9)
    val result = list.toList
    result eq list should be(res0)
  }

  /** `toIterable` will convert any `Traversable` to an `Iterable`. This is a base `trait` for all Scala collections that define an iterator method to iterate through the collection's elements:
   */
  def toIterableFunctionTraversables(res0: Boolean) {
    val set    = Set(4, 6, 7, 8, 9, 13, 14)
    val result = set.toIterable
    result.isInstanceOf[Iterable[_]] should be(res0)
  }

  /** `toSeq` will convert any `Traversable` to a `Seq` which is an ordered `Iterable` and the superclass to `List`, `Queue`, and `Vector`. `Sequences` provide a method apply for indexing. Indices range from 0 up to the length of a sequence:
   */
  def toSeqFunctionTraversables(res0: Boolean) {
    val set    = Set(4, 6, 7, 8, 9, 13, 14)
    val result = set.toSeq
    result.isInstanceOf[Seq[_]] should be(res0)
  }

  /** `toIndexedSeq` will convert any `Traversable` to an `IndexedSeq` which is an indexed sequence used in `Vectors` and `Strings`:
   */
  def toIndexedSeqFunctionTraversables(res0: Boolean) {
    val set    = Set(4, 6, 7, 8, 9, 13, 14)
    val result = set.toIndexedSeq
    result.isInstanceOf[IndexedSeq[_]] should be(res0)
  }

  /** `toStream` will convert any `Traversable` to a `Stream` which is a lazy list where elements are evaluated as they are needed:
   */
  def toStreamFunctionTraversables(res0: Boolean, res1: Stream[Int]) {
    val list   = List(4, 6, 7, 8, 9, 13, 14)
    val result = list.toStream
    result.isInstanceOf[Stream[_]] should be(res0)
    (result take 3) should be(res1)
  }

  /** `toSet` will convert any `Traversable` to a `Set` which is a collection of unordered, unique values:
   */
  def toSetFunctionTraversables(res0: Boolean) {
    val list   = List(4, 6, 7, 8, 9, 13, 14)
    val result = list.toSet
    result.isInstanceOf[Set[_]] should be(res0)
  }

  /** `toMap` will convert any `Traversable` to a `Map`. How it's used depends on the original collection; if it's a `List` or `Seq`, it should be of parameterized type `Tuple2`:
   */
  def toMapFunctionTraversables(res0: Boolean) {
    val list   = List("Phoenix" → "Arizona", "Austin" → "Texas")
    val result = list.toMap
    result.isInstanceOf[Map[_, _]] should be(res0)
  }

  /** `toMap` will also convert a `Set` to a `Map`; it should be of parameterized type `Tuple2`:
   */
  def toMapFunctionIITraversables(res0: Boolean) {
    val set    = Set("Phoenix" → "Arizona", "Austin" → "Texas")
    val result = set.toMap
    result.isInstanceOf[Map[_, _]] should be(res0)
  }

  /** `isEmpty` is pretty self-evident:
   */
  def isEmptyFunctionTraversables(res0: Boolean, res1: Boolean) {
    val map = Map("Phoenix" → "Arizona", "Austin" → "Texas")
    map.isEmpty should be(res0)

    val set = Set()
    set.isEmpty should be(res1)
  }

  /** `nonEmpty` is pretty self-evident too:
   */
  def nonEmptyFunctionTraversables(res0: Boolean, res1: Boolean) {
    val map = Map("Phoenix" → "Arizona", "Austin" → "Texas")
    map.nonEmpty should be(res0)

    val set = Set()
    set.nonEmpty should be(res1)
  }

  /** `size` provides the size of the traversable:
   */
  def sizeFunctionTraversables(res0: Int) {
    val map = Map("Phoenix" → "Arizona", "Austin" → "Texas")
    map.size should be(res0)
  }

  /** `hasDefiniteSize` will return `true` if the traversable has a finite end, otherwise `false`:
   */
  def hasDefiniteSizeFunctionTraversables(res0: Boolean, res1: Boolean) {
    val map = Map("Phoenix" → "Arizona", "Austin" → "Texas")
    map.hasDefiniteSize should be(res0)

    val stream = cons(0, cons(1, Stream.empty))
    stream.hasDefiniteSize should be(res1)
  }

  /** `head` will return the first element of an ordered collection, or some random element if order is not defined like in a `Set` or `Map`:
   */
  def headFunctionTraversables(res0: Int) {
    val list = List(10, 19, 45, 1, 22)
    list.head should be(res0)
  }

  /** `headOption` will return the first element as an `Option` of an ordered collection, or some random element if order is not defined. If a first element is not available, then `None` is returned:
   */
  def headOptionFunctionTraversables(res0: Option[Int], res1: Option[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.headOption should be(res0)

    val list2 = List()
    list2.headOption should be(res1)
  }

  /** `last` will return the last element of an ordered collection, or some random element if order is not defined:
   */
  def lastFunctionTraversables(res0: Int) {
    val list = List(10, 19, 45, 1, 22)
    list.last should be(res0)
  }

  /** `lastOption` will return the last element as an `Option` of an ordered collection, or some random element if order is not defined. If a last element is not available, then `None` is returned:
   */
  def lastOptionFunctionTraversables(res0: Option[Int], res1: Option[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.lastOption should be(res0)

    val list2 = List()
    list2.lastOption should be(res1)
  }

  /** `find` will locate the first item that matches the predicate `p` as `Some`, or `None` if an element is not found:
   */
  def findFunctionTraversables(res0: Option[Int], res1: Option[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.find(_ % 2 != 0) should be(res0)

    val list2 = List(4, 8, 16)
    list2.find(_ % 2 != 0) should be(res1)
  }

  /** `tail` will return the rest of the collection without the head:
   */
  def tailFunctionTraversables(res0: List[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.tail should be(res0)
  }

  /** `init` will return the rest of the collection without the last:
   */
  def initFunctionTraversables(res0: List[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.init should be(res0)
  }

  /** Given a `from` index, and a `to` index, `slice` will return the part of the collection including `from`, and excluding `to`:
   */
  def sliceFunctionTraversables(res0: List[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.slice(1, 3) should be(res0)
  }

  /** `take` will return the first number of elements given:
   */
  def takeFunctionTraversables(res0: List[Int]) {
    val list = List(10, 19, 45, 1, 22)
    list.take(3) should be(res0)
  }

  /** `take` is used often with `Streams`, since they are also `Traversable`:
   */
  def takeFunctionIITraversables(res0: List[Int]) {
    def streamer(v: Int): Stream[Int] = cons(v, streamer(v + 1))
    val a                             = streamer(2)
    (a take 3 toList) should be(res0)
  }

  /** `drop` will take the rest of the `Traversable` except the number of elements given:
   */
  def dropFunctionTraversables(res0: List[Int]) {
    def streamer(v: Int): Stream[Int] = cons(v, streamer(v + 1))
    val a                             = streamer(2)
    ((a drop 6) take 3).toList should be(res0)
  }

  /** `takeWhile` will continually accumulate elements until a predicate is no longer satisfied:
   */
  def takeWhileFunctionTraversables(res0: List[Int]) {
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    list.takeWhile(_ < 100) should be(res0)
  }

  /** `dropWhile` will continually drop elements until a predicate is no longer satisfied:
   */
  def dropWhileFunctionTraversables(res0: List[Int]) {
    val list = List(87, 44, 5, 4, 200, 10, 39, 100)
    list.dropWhile(_ < 100) should be(res0)
  }

  /** `filter` will take out all elements that don't satisfy a predicate. (An `Array` is also `Traversable`.)
   */
  def filterFunctionTraversables(res0: Array[Int]) {
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
    array.filter(_ < 100) should be(res0)
  }

  /** `filterNot` will take out all elements that satisfy a predicate:
   */
  def filterNotFunctionTraversables(res0: Array[Int]) {
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
    array.filterNot(_ < 100) should be(res0)
  }

  /** `splitAt` will split a `Traversable` at a position, returning a 2 product `Tuple`. `splitAt` is also defined as `(xs take n, xs drop n)`
   */
  def splitAtFunctionTraversables(res0: Array[Int], res1: Array[Int]) {
    val array  = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val result = array splitAt 3
    result._1 should be(res0)
    result._2 should be(res1)
  }

  /** `span` will split a `Traversable` according to a predicate, returning a 2 product `Tuple`.  `span` is also defined as `(xs takeWhile p, xs dropWhile p)`
   */
  def spanFunctionTraversables(res0: Array[Int], res1: Array[Int]) {
    val array  = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val result = array span (_ < 100)
    result._1 should be(res0)
    result._2 should be(res1)
  }

  /** `partition` will split a `Traversable` according to a predicate, returning a 2 product `Tuple`. The left-hand side contains the elements satisfied by the predicate whereas the right hand side contains the rest of the elements. `partition` is also defined as `(xs filter p, xs filterNot p)`
   */
  def partitionFunctionTraversables(res0: Array[Int], res1: Array[Int]) {
    val array  = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val result = array partition (_ < 100)
    result._1 should be(res0)
    result._2 should be(res1)
  }

  /** `groupBy` will categorize a `Traversable` according to a given function and return a map with the results.  This exercise uses partial function chaining:
   */
  def groupByFunctionTraversables(res0: Int, res1: Int) {
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

    val oddAndSmallPartial: PartialFunction[Int, String] = {
      case x: Int if x % 2 != 0 && x < 100 ⇒ "Odd and less than 100"
    }

    val evenAndSmallPartial: PartialFunction[Int, String] = {
      case x: Int if x != 0 && x % 2 == 0 && x < 100 ⇒ "Even and less than 100"
    }

    val negativePartial: PartialFunction[Int, String] = {
      case x: Int if x < 0 ⇒ "Negative Number"
    }

    val largePartial: PartialFunction[Int, String] = {
      case x: Int if x > 99 ⇒ "Large Number"
    }

    val zeroPartial: PartialFunction[Int, String] = {
      case x: Int if x == 0 ⇒ "Zero"
    }

    val result = array groupBy {
      oddAndSmallPartial orElse
        evenAndSmallPartial orElse
        negativePartial orElse
        largePartial orElse
        zeroPartial
    }

    (result("Even and less than 100") size) should be(res0)
    (result("Large Number") size) should be(res1)
  }

  /** `forall` will determine if a predicate is valid for all members of a `Traversable`:
   */
  def forallFunctionTraversables(res0: Boolean) {
    val list   = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list forall (_ < 100)
    result should be(res0)
  }

  /** `exists` will determine if a predicate is valid for some members of a `Traversable`:
   */
  def existsFunctionTraversables(res0: Boolean) {
    val list   = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list exists (_ < 100)
    result should be(res0)
  }

  /** `count` will count the number of elements that satisfy a predicate in a `Traversable`:
   */
  def countFunctionTraversables(res0: Int) {
    val list   = List(87, 44, 5, 4, 200, 10, 39, 100)
    val result = list count (_ < 100)
    result should be(res0)
  }

  /** `foldLeft` will combine an operation starting with a seed and combining from the left.  `foldLeft` takes as a first parameter the initial value of the fold.  Once the fold is established, you provide a function that takes two arguments.  The first argument is the running total of the operation, and the second element is the next element of the list.
   *
   * Given a `Traversable (x1, x2, x3, x4)`, an initial value of `init`, an operation `op`, `foldLeft` is defined as: `(((init op x1) op x2) op x3) op x4)`
   */
  def foldLeftFunctionTraversables(res0: Int, res1: Int, res2: Int) {
    val list = List(5, 4, 3, 2, 1)
    val result = list.foldLeft(0) { (`running total`, `next element`) ⇒
      `running total` - `next element`
    }
    result should be(res0)

    val result2 = list.foldLeft(0)(_ - _) //Short hand
    result2 should be(res1)

    (((((0 - 5) - 4) - 3) - 2) - 1) should be(res2)
  }

  /** `foldRight` will combine an operation starting with a seed and combining from the right.  `foldRight` takes as a first parameter the initial value of the fold.  Once the fold is established, you  provide a function that takes two elements.  The first is the next element of the list, and the second element is the running total of the operation.
   *
   * Given a `Traversable (x1, x2, x3, x4)`, an initial value of `init`, an operation `op`, `foldRight` is defined as: `x1 op (x2 op (x3 op (x4 op init)))`
   */
  def foldRightFunctionTraversables(res0: Int, res1: Int, res2: Int) {
    val list = List(5, 4, 3, 2, 1)
    val result = list.foldRight(0) { (`next element`, `running total`) ⇒
      `next element` - `running total`
    }
    result should be(res0)

    val result2 = list.foldRight(0)(_ - _) //Short hand
    result2 should be(res1)

    (5 - (4 - (3 - (2 - (1 - 0))))) should be(res2)
  }

  /** `reduceLeft` is similar to `foldLeft`, except that the seed is the head value:
   */
  def reduceLeftFunctionTraversables(res0: Int, res1: String) {
    val intList = List(5, 4, 3, 2, 1)
    intList.reduceLeft {
      _ + _
    } should be(res0)

    val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
    stringList.reduceLeft {
      _ + _
    } should be(res1)
  }

  /** `reduceRight` is similar to `foldRight`, except that the seed is the last value:
   */
  def reduceRightFunctionTraversables(res0: Int, res1: String) {
    val intList = List(5, 4, 3, 2, 1)
    intList.reduceRight {
      _ + _
    } should be(res0)

    val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
    stringList.reduceRight {
      _ + _
    } should be(res1)
  }

  /** There are some methods that take much of the folding work out by providing basic functionality. `sum` will add all the elements, `product` will multiply, `min` would determine the smallest element, and `max` the largest:
   */
  def sumFunctionTraversables(res0: Int, res1: Int, res2: Int, res3: Int) {
    val intList = List(5, 4, 3, 2, 1)
    intList.sum should be(res0)
    intList.product should be(res1)
    intList.max should be(res2)
    intList.min should be(res3)
  }

  /** The naive recursive implementation of `reduceRight` is not tail recursive and would lead to a stack overflow if used on larger traversables.
   * However, `reduceLeft` can be implemented with tail recursion.
   *
   * To avoid the potential stack overflow with the naive implementation of `reduceRight` we can easily implement it based on `reduceLeft` by reverting the list and the inverting the reduce function.
   * The same applies for folding operations.
   *
   * There is also a `reduce` (and `fold`) available, which works exactly like `reduceLeft` (and `foldLeft`) and it should be the prefered method to call unless there is a strong reason to use `reduceRight` (or `foldRight`).
   */
  def reduceRightAsReduceLeft(res0: Int, res1: Int, res2: Int) {
    val intList = List(5, 4, 3, 2, 1)
    intList.reduceRight((x, y) => x - y) should be(res0)
    intList.reverse.reduceLeft((x, y) => y - x) should be(res1)
    intList.reverse.reduce((x, y) => y - x) should be(res2)
  }

  /** `transpose` will take a traversable of traversables and group them by their position in it's own traversable, e.g.:
   * `((x1, x2),(y1, y2)).transpose = (x1, y1), (x2, y2)` or
   * `((x1, x2, x3),(y1, y2, y3),(z1, z2, z3)).transpose = ((x1, y1, z1), (x2, y2, z2), (x3, y3, z3))`
   */
  def transposeFunctionTraversables(
      res0: List[Int],
      res1: List[Int],
      res2: List[Int],
      res3: List[Int]) {
    val list = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    list.transpose should be(List(res0, res1, res2))

    val list2 = List(List(1), List(4))
    list2.transpose should be(List(res3))
  }

  /** `mkString` will format a `Traversable` using a given string as the delimiter:
   */
  def mkStringFunctionTraversables(res0: String) {
    val list = List(1, 2, 3, 4, 5)
    list.mkString(",") should be(res0)
  }

  /** `mkString` will also take a beginning and ending string to surround the list.:
   */
  def mkStringFunctionIITraversables(res0: String) {
    val list = List(1, 2, 3, 4, 5)
    list.mkString(">", ",", "<") should be(res0)
  }

  /** `addString` will take a StringBuilder to add the contents of list into the builder.
   */
  def addStringFunctionTraversables(res0: String) {
    val stringBuilder = new StringBuilder()
    val list          = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    stringBuilder.append("I want all numbers 6-12: ")
    list.filter(it ⇒ it > 5 && it < 13).addString(stringBuilder, ",")
    stringBuilder.mkString should be(res0)
  }

}
