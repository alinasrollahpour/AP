package MiniProject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable
{
    private final String name;
    private String teacherId;
    private final String courseId;
    private final int unit;
    private Set<String> studentsId = new HashSet<>();
    private Set<String> assignmentsId = new HashSet<>();
    private String examDate;
    private boolean isActive;

    public Course(String name, String courseId, int unit)
    {
        this.name = name;
        this.courseId = courseId;
        this.unit = unit;
        isActive = false;
    }

    public Course(String name, String teacherId, String courseId, int unit, String examDate)
    {
        this(name, courseId, unit);
        this.teacherId = teacherId;
        this.examDate = examDate;
        isActive = true;
    }

    public String getName()
    {
        return name;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public String getCourseId()
    {
        return courseId;
    }

    public int getUnit()
    {
        return unit;
    }

    public Set<String> getStudentsId()
    {
        return studentsId;
    }

    public Set<String> getAssignmentsId()
    {
        return assignmentsId;
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
        return studentsId.size();
    }

    public void setExamDate(String examDate)
    {
        this.examDate = examDate;
    }

    public void activeCourse(String teacherId, String examDate)
    {
        if(!isActive)
        {
            isActive = true;
            this.teacherId = teacherId;
            this.examDate = examDate;
        }
    }

    public void inactiveCourse()
    {
        if(isActive)
        {
            isActive = false;
            teacherId = null;
            examDate = null;
        }
    }

    public void addStudent(Student student)
    {
        studentsId.add(student.getStudentId());
    }

    public void addStudent(String studentId)
    {
        studentsId.add(studentId);
    }

    public void deleteStudent(Student student)
    {
        studentsId.remove(student.getStudentId());
    }

    public void deleteStudent(String studentId)
    {
        studentsId.remove(studentId);
    }

    public void addAssignment(Assignment assignment)
    {
        assignmentsId.add(assignment.getAssignmentId());
    }

    public void addAssignment(String assignmentId)
    {
        assignmentsId.add(assignmentId);
    }

    public void deleteAssignment(Assignment assignment)
    {
        assignmentsId.remove(assignment.getAssignmentId());
    }

    public void deleteAssignment(String assignmentId)
    {
        assignmentsId.remove(assignmentId);
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

    @Override
    public String toString()
    {
        return "Course{" + "name='" + name + '\'' + ", teacherId='" + teacherId + '\'' + ", courseId='" + courseId
                + '\'' + ", unit=" + unit + ", studentsId=" + studentsId + ", assignmentsId=" + assignmentsId
                + ", examDate='" + examDate + '\'' + ", isActive=" + isActive + '}';
    }
}