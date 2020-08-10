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
 * @param name uniform_access_principle
 */
object UniformAccessPrinciple
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * The Scala language implements a programming concept known as the [[http://en.wikipedia.org/wiki/Uniform_access_principle Uniform Access Principle]], which was first put forth by Bertrand Meyer, the inventor of the Eiffel programming language.
   *
   * This principle states that variables and parameterless functions should be accessed using the same syntax. Scala supports this principle by allowing parentheses to not be placed at call sites of parameterless functions. As a result, a parameterless function definition can be changed to a `val`, or vice versa, without affecting client code:
   */
  def uniformAccessPrincipleUniformAccessPrinciple(res0: Int, res1: Int) = {
    class Test1(val age: Int = 10)
    class Test2(_age: Int) {
      def age: Int = _age
    }

    new Test1(10).age should be(res0)
    new Test2(11).age should be(res1)
  }

}
