package MiniProject;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student implements Serializable
{
    private final String name;
    private String userName;
    private String birthday;
    private int term;
    private final String studentId;
    private String password;
    private Map<String, Double> termCoursesId = new HashMap<>();
    private Map<String, Double> passedCoursesId = new HashMap<>();

    public Student(String name, String userName, String birthday, String studentId, String password)
    {
        this.name = name;
        this.studentId = studentId;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        term = 1;
    }

    public Student(String name, String userName, String birthday, String studentId, String password, int term)
    {
        this(name, userName, birthday, studentId, password);
        this.term = term;
    }

    public String getName()
    {
        return name;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public int getTerm()
    {
        return term;
    }

    public Map<String, Double> getTermCoursesId()
    {
        return termCoursesId;
    }

    public Map<String, Double> getPassedCoursesId()
    {
        return passedCoursesId;
    }

    public int getTermCoursesNumber()
    {
        return termCoursesId.size();
    }

    public int getPassedCoursesNumber()
    {
        return passedCoursesId.size();
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getPassword()
    {
        return password;
    }

    public double getTermAverage()
    {
        if(termCoursesId.isEmpty())
        {
            return -1;
        }

        Set<Course> courses;

		try
		{
			courses = DataBase.courseLoader();
		}
        catch(IOException | ClassNotFoundException e)
		{
			return -1;
		}

		double sum = 0;
        int num = 0;

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;
            
            if(termCoursesId.containsKey(c.getCourseId()) && termCoursesId.get(c.getCourseId()) != null)
            {
                sum += c.getUnit() * termCoursesId.get(c.getCourseId());
                num++;
            }
        }
        return sum / num;
    }

    public double getTotalAverage()
    {
        if(term == 1)
        {
            return -1;
        }

        Set<Course> courses;

        try
        {
            courses = DataBase.courseLoader();
        }
        catch(IOException | ClassNotFoundException e)
        {
            return -1;
        }

        double sum = 0;

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;

            if(passedCoursesId.containsKey(c.getCourseId()))
                sum += c.getUnit() * passedCoursesId.get(c.getCourseId());
        }
        return sum / passedCoursesId.size();
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getTermUnitNumber()
    {
        Set<Course> courses;

		try
		{
			courses = DataBase.courseLoader();
		}
        catch(IOException | ClassNotFoundException e)
		{
			return 0;
		}

        int num = 0;

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;

            if(termCoursesId.containsKey(c.getCourseId()))
                num += c.getUnit();
        }

		return num;
    }

    public int getPassedUnitNumber()
    {
        Set<Course> courses;

        try
        {
            courses = DataBase.courseLoader();
        }
        catch(IOException | ClassNotFoundException e)
        {
            return 0;
        }

        int num = 0;

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;

            if(passedCoursesId.containsKey(c.getCourseId()))
                num += c.getUnit();
        }

        return num;
    }

    public void printTermCourses()
    {
        Set<Course> courses;

        try
        {
            courses = DataBase.courseLoader();
        }
        catch(IOException | ClassNotFoundException e)
        {
            return;
        }

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;

            if(termCoursesId.containsKey(c.getCourseId()))
                System.out.println(c.getName());
        }
    }

    public void printPassedCourses()
    {
        Set<Course> courses;

        try
        {
            courses = DataBase.courseLoader();
        }
        catch(IOException | ClassNotFoundException e)
        {
            return;
        }

        for(Object obj: courses.toArray())
        {
            Course c = (Course)obj;

            if(passedCoursesId.containsKey(c.getCourseId()))
                System.out.println(c.getName());
        }
    }

    public void addCourse(Course course)
    {
        termCoursesId.put(course.getCourseId(), null);
    }

    public void addCourse(String courseId)
    {
        termCoursesId.put(courseId, null);
    }

    public void addPassedCourse(Course course, double score)
    {
        passedCoursesId.put(course.getCourseId(), score);
    }

    public void addPassedCourse(String courseId, double score)
    {
        passedCoursesId.put(courseId, score);
    }

    public void deleteTermCourse(Course course)
    {
        termCoursesId.remove(course.getCourseId());
    }

    public void deleteTermCourse(String courseId)
    {
        termCoursesId.remove(courseId);
    }

    public void deletePassedCourse(Course course)
    {
        passedCoursesId.remove(course.getCourseId());
    }

    public void deletePassedCourse(String courseId)
    {
        passedCoursesId.remove(courseId);
    }

    public Double getScoreOfCourse(Course course)
    {
        if(passedCoursesId.containsKey(course.getCourseId()))
        {
            return passedCoursesId.get(course.getCourseId());
        }
        else if(termCoursesId.containsKey(course.getCourseId()))
        {
            return termCoursesId.get(course.getCourseId());
        }
        return null;
    }

    public Double getScoreOfCourse(String courseId)
    {
        if(passedCoursesId.containsKey(courseId))
        {
            return passedCoursesId.get(courseId);
        }
        else if(termCoursesId.containsKey(courseId))
        {
            return termCoursesId.get(courseId);
        }
        return null;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Student))
        {
            return false;
        }
        Student student = (Student)obj;

		return studentId.equals(student.getStudentId());
    }

    @Override
    public String toString()
    {
        return "Student{" + "name='" + name + '\'' + ", userName='" + userName + '\'' + ", birthday='" + birthday + '\''
                + ", term=" + term + ", studentId='" + studentId + '\'' + ", password='" + password + '\''
                + ", termCoursesId=" + termCoursesId + ", passedCoursesId=" + passedCoursesId + '}';
    }
}