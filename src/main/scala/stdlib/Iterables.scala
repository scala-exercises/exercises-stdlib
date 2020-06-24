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
 * @param name iterables
 */
object Iterables extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /**
   * The next trait from the top in the collections hierarchy is `Iterable`. All methods in this trait are defined in terms of an abstract method, `iterator`, which yields the collection's elements one by one. The `foreach` method from trait `Traversable` is implemented in `Iterable` in terms of `iterator`. Here is the actual implementation:
   *
   * {{{
   * def foreach[U](f: Elem => U): Unit = {
   * val it = iterator
   * while (it.hasNext) f(it.next())
   * }
   * }}}
   *
   * Quite a few subclasses of `Iterable` override this standard implementation of `foreach` in `Iterable`, because they can provide a more efficient implementation. Remember that `foreach` is the basis of the implementation of all operations in `Traversable`, so its performance matters.
   *
   * Some common iterables are `Set`, `List`, `Vector`, `Stack` and `Stream`. Iterator has two important methods: `hasNext`, which answers whether the iterator has another element available, and `next` which returns the next element in the iterator.
   */
  def collectionIterablesIterables(res0: Int) = {
    val list = List(3, 5, 9, 11, 15, 19, 21)
    val it   = list.iterator
    if (it.hasNext)
      it.next should be(res0)
  }

  /**
   * `grouped` will return fixed-size `Iterable` chunks of an `Iterable`:
   */
  def groupedIterables(
      res0: Int,
      res1: Int,
      res2: Int,
      res3: Int,
      res4: Int,
      res5: Int,
      res6: Int,
      res7: Int,
      res8: Int
  ) = {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it   = list grouped 3
    it.next() should be(List(res0, res1, res2))
    it.next() should be(List(res3, res4, res5))
    it.next() should be(List(res6, res7, res8))
  }

  /**
   * `sliding` will return an `Iterable` that shows a sliding window of an `Iterable`.
   */
  def slidingIterables(
      res0: Int,
      res1: Int,
      res2: Int,
      res3: Int,
      res4: Int,
      res5: Int,
      res6: Int,
      res7: Int,
      res8: Int
  ) = {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it   = list sliding 3
    it.next() should be(List(res0, res1, res2))
    it.next() should be(List(res3, res4, res5))
    it.next() should be(List(res6, res7, res8))
  }

  /**
   * `sliding` can take the size of the window as well the size of the step during each iteration:
   */
  def slidingWindowIterables(
      res0: Int,
      res1: Int,
      res2: Int,
      res3: Int,
      res4: Int,
      res5: Int,
      res6: Int,
      res7: Int,
      res8: Int
  ) = {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it   = list sliding (3, 3)
    it.next() should be(List(res0, res1, res2))
    it.next() should be(List(res3, res4, res5))
    it.next() should be(List(res6, res7, res8))
  }

  /**
   * `takeRight` is the opposite of 'take' in `Traversable`. It retrieves the last elements of an `Iterable`:
   */
  def takeRightIterables(res0: Int, res1: Int, res2: Int) = {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list takeRight 3) should be(List(res0, res1, res2))
  }

  /**
   * `dropRight` will drop a specified number of elements from the right:
   */
  def dropRightIterables(res0: Int, res1: Int, res2: Int, res3: Int, res4: Int, res5: Int) = {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list dropRight 3) should be(List(res0, res1, res2, res3, res4, res5))
  }

  /**
   * `zip` will stitch two iterables into an iterable of pairs of corresponding elements from both iterables.
   *
   * e.g. `Iterable(x1, x2, x3) zip Iterable(y1, y2, y3)` will return `((x1, y1), (x2, y2), (x3, y3))`:
   */
  def zipIterables(res0: Int, res1: String, res2: Int, res3: String, res4: Int, res5: String) = {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann", "Stella")
    (xs zip ys) should be(List((res0, res1), (res2, res3), (res4, res5)))
  }

  /**
   * If two Iterables aren't the same size, then `zip` will only zip what can  be paired.
   *
   * e.g. `Iterable(x1, x2, x3) zip Iterable(y1, y2)` will return `((x1, y1), (x2, y2))`:
   */
  def sameSizeZipIterables(res0: Int, res1: String, res2: Int, res3: String) = {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zip ys) should be(List((res0, res1), (res2, res3)))
  }

  /**
   * If two `Iterables` aren't the same size, then `zipAll` can provide fillers for what it couldn't find a complement for.
   *
   * e.g. `Iterable(x1, x2, x3) zipAll (Iterable(y1, y2), x, y)` will return `((x1,y1), (x2, y2), (x3, y)))`:
   */
  def zipAllIterables(
      res0: Int,
      res1: String,
      res2: Int,
      res3: String,
      res4: Int,
      res5: Int,
      res6: String,
      res7: Int,
      res8: String,
      res9: String
  ) = {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zipAll (ys, -1, "?")) should be(List((res0, res1), (res2, res3), (res4, "?")))

    val xt = List(3, 5)
    val yt = List("Bob", "Ann", "Stella")
    (xt zipAll (yt, -1, "?")) should be(List((res5, res6), (res7, res8), (-1, res9)))

  }

  /**
   * `zipWithIndex` will zip an `Iterable` with its integer index:
   */
  def zipWithIndexIterables(res0: String, res1: String, res2: Int, res3: String) = {
    val xs = List("Manny", "Moe", "Jack")
    xs.zipWithIndex should be(List((res0, 0), (res1, res2), (res3, 2)))
  }

  /**
   * `sameElements` will return true if the two `Iterables` produce the same elements in the same order. The iterator for a set created with less than 5 values will return elements in the order in which they were added, rather than the consistent, hash-based ordering used by iterators for larger Sets:
   */
  def sameElementsIterables(res0: Boolean, res1: Boolean, res2: Boolean, res3: Boolean) = {
    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    xs.iterator.sameElements(ys) should be(res0)

    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    xt.iterator.sameElements(yt) should be(res1)

    val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
    val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
    xs1.iterator.sameElements(ys1) should be(res2)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
    xt1.iterator.sameElements(yt1) should be(res3) // Caution - see below!
    /**
     * Note that very small Sets (containing up to 4 elements) are implemented differently to larger Sets; as a result, their iterators produce the elements in the order that they were originally added. This causes the surprising (and arguably incorrect) behaviour in the final example above.
     */
  }

}
