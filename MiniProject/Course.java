package AP.MiniProject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Course
{
    private final String name;
    private Teacher teacher;
    private String courseId;
    private final int unit;
    private Set<Student> students = new HashSet<Student>();
    private Set<Assignment> assignments = new HashSet<Assignment>();
    private Date examDate;
    private boolean isActive;

    public Course(String name, int unit)
    {
        this.name = name;
        this.unit = unit;
        isActive = false;
    }

    public Course(String name, Teacher teacher, String courseId, int unit, Date examDate)
    {
        this(name, unit);
        this.teacher = teacher;
        this.courseId = courseId;
        this.examDate = examDate;
        isActive = true;
    }

    public String getName()
    {
        return name;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public String getCourseId()
    {
        return courseId;
    }

    public int getUnit()
    {
        return unit;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public Date getExamDate()
    {
        return examDate;
    }

    public int getStudentNumber()
    {
        return students.size();
    }

    public void setExamDate(Date examDate)
    {
        this.examDate = examDate;
    }

    public void activeCourse(Teacher teacher, String courseId, Date examDate)
    {
        if(!isActive)
        {
            isActive = true;
            this.teacher = teacher;
            this.courseId = courseId;
            this.examDate = examDate;
        }
    }

    public void inactiveCourse()
    {
        if(isActive)
        {
            isActive = false;
            teacher = null;
            courseId = null;
            examDate = null;
        }
    }

    public void printStudents()
    {
        students.forEach(s -> System.out.println(s.getName()));
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void deleteStudent(Student student)
    {
        students.remove(student);
    }

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }

    public void deleteAssignment(Assignment assignment)
    {
        assignments.remove(assignment);
    }

    public Double getMaxScore()
    {
        return students.stream().map(s -> s.getScoreOfCourse(this)).max(Double::compareTo).orElse(0.0);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Course))
        {
            return false;
        }
        Course course = (Course)obj;

		return courseId.equals(course.getCourseId());
    }
}