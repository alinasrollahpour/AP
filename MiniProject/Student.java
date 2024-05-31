package AP.MiniProject;

import java.util.HashMap;
import java.util.Map;

public class Student
{
    private final String name;
    private int term;
    private final String studentId;
    private String password;
    private Map<Course, Double> termCourses = new HashMap<Course, Double>();
    private Map<Course, Double> passedCourses = new HashMap<Course, Double>();

    public Student(String name, String studentId, String password)
    {
        this.name = name;
        this.studentId = studentId;
        this.password = password;
        term = 1;
    }

    public Student(String name, String studentId, String password, int term)
    {
        this(name, studentId, password);
        this.term = term;
    }

    String getName()
    {
        return name;
    }

    int getTerm()
    {
        return term;
    }

    Course[] getTermCourses()
    {
        return (Course[])termCourses.keySet().toArray();
    }

    Course[] getPassedCourses()
    {
        return (Course[])passedCourses.keySet().toArray();
    }

    int getTermCoursesNumber()
    {
        return termCourses.size();
    }

    int getPassedCoursesNumber()
    {
        return passedCourses.size();
    }

    String getStudentId()
    {
        return studentId;
    }
    
    String getPassword()
    {
        return password;
    }

    double getTermAverage()
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

    double getTotalAverage()
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

    void setPassword(String password)
    {
        this.password = password;
    }

    int getTermUnitNumber()
    {
        return termCourses.keySet().stream().map(Course::getUnit).reduce(Integer::sum).orElse(0);
    }

    int getPassedUnitNumber()
    {
        return passedCourses.keySet().stream().map(Course::getUnit).reduce(Integer::sum).orElse(0);
    }

    void printTermCourses()
    {
        termCourses.keySet().stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    }

    void printPassedCourses()
    {
        passedCourses.keySet().stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    }

    void addCourse(Course course)
    {
        termCourses.put(course, null);
    }

    void addPassedCourse(Course course, double score)
    {
        passedCourses.put(course, score);
    }

    void deleteTermCourse(Course course)
    {
        termCourses.remove(course);
    }

    void deletePassedCourse(Course course)
    {
        passedCourses.remove(course);
    }

    Double getScoreOfCourse(Course course)
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