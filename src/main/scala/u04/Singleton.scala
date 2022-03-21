package u04

object Singleton extends App :

  class C:
    def get: Int = 1

  val c = new C   // default constructors called without parens
  println(c.get)

  object O extends C :  // a singleton, still extending a class
    private var n: Int = 0
    override def get: Int = n
    def inc() = n = n + 1

  println(O.get)        // really use O as it was a val
  O.inc()
  O.inc()
  println(O.get)
  val c2: C = O         // object O is of a subtype of C
  println(c2.get)
