package MiniProject;
import java.util.*;

public abstract class DB {

    //address for locating database directory
    private String address;

    private List<Teacher> teachers = new LinkedList<>();
    private List<Course> courses = new LinkedList<>();
    private List<Student> students = new LinkedList<>();
    private List<Assignment> assignments = new LinkedList<>();


    public DB (String address) {
        this.address = address;
        //TODO: load content of files into objects
    }

    public void update(){}

}
/*
import java.util.*;

    class University {
        private List<Teacher> teachers;
        private List<Course> courses;
        private List<Student> students;

        public void addTeacher(Teacher t){}
        public void addCourse(Course c){}
        public void addStudent(Student s){}

        public void removeTeacher(Teacher t) throws Exception{}
        public void removeCourse(Course c) throws Exception{}
        public void removeStudent(Student s) throws Exception{}

        public boolean containsTeacher(Teacher t){}
        public boolean containsCourse(Course c){}
        public boolean containsStudent(Student s){}

    }
}

 */
