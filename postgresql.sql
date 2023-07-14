select firstname,lastname,course.*
from student
inner join course on student.student_id=course.student_id