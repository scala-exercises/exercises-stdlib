/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
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

/** @param name literal_booleans
 *
 */
object LiteralBooleans
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** Boolean literals are either true or false, using the `true` or `false` keyword:
   */
  def literalBooleanLiteralBooleans(
      res0: Boolean,
      res1: Boolean,
      res2: Boolean,
      res3: Boolean,
      res4: Boolean,
      res5: Boolean
  ) = {
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(res0)
    b should be(res1)
    c should be(res2)
    d should be(res3)
    e should be(res4)
    f should be(res5)
  }

}
