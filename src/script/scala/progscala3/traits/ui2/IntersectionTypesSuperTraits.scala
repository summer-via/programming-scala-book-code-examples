// src/script/scala/progscala3/traits/ui2/IntersectionTypesSuperTraits.scala

trait Base1
trait Base2
class Class extends Base1 with Base2

super trait SBase1
super trait SBase2
class SClass extends SBase1 with SBase2

val c = new Class
val sc = new SClass

sealed trait Base
case object Obj1 extends Base
case object Obj2 extends Base

def m(whichOne: Boolean) = if whichOne then Obj1 else Obj2

val v1 = m(true)
val v2 = m(false)

import progscala3.traits.ui2._
import progscala3.traits.observer._

super trait S
val button1 = new Button("Button!")
    with ObservableClicks with VetoableClicks(maxAllowed = 2):
  def updateUI(): String = s"$label clicked"

val button2 = new Button("Button!")
    with ObservableClicks with VetoableClicks(maxAllowed = 2) with S:
  def updateUI(): String = s"$label clicked"

import progscala3.traits.ui.Widget


class Text(val label: String, value: String) extends Widget

trait Flag
val t1 = new Text("foo", "bar") with Flag

super trait SFlag
val t2 = new Text("foo", "bar") with SFlag
