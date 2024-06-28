package MiniProject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Student implements Serializable
{
    private final String name;
    private String userName;
    private String birthday;
    private int term;
    private final String studentId;
    private String password;
    private Map<Course, Double> termCourses = new HashMap<>();//todo: convert Set<Coures> -> coursesID
    private Map<Course, Double> passedCourses = new HashMap<>();//todo: convert Set<Coures> -> coursesID

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

    public Course[] getTermCourses()
    {
        return (Course[])termCourses.keySet().toArray();
    }

    public Course[] getPassedCourses()
    {
        return (Course[])passedCourses.keySet().toArray();
    }

    public int getTermCoursesNumber()
    {
        return termCourses.size();
    }

    public int getPassedCoursesNumber()
    {
        return passedCourses.size();
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
        if(termCourses.isEmpty())
        {
            return -1;
        }

        double sum = 0;
        int num = 0;

        for(Object obj: termCourses.keySet().toArray())
        {
            Course c = (Course)obj;
            
            if(termCourses.get(c) != null)
            {
                sum += c.getUnit() * termCourses.get(c);
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

        double sum = 0;

        for(Object obj: passedCourses.keySet().toArray())
        {
            Course c = (Course)obj;
            
            sum += c.getUnit() * passedCourses.get(c);
        }

        return sum / passedCourses.size();
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
        return termCourses.keySet().stream().map(Course::getUnit).reduce(Integer::sum).orElse(0);
    }

    public int getPassedUnitNumber()
    {
        return passedCourses.keySet().stream().map(Course::getUnit).reduce(Integer::sum).orElse(0);
    }

    public void printTermCourses()
    {
        termCourses.keySet().stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    }

    public void printPassedCourses()
    {
        passedCourses.keySet().stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    }

    public void addCourse(Course course)
    {
        termCourses.put(course, null);
    }

    public void addPassedCourse(Course course, double score)
    {
        passedCourses.put(course, score);
    }

    public void deleteTermCourse(Course course)
    {
        termCourses.remove(course);
    }

    public void deletePassedCourse(Course course)
    {
        passedCourses.remove(course);
    }

    public Double getScoreOfCourse(Course course)
    {
        if(passedCourses.containsKey(course))
        {
            return passedCourses.get(course);
        }
        else if(termCourses.containsKey(course))
        {
            return termCourses.get(course);
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

		return studentId.equals(student.getStudentId()) && name.equals(student.getName());
    }
}
