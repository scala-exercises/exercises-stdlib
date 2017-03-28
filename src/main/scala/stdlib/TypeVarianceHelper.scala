/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

object TypeVarianceHelper {

  class Fruit
  abstract class Citrus extends Fruit
  class Orange          extends Citrus
  class Tangelo         extends Citrus
  class Apple           extends Fruit
  class Banana          extends Fruit

}
