package AP.MiniProject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Teacher
{
    private final String name;
    private final String teacherId;
    private Set<Course> courses = new HashSet<Course>();

    public Teacher(String name, String teacherId, Set<Course> courses)
    {
        this.name = name;
        this.teacherId = teacherId;
        this.courses = courses;
    }

    String getName()
    {
        return name;
    }

    String getTeacherId()
    {
        return teacherId;
    }

    int getLessonNumber()
    {
        return courses.size();
    }
    
    Set<Course> getCourses()
    {
        return courses;
    }

    void addCourse(Course course)
    {
        courses.add(course);
    }

    void deleteCourse(Course course)
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