package MiniProject;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DataBase
{
	public static void addStudent(Student student) throws IOException, ClassNotFoundException
	{
		Set<Student> students = new HashSet<>();
		try
		{
			students = studentLoader();
		}
		catch(EOFException _)
		{}
		finally
		{
			for(Student s: students)
			{
				if(s.equals(student))
					return;
			}

			students.add(student);
		}

		FileOutputStream fos = new FileOutputStream("Files/students.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(students);

		oos.close();
		fos.close();
	}

	public static void addCourse(Course course) throws IOException, ClassNotFoundException
	{
		Set<Course> courses = new HashSet<>();
		try
		{
			courses = courseLoader();
		}
		catch(EOFException _)
		{}
		finally
		{
			for(Course c: courses)
			{
				if(c.equals(course))
					return;
			}

			courses.add(course);
		}
		FileOutputStream fos = new FileOutputStream("Files/courses.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(courses);

		oos.close();
		fos.close();
	}

	private static Set<Course> courseLoader() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("Files/courses.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Course> courses = (Set<Course>)ois.readObject();

		ois.close();
		fis.close();

		return courses;
	}

	public static Set<Student> studentLoader() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("Files/students.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Student> students = (Set<Student>)ois.readObject();

		ois.close();
		fis.close();

		return students;
	}
}