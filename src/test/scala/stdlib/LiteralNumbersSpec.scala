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

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapeless.HNil

class LiteralNumbersSpec extends RefSpec with Checkers {
  def `integer literals` = {
    check(
      Test.testSuccess(
        LiteralNumbers.integerLiteralsLiteralNumbers _,
        2 :: 31 :: 783 :: 0 :: -2 :: -31 :: -783 :: HNil
      )
    )
  }

  def `long literals` = {
    check(
      Test.testSuccess(
        LiteralNumbers.longLiteralsLiteralNumbers _,
        2L :: 31L :: 783L :: 0L :: -2L :: -31L :: -783L :: HNil
      )
    )
  }

  def `float literals` = {
    check(
      Test.testSuccess(
        LiteralNumbers.floatsAndDoublesLiteralNumbers _,
        3d :: 3d :: 2.73d :: 3d :: 3.22d :: 93e-9 :: 93e-9 :: 0d :: 9.23e-9 :: HNil
      )
    )
  }
}
