package u04

// use significant indentation!
object IdiomaticLamp:  // not required, but often wrap into an object module

  class Lamp(private var _state: Boolean):  // method-like notation
    def isOn: Boolean = _state // almost never use curly brackets
    def on() = _state = true   // Unit return type as sort of default
    def off() = _state = false
    override def toString = s"Lamp $_state identity ${super.toString}"

  @main def useLamp() =   // entry-point main by annotation
    val v = new Lamp2(false)
    println(v)
    println(v.isOn)
    v.on()
    println(v.isOn)

  @main def usePoint() =   // entry-point main by annotation
    // the degenerate case of a one-line class
    class Point(val x: Int, val y:Int)
    val p = new Point(10,20)
    println(s"$p.x, $p.y")
