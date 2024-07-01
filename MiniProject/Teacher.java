package MiniProject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable
{
    private final String name;
    private final String teacherId;
    private Set<String> coursesId = new HashSet<>();

    public Teacher(String name, String teacherId, Set<String> coursesId)
    {
        this.name = name;
        this.teacherId = teacherId;
        this.coursesId = coursesId;
    }

    public String getName()
    {
        return name;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public int getCoursesNumber()
    {
        return coursesId.size();
    }

    public Set<String> getCoursesId()
    {
        return coursesId;
    }

    public void addCourse(Course course)
    {
        coursesId.add(course.getCourseId());
    }

    public void addCourse(String courseId)
    {
        coursesId.add(courseId);
    }

    public void removeCourse(Course course)
    {
        coursesId.remove(course.getCourseId());
    }

    public void removeCourse(String courseId)
    {
        coursesId.remove(courseId);
    }


    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Teacher))
        {
            return false;
        }
        Teacher teacher = (Teacher)obj;

		return teacherId.equals(teacher.getTeacherId());
    }

    @Override
    public String toString()
    {
        return "Teacher{" + "name='" + name + '\'' + ", teacherId='" + teacherId + '\'' + ", coursesId=" + coursesId
                + '}';
    }
}