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

/** @param name partial_functions
 *
 */
object PartialFunctions
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /** A partial function is a `trait` that when implemented can be used as building blocks to determine a solution.  The trait `PartialFunction` requires that the method `isDefinedAt` and `apply` be implemented:
   */
  def partialFunctionPartialFunctions(res0: Int, res1: Int) = {
    val doubleEvens: PartialFunction[Int, Int] =
      new PartialFunction[Int, Int] {
        //States that this partial function will take on the task
        def isDefinedAt(x: Int) = x % 2 == 0

        //What we do if this partial function matches
        def apply(v1: Int) = v1 * 2
      }

    val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
      def isDefinedAt(x: Int) = x % 2 != 0

      def apply(v1: Int) = v1 * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together

    whatToDo(3) should be(res0)
    whatToDo(4) should be(res1)
  }

  /** Case statements are a quick way to create partial functions. When you create a case statement, the `apply` and `isDefinedAt` methods are created automatically.
   */
  def caseStatementsPartialFunctions(res0: Int, res1: Int) = {
    //These case statements are called case statements with guards
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 => x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 => x * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together
    whatToDo(3) should be(res0)
    whatToDo(4) should be(res1)
  }

  /** The result of partial functions can have an `andThen` function added to the end of the chain:
   */
  def andThenPartialFunctions(res0: Int, res1: Int) = {
    //These are called case statements with guards
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 => x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 => x * 3
    }

    val addFive = (x: Int) => x + 5
    val whatToDo =
      doubleEvens orElse tripleOdds andThen addFive //Here we chain the partial functions together
    whatToDo(3) should be(res0)
    whatToDo(4) should be(res1)
  }

  /** `andThen` can be used to continue onto another chain of logic:
   */
  def chainOfLogicPartialFunctions(res0: String, res1: String) = {
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 => x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 => x * 3
    }

    val printEven: PartialFunction[Int, String] = {
      case x if (x % 2) == 0 => "Even"
    }
    val printOdd: PartialFunction[Int, String] = {
      case x if (x % 2) != 0 => "Odd"
    }

    val whatToDo = doubleEvens orElse tripleOdds andThen (printEven orElse printOdd)

    whatToDo(3) should be(res0)
    whatToDo(4) should be(res1)
  }

}
