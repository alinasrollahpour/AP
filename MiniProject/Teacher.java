package MiniProject;

import java.util.LinkedList;
import java.util.List;

public class Teacher
{
    private String name;
    private String teacherId;
    private String password;
    private List<Course> courses = new LinkedList<Course>();

    public Teacher(String name, String teacherId, String password, List<Course> courses)
    {
        this.name = name;
        this.teacherId = teacherId;
        this.password = password;
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

    String getPassword()
    {
        return password;
    }
    
    int getLessonNumber()
    {
        return courses.size();
    }
    
    List<Course> getCourses()
    {
        return courses;
    }

    void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Teacher))
        {
            return false;
        }
        Teacher teacher = (Teacher)obj;

        if(teacherId.equals(teacher.getTeacherId()) && name.equals(teacher.getName()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}