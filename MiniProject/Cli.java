package MiniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println(ANSI_GREEN + "Welcome!\n" + ANSI_RESET);
		System.out.println("What is your role?");
		System.out.println("\t\t1.Admin");
		System.out.println("\t\t2.Teacher");
		System.out.print(ANSI_BLUE + "Please Enter 1 or 2: " + ANSI_RESET);

		String oneOrTwo = input.next();

		while(!oneOrTwo.equals("1") && !oneOrTwo.equals("2"))
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("What is your role?");
			System.out.println("\t\t1.Admin");
			System.out.println("\t\t2.Teacher");
			System.out.print(ANSI_RED + "Inputted character is incorrect!" + ANSI_BLUE + " Please Enter 1 or 2: " + ANSI_RESET);
			oneOrTwo = input.next();
		}

		// Admin
		if(oneOrTwo.equals("1"))
		{
			System.out.println(ANSI_GREEN + "\nWelcome Admin!\n" + ANSI_RESET);


		}
		// Teacher
		else
		{
			System.out.print("Please Enter your teacher ID: ");
			String teacherId = input.next();
			String teacherName = null;

			try(RandomAccessFile reader = new RandomAccessFile(new File("E:\\MyWorkspace\\AP_Project\\AP\\MiniProject\\Files\\teachers.txt"), "r"))
			{
				boolean isCorrect = false;

				while(!isCorrect)
				{
					String line;
					String[] info;

					while((line = reader.readLine()) != null)
					{
						info = line.split("~");

						if(teacherId.equals(info[0]))
						{
							teacherName = info[1];
							isCorrect = true;
							break;
						}
					}

					if(!isCorrect)
					{
						System.out.print(ANSI_RED + "The ID is incorrect! " + ANSI_RESET + "Please Enter your teacher ID: ");
						teacherId = input.next();
						reader.seek(0);
					}
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
				return;
			}

			System.out.println(ANSI_GREEN + "\nWelcome " + teacherName + "!\n" + ANSI_RESET);
		}


		input.close();
	}
}