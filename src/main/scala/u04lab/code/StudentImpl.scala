package u04lab.code

case class CourseImpl(name: String, teacher: String) extends Course

import List.*

case class StudentImpl(override val name:String, override val year: Int) extends Student:

  private var c:List[Course]=Nil()
  
  override def enrolling(course: Course): Unit =
    c=List.append(Cons(course,Nil()),c)
    
  override def courses: List[String]=
    List.map(c)(course=>course.name)
    
  override def hasTeacher(teacher: String):Boolean=
    !Option.isEmpty(List.find(c)(course=>course.teacher==teacher))


