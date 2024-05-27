package MiniProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Course
{
    private String name;
    private Teacher teacher;
    private String courseId;
    private int unit;
    private Set<Student> students = new HashSet<Student>();
    private List<Assignment> assignments = new LinkedList<Assignment>();
    private String examDate;
    private boolean isActive;

    public Course(String name, int unit)
    {
        this.name = name;
        this.unit = unit;
        isActive = false;
    }

    public Course(String name, Teacher teacher, String courseId, int unit, String examDate)
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

    public String getExamDate()
    {
        return examDate;
    }

    public int getStudentNumber()
    {
        return students.size();
    }

    public void setExamDate(String examDate)
    {
        this.examDate = examDate;
    }

    public void activeCourse(Teacher teacher, String courseId, String examDate)
    {
        if(!isActive)
        {
            isActive = true;
            this.teacher = teacher;
            this.courseId = courseId;
            this.examDate = examDate;
        }
    }

    public void printStudents()
    {
        students.stream().forEach(s -> System.out.println(s.getName()));
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
        return students.stream().map(s -> s.getScoreOfCourse(this)).max((x, y) -> x.compareTo(y)).orElse(0.0);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Course))
        {
            return false;
        }
        Course course = (Course)obj;

        if(courseId.equals(course.getCourseId()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}