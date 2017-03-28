/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

object OptionsHelper {

  def maybeItWillReturnSomething(flag: Boolean): Option[String] =
    if (flag) Some("Found value") else None

}
