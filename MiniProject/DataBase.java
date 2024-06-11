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