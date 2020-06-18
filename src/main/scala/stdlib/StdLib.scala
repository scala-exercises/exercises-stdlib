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

/**
 * Scala fuses object-oriented and functional programming in a statically typed programming language.
 *
 * @param name std_lib
 */
object StdLib extends org.scalaexercises.definitions.Library {
  override def owner      = "scala-exercises"
  override def repository = "exercises-stdlib"

  override def color = Some("#26525B")

  override def sections =
    List(
      Asserts,
      Classes,
      Options,
      Objects,
      Tuples,
      HigherOrderFunctions,
      Lists,
      Maps,
      Sets,
      Formatting,
      PatternMatching,
      CaseClasses,
      Ranges,
      PartiallyAppliedFunctions,
      PartialFunctions,
      Implicits,
      Traits,
      ForExpressions,
      InfixPrefixandPostfixOperators,
      InfixTypes,
      SequencesandArrays,
      Iterables,
      Traversables,
      NamedandDefaultArguments,
      Extractors,
      ByNameParameter,
      RepeatedParameters,
      ParentClasses,
      EmptyValues,
      TypeSignatures,
      UniformAccessPrinciple,
      LiteralBooleans,
      LiteralNumbers,
      LiteralStrings,
      TypeVariance,
      Enumerations
    )
  override def logoPath = "std_lib"
}
