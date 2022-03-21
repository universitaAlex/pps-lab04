package u04

object Unapply extends App:

  class Pair[A,B](val x: A, val y: B)
  class MyPair(override val x: Double, override val y: Double) extends Pair(x,y)

  object Pair:
    def apply[A,B](x: A, y: B) = new Pair(x,y)
    def unapply[A,B](p: Pair[A,B]): Option[(A,B)] = Some((p.x,p.y))

  def match1(p: Pair[Double,Double]): String = p match
    case p: MyPair => "MYPAIR"  // matching by type
    case Pair(0,0) => "Zero"    // matching a case class
    case Pair(_,0) => "X-axys"  // using unbounded parameters
    case Pair(x,y) if x==y => "X=Y"  // conditional case
    case _ => "?"

  // Rough translation into equivalent code
  def match2(p: Pair[Double,Double]): String =
    val unapplyResult = Pair.unapply(p)
    if p.isInstanceOf[MyPair] then "MYPAIR"
    else if unapplyResult == Option((0, 0)) then "Zero"
    else if unapplyResult.collect{case (_,0) => true}.isDefined then "X-axys"
    else if unapplyResult.filter{case (x,y) => x==y}.isDefined then "X=Y"
    else "?"

  println(match1(Pair(0,0))) // Zero
  println(match2(Pair(0,0)))
  println(match1(Pair(10,0))) // X-axys
  println(match2(Pair(10,0)))
  println(match1(Pair(0,2))) // ?
  println(match2(Pair(0,2)))
  println(match1(new MyPair(0,2))) // MyPair
  println(match2(new MyPair(0,2)))
