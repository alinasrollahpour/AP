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
		catch(EOFException ignored)
		{}
		finally
		{
			students.removeIf(s -> s.equals(student));
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
		catch(EOFException ignored)
		{}
		finally
		{
			courses.removeIf(c -> c.equals(course));
			courses.add(course);
		}
		FileOutputStream fos = new FileOutputStream("Files/courses.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(courses);

		oos.close();
		fos.close();
	}

	public static void addTeacher(Teacher teacher) throws IOException, ClassNotFoundException
	{
		Set<Teacher> teachers = new HashSet<>();
		try
		{
			teachers = teacherLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			teachers.removeIf(t -> t.equals(teacher));
			teachers.add(teacher);
		}
		FileOutputStream fos = new FileOutputStream("Files/teachers.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(teachers);

		oos.close();
		fos.close();
	}

	public static void addAssignment(Assignment assignment) throws IOException, ClassNotFoundException
	{
		Set<Assignment> assignments = new HashSet<>();
		try
		{
			assignments = assignmentLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			assignments.removeIf(a -> a.equals(assignment));
			assignments.add(assignment);
		}
		FileOutputStream fos = new FileOutputStream("Files/assignments.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(assignments);

		oos.close();
		fos.close();
	}

	public static void removeStudent(Student student) throws IOException, ClassNotFoundException
	{
		Set<Student> students = new HashSet<>();
		try
		{
			students = studentLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			students.removeIf(s -> s.equals(student));
		}

		FileOutputStream fos = new FileOutputStream("Files/students.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(students);

		oos.close();
		fos.close();
	}

	public static void removeCourse(Course course) throws IOException, ClassNotFoundException
	{
		Set<Course> courses = new HashSet<>();
		try
		{
			courses = courseLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			courses.removeIf(c -> c.equals(course));
		}
		FileOutputStream fos = new FileOutputStream("Files/courses.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(courses);

		oos.close();
		fos.close();
	}

	public static void removeTeacher(Teacher teacher) throws IOException, ClassNotFoundException
	{
		Set<Teacher> teachers = new HashSet<>();
		try
		{
			teachers = teacherLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			teachers.removeIf(t -> t.equals(teacher));
		}
		FileOutputStream fos = new FileOutputStream("Files/teachers.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(teachers);

		oos.close();
		fos.close();
	}

	public static void removeAssignment(Assignment assignment) throws IOException, ClassNotFoundException
	{
		Set<Assignment> assignments = new HashSet<>();
		try
		{
			assignments = assignmentLoader();
		}
		catch(EOFException ignored)
		{}
		finally
		{
			assignments.removeIf(a -> a.equals(assignment));
		}
		FileOutputStream fos = new FileOutputStream("Files/assignments.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(assignments);

		oos.close();
		fos.close();
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

	public static Set<Course> courseLoader() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("Files/courses.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Course> courses = (Set<Course>)ois.readObject();

		ois.close();
		fis.close();

		return courses;
	}

	public static Set<Teacher> teacherLoader() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("Files/teachers.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Teacher> teachers = (Set<Teacher>)ois.readObject();

		ois.close();
		fis.close();

		return teachers;
	}

	public static Set<Assignment> assignmentLoader() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("Files/assignments.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Assignment> assignments = (Set<Assignment>)ois.readObject();

		ois.close();
		fis.close();

		return assignments;
	}
}
