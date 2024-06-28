package MiniProject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable
{
    private final String name;
    private final String teacherId;
    private Set<Course> courses = new HashSet<>();//todo: convert Set<Coures> -> coursesID

    public Teacher(String name, String teacherId, Set<Course> courses)
    {
        this.name = name;
        this.teacherId = teacherId;
        this.courses = courses;
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
        return courses.size();
    }

    public Set<Course> getCourses()
    {
        return courses;
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public void removeCourse(Course course)
    {
        courses.remove(course);
    }


    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Teacher))
        {
            return false;
        }
        Teacher teacher = (Teacher)obj;

		return teacherId.equals(teacher.getTeacherId()) && name.equals(teacher.getName());
    }
}
