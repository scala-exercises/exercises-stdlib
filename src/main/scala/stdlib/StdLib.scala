/*
 * scala-exercises-content
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

/** Scala fuses object-oriented and functional programming in a statically typed programming language.
  *
  * @param name std_lib
  */
object StdLib extends org.scalaexercises.definitions.Library {
  override def owner = "scala-exercises"
  override def repository = "exercises-stdlib"

  override def color = Some("#26525B")

  override def sections = List(
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
}
