package MiniProject;

import java.io.File;
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
		System.out.println("\t\t2.c");
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
			System.out.println(ANSI_GREEN + "Welcome Admin!\n" + ANSI_RESET);

		}
		// Teacher
		else
		{
			System.out.print("Please Enter your teacher ID: ");
			String teacherId = input.next();

//			File teacherFile = new File(".\\Files\\TeacherFile.txt");
//			try(Scanner scanner = new Scanner(teacherFile))
//			{
//
//			}
		}


		input.close();
	}
}