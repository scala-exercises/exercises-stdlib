/*
 * scala-exercises - exercises-stdlib
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package stdlib

import org.scalatest._

/** @param name traits
 */
object Traits extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** Similar to interfaces in Java, traits are used to define object types by specifying the signature of the supported methods. Similar to Java default methods in interfaces, Scala allows traits to be partially implemented. In contrast to classes, traits may not have constructor parameters.
   *
   * Here is an example:
   *
   * {{{
   * trait Similarity {
   * def isSimilar(x: Any): Boolean
   * def isNotSimilar(x: Any): Boolean = !isSimilar(x)
   * }
   * }}}
   *
   * This trait consists of two methods `isSimilar` and `isNotSimilar`. While `isSimilar` does not provide a concrete method implementation (it is abstract in the terminology of Java), method `isNotSimilar` defines a concrete implementation. Consequently, classes that integrate this trait only have to provide a concrete implementation for `isSimilar`. The behavior for `isNotSimilar` gets inherited directly from the trait.
   *
   * A class uses the `extends` keyword to mixin a trait if it is the only relationship the class inherits:
   */
  def similarToInterfacesTraits(res0: String) {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") ⇒
            "An unfortunate moose stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val evt        = Event("Moose Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be(res0)
  }

  /** A class can only extend from one class or trait, any subsequent extension should use the keyword `with`:
   */
  def extendsFromOneTraits(res0: String) {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class OurListener

    class MyListener extends OurListener with EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Woodchuck Stampede") ⇒
            "An unfortunate woodchuck stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val evt        = Event("Woodchuck Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be(res0)
  }

  /** Traits are polymorphic. Any type can be referred to by another type if related by extension:
   */
  def polymorphicTraits(res0: Boolean, res1: Boolean, res2: Boolean, res3: Boolean) {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") ⇒
            "An unfortunate moose stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val myListener = new MyListener

    myListener.isInstanceOf[MyListener] should be(res0)
    myListener.isInstanceOf[EventListener] should be(res1)
    myListener.isInstanceOf[Any] should be(res2)
    myListener.isInstanceOf[AnyRef] should be(res3)
  }
  
  /** Traits also can use self-types.  A self-type lists the required dependencies for mixing in the trait.  When mixing in the main trait, all self-type dependencies of that trait must also be mixed in, otherwise a compile-time error is thrown.
   *  
   * Also, the dependencies can't have identical method/property names, as well as all default methods should be implemented on instantiation or else you'll get an `illegal inheritance` error
   */
  def selfTypeTraits(res0: String, res1: String, res2: String, res3: String) {
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    trait MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") ⇒
            "An unfortunate moose stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    trait CrucialEventListener { self: MyListener =>
      def listenCrucial(event: Event): String = {
        if (event.name contains "Wildebeest") "The king is dead, long live the king!"
        else self listen event
      }
    }


    //val crucialEvent = new CrucialEventListener //***does not compile!!!***
    //val crucialEvent = new CrucialEventListener with EventListener //***does not compile!!!***
    val listener = new CrucialEventListener with MyListener
    val event = Event("Moose Stampede")
    val crucialEvent = Event("Wildebeest Stampede")
    
    listener.listen(event) should be(res0)
    listener.listen(crucialEvent) should be(res1)

    listener.listenCrucial(event) should be(res2)
    listener.listenCrucial(crucialEvent) should be(res3)
  }
}
