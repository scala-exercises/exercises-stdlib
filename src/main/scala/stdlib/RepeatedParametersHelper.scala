/*
 *  scala-exercises - exercises-stdlib
 *  Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package stdlib

object RepeatedParametersHelper {

  def repeatedParameterMethod(x: Int, y: String, z: Any*) =
    "%d %ss can give you %s".format(x, y, z.mkString(", "))
}
