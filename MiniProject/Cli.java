package MiniProject;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

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

		System.out.println(ANSI_GREEN + "\nWelcome!\n" + ANSI_RESET);
		System.out.println("What is your role?");
		System.out.println("\t\t1. Admin");
		System.out.println("\t\t2. Teacher");
		System.out.print(ANSI_BLUE + "Please Enter 1 or 2: " + ANSI_RESET);

		String oneOrTwo = input.next();

		while(!oneOrTwo.equals("1") && !oneOrTwo.equals("2"))
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("What is your role?");
			System.out.println("\t\t1. Admin");
			System.out.println("\t\t2. Teacher");
			System.out.print(ANSI_RED + "Inputted character is incorrect!" + ANSI_BLUE + " Please Enter 1 or 2: " + ANSI_RESET);
			oneOrTwo = input.next();
		}

		// Admin
		if(oneOrTwo.equals("1"))
		{
			System.out.println(ANSI_GREEN + "\nWelcome Admin!\n" + ANSI_RESET);

			boolean flag = true;

			input.nextLine();
			while(flag)
			{
				System.out.println(ANSI_BLUE + "Menu:");
				System.out.println("\t1. Adding/editing teacher");
				System.out.println("\t2. Print list of teachers");
				System.out.println("\t3. Deleting teacher");
				System.out.println("\t4. Adding/editing course");
				System.out.println("\t5. Print list of courses");
				System.out.println("\t6. Deleting course");
				System.out.println("\t7. Adding/editing assignment");
				System.out.println("\t8. Print list of assignments");
				System.out.println("\t9. Deleting assignment");
				System.out.println("\t10. Adding student to course");
				System.out.println("\t11. Deleting student from course");
				System.out.println("\t12. Adding a passed course for a student");
				System.out.println("\t13. Deleting a passed course for a student");
				System.out.println("\t14. Print list of students");
				System.out.println("\t15. Active a course");
				System.out.println("\t16. Inactive a course");
				System.out.println("\t17. Set deadline of an assignment");
				System.out.println("\t18. Inactive an assignment");
				System.out.println("\t19. Enter/edit a score for a student's course");
				System.out.println("\t0. Exit\n" + ANSI_RESET);

				System.out.print("Please enter a number between 0 and 19: ");

				switch(input.nextLine())
				{
					case "1":
					{
						System.out.print("Teacher ID: ");
						String teacherId = input.nextLine();

						try
						{
							if(DataBase.teacherLoader().stream().map(Teacher::getTeacherId).anyMatch(x -> x.equals(teacherId)))
							{
								System.out.println(ANSI_BLUE + "Teacher with this ID is exist." + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_BLUE + "Teacher with this ID isn't exist." + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(
									ANSI_RED + "\nError: Adding/editing teacher isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Name: ");
						String name = input.nextLine();

						System.out.print("Number of teacher's courses: ");

						int n;
						try
						{
							n = input.nextInt();
							input.nextLine();
						}
						catch(InputMismatchException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding/editing teacher isn't successful.\n" + ANSI_RESET);
							input.nextLine();
							break;
						}

						Set<String> coursesId = new HashSet<>();
						for(int i = 0; i < n; i++)
						{
							System.out.print("Course's ID " + (i + 1) + " : ");
							coursesId.add(input.nextLine());
						}

						try
						{
							DataBase.addTeacher(new Teacher(name, teacherId, coursesId));
							System.out.println(ANSI_GREEN + "\nAdding/editing teacher is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(
									ANSI_RED + "\nError: Adding/editing teacher isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "2":
					{
						try
						{
							System.out.println();
							DataBase.teacherLoader().stream().sorted((x, y) -> x.getTeacherId().compareTo(y.getTeacherId())).forEach(System.out::println);
							System.out.println();
						}
						catch(EOFException	e)
						{
							System.out.println("\n");
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "Error: Printing list of teachers failed.\n" + ANSI_RESET);
						}

						break;
					}
					case "3":
					{
						System.out.print("Teacher ID: ");
						String teacherId = input.nextLine();

						try
						{
							if(DataBase.teacherLoader().stream().map(Teacher::getTeacherId).anyMatch(x -> x.equals(teacherId)))
							{
								Teacher teacher = (Teacher)DataBase.teacherLoader().stream().filter(x -> x.getTeacherId().equals(teacherId)).toArray()[0];
								DataBase.removeTeacher(teacher);

								Set<Course> courses = DataBase.courseLoader();
								for(String courseId: teacher.getCoursesId())
								{
									for(Course course: courses)
									{
										if(course.getCourseId().equals(courseId))
										{
											course.inactiveCourse();
											DataBase.addCourse(course);
											break;
										}
									}
								}
								System.out.println(ANSI_GREEN + "\nDeleting teacher is successful.\n" + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_RED + "\nTeacher with this ID isn't exist.\n" + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting teacher isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "4":
					{
						System.out.print("Course ID: ");
						String courseId = input.nextLine();

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								System.out.println(ANSI_BLUE + "Course with this ID is exist." + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_BLUE + "Course with this ID isn't exist." + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding/editing course isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Name: ");
						String name = input.nextLine();

						System.out.print("Unit: ");
						int unit = input.nextInt();
						input.nextLine();

						System.out.print(ANSI_BLUE + "Is the course active?(y/n) " + ANSI_RESET);

						while(true)
						{
							try
							{
								String answer = input.nextLine();
								if(answer.equals("y"))
								{
									System.out.print("Teacher ID: ");
									String teacherId = input.nextLine();

									System.out.print("Exam date: ");
									String examDate = input.nextLine();

									DataBase.addCourse(new Course(name, teacherId, courseId, unit, examDate));

									System.out.println(ANSI_GREEN + "\nAdding/editing course is successful.\n" + ANSI_RESET);

									break;
								}
								else if(answer.equals("n"))
								{
									DataBase.addCourse(new Course(name, courseId, unit));

									System.out.println(ANSI_GREEN + "\nAdding/editing course is successful.\n" + ANSI_RESET);

									break;
								}

								System.out.print(ANSI_BLUE + "Is the course active?(y/n) " + ANSI_RESET);
							}
							catch(IOException | ClassNotFoundException e)
							{
								System.out.println(ANSI_RED + "\nError: Adding/editing course isn't successful.\n" + ANSI_RESET);
							}
						}

						break;
					}
					case "5":
					{
						try
						{
							System.out.println();
							DataBase.courseLoader().stream().sorted((x, y) -> x.getCourseId().compareTo(y.getCourseId())).forEach(System.out::println);
							System.out.println();
						}
						catch(EOFException	e)
						{
							System.out.println("\n");
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "Error: Printing list of courses failed.\n" + ANSI_RESET);
						}

						break;
					}
					case "6":
					{
						System.out.print("Course ID: ");
						String id = input.nextLine();

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(id)))
							{
								Course course = (Course)DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(id)).toArray()[0];
								DataBase.removeCourse(course);

								Teacher teacher = (Teacher)DataBase.teacherLoader().stream().filter(x -> x.getTeacherId().equals(course.getCourseId())).toArray()[0];
								teacher.removeCourse(course);
								DataBase.addTeacher(teacher);

								System.out.println(ANSI_GREEN + "\nDeleting course is successful.\n" + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "7":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						try
						{
							if(DataBase.assignmentLoader().stream().map(Assignment::getAssignmentId).anyMatch(x -> x.equals(assignmentId)))
							{
								System.out.println(ANSI_BLUE + "Assignment with this ID is exist." + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_BLUE + "Assignment with this ID isn't exist." + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding/editing assignment isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Detail: ");
						String detail = input.nextLine();

						System.out.print("Course ID: ");
						String courseId = input.nextLine();

						System.out.print(ANSI_BLUE + "Is the assignment active?(y/n) " + ANSI_RESET);

						while(true)
						{
							try
							{
								String answer = input.nextLine();
								if(answer.equals("y"))
								{
									System.out.print("Deadline: ");
									String deadline = input.nextLine();

									DataBase.addAssignment(new Assignment(assignmentId, detail, courseId, deadline));

									System.out.println(ANSI_GREEN + "\nAdding/editing assignment is successful.\n" + ANSI_RESET);

									break;
								}
								else if(answer.equals("n"))
								{
									DataBase.addAssignment(new Assignment(assignmentId, detail, courseId));

									System.out.println(ANSI_GREEN + "\nAdding/editing assignment is successful.\n" + ANSI_RESET);

									break;
								}

								System.out.print(ANSI_BLUE + "Is the assignment active?(y/n) " + ANSI_RESET);
							}
							catch(IOException | ClassNotFoundException e)
							{
								System.out.println(ANSI_RED + "\nError: Adding/editing assignment isn't successful.\n" + ANSI_RESET);
							}
						}

						break;
					}
					case "8":
					{
						try
						{
							System.out.println();
							DataBase.assignmentLoader().stream().sorted((x, y) -> x.getAssignmentId().compareTo(y.getAssignmentId())).forEach(System.out::println);
							System.out.println();
						}
						catch(EOFException	e)
						{
							System.out.println("\n");
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "Error: Printing list of assignments failed.\n" + ANSI_RESET);
						}

						break;
					}
					case "9":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						try
						{
							if(DataBase.assignmentLoader().stream().map(Assignment::getAssignmentId).anyMatch(x -> x.equals(assignmentId)))
							{
								DataBase.removeAssignment((Assignment) DataBase.assignmentLoader().stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0]);
								System.out.println(ANSI_GREEN + "\nDeleting assignment is successful.\n" + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_RED + "\nAssignment with this ID isn't exist.\n" + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting assignment isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "10":
					{
						System.out.print("Student ID: ");
						String studentId = input.nextLine();
						Student student;

						try
						{
							if(DataBase.studentLoader().stream().map(Student::getStudentId).anyMatch(x -> x.equals(studentId)))
							{
								student = (Student) DataBase.studentLoader().stream().filter(x -> x.getStudentId().equals(studentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nStudent with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding student to course isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding student to course isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(!course.isActive())
						{
							System.out.println(ANSI_RED + "\nCourse with this ID isn't active.\n" + ANSI_RESET);
							break;
						}
						else if(course.getStudentsId().contains(studentId))
						{
							System.out.println(ANSI_RED + "\nStudent with this ID is in the course.\n" + ANSI_RESET);
							break;
						}

						course.addStudent(student);
						student.addCourse(course);

						try
						{
							DataBase.addCourse(course);
							DataBase.addStudent(student);
							System.out.println(ANSI_GREEN + "\nAdding student to course is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding student to course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "11":
					{
						System.out.print("Student ID: ");
						String studentId = input.nextLine();
						Student student;

						try
						{
							if(DataBase.studentLoader().stream().map(Student::getStudentId).anyMatch(x -> x.equals(studentId)))
							{
								student = (Student) DataBase.studentLoader().stream().filter(x -> x.getStudentId().equals(studentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nStudent with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting student from course isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting student from course isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(!course.isActive())
						{
							System.out.println(ANSI_RED + "\nCourse with this ID isn't active.\n" + ANSI_RESET);
							break;
						}
						else if(!course.getStudentsId().contains(studentId))
						{
							System.out.println(ANSI_RED + "\nStudent with this ID isn't in the course.\n" + ANSI_RESET);
							break;
						}

						course.deleteStudent(student);
						student.deleteTermCourse(course);

						try
						{
							DataBase.addCourse(course);
							DataBase.addStudent(student);
							System.out.println(ANSI_GREEN + "\nDeleting student from course is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting student from course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "12":
					{
						System.out.print("Student ID: ");
						String studentId = input.nextLine();
						Student student;

						try
						{
							if(DataBase.studentLoader().stream().map(Student::getStudentId).anyMatch(x -> x.equals(studentId)))
							{
								student = (Student) DataBase.studentLoader().stream().filter(x -> x.getStudentId().equals(studentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nStudent with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding a passed course for a student isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding a passed course for a student isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(!course.isActive())
						{
							System.out.println(ANSI_RED + "\nCourse with this ID isn't active.\n" + ANSI_RESET);
							break;
						}
						else if(student.getPassedCoursesId().containsKey(courseId))
						{
							System.out.println(ANSI_RED + "\nStudent with this ID passed this course.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Score: ");
						double score;
						try
						{
							score = input.nextDouble();
							input.nextLine();
						}
						catch(InputMismatchException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding a passed course for a student isn't successful.\n" + ANSI_RESET);
							input.nextLine();
							break;
						}

						student.addPassedCourse(course, score);

						try
						{
							if(course.getStudentsId().removeIf(x -> x.equals(studentId)))
							{
								student.deleteTermCourse(course);
								DataBase.addCourse(course);
							}
							DataBase.addStudent(student);
							System.out.println(ANSI_GREEN + "\nAdding a passed course for a student is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding a passed course for a student isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "13":
					{
						System.out.print("Student ID: ");
						String studentId = input.nextLine();
						Student student;

						try
						{
							if(DataBase.studentLoader().stream().map(Student::getStudentId).anyMatch(x -> x.equals(studentId)))
							{
								student = (Student) DataBase.studentLoader().stream().filter(x -> x.getStudentId().equals(studentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nStudent with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting a passed course for a student isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting a passed course for a student isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(!course.isActive())
						{
							System.out.println(ANSI_RED + "\nCourse with this ID isn't active.\n" + ANSI_RESET);
							break;
						}
						else if(!student.getPassedCoursesId().containsKey(courseId))
						{
							System.out.println(ANSI_RED + "\nStudent with this ID doesn't passed this course.\n" + ANSI_RESET);
							break;
						}

						student.deletePassedCourse(course);

						try
						{
							DataBase.addStudent(student);
							System.out.println(ANSI_GREEN + "\nDeleting a passed course for a student is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting a passed course for a student isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "14":
					{
						try
						{
							System.out.println();
							DataBase.studentLoader().stream().sorted((x, y) -> x.getStudentId().compareTo(y.getStudentId())).forEach(System.out::println);
							System.out.println();
						}
						catch(EOFException	e)
						{
							System.out.println("\n");
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "Error: Printing list of students failed.\n" + ANSI_RESET);
						}

						break;
					}
					case "15":
					{
						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Activating this course isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(course.isActive())
						{
							System.out.println(ANSI_RED + "\nCourse with this ID is active.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Teacher ID: ");
						String teacherId = input.nextLine();

						try
						{
							if(DataBase.teacherLoader().stream().map(Teacher::getTeacherId).noneMatch(x -> x.equals(teacherId)))
							{
								System.out.println(ANSI_RED + "\nTeacher with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
							else
							{
								Teacher teacher = (Teacher)DataBase.teacherLoader().stream().filter(x -> x.getTeacherId().equals(teacherId)).toArray()[0];
								teacher.addCourse(courseId);
								DataBase.addTeacher(teacher);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Activating this course isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Exam date: ");
						String examDate = input.nextLine();

						course.activeCourse(teacherId, examDate);

						try
						{
							DataBase.addCourse(course);
							System.out.println(ANSI_GREEN + "\nActivating this course is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Activating this course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "16":
					{
						System.out.print("Course ID: ");
						String courseId = input.nextLine();
						Course course;

						try
						{
							if(DataBase.courseLoader().stream().map(Course::getCourseId).anyMatch(x -> x.equals(courseId)))
							{
								course = (Course) DataBase.courseLoader().stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nCourse with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Inactivating this course isn't successful.\n" + ANSI_RESET);
							break;
						}

						try
						{
								Teacher teacher = (Teacher)DataBase.teacherLoader().stream().filter(x -> x.getTeacherId().equals(course.getTeacherId())).toArray()[0];

								if(teacher != null)
								{
									teacher.removeCourse(courseId);
									DataBase.addTeacher(teacher);
								}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Inactivating this course isn't successful.\n" + ANSI_RESET);
							break;
						}

						course.inactiveCourse();

						try
						{
							DataBase.addCourse(course);
							System.out.println(ANSI_GREEN + "\nInactivating this course is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Inactivating this course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "17":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						try
						{
							if(DataBase.assignmentLoader().stream().map(Assignment::getAssignmentId).anyMatch(x -> x.equals(assignmentId)))
							{
								Assignment assignment = (Assignment)DataBase.assignmentLoader().stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0];

								System.out.print("Deadline: ");
								String deadline = input.nextLine();

								assignment.setDeadline(deadline);
								DataBase.addAssignment(assignment);

								System.out.println(ANSI_GREEN + "\nSet deadline of the assignment is successful.\n" + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_RED + "\nAssignment with this ID isn't exist.\n" + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Set deadline of the assignment isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "18":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						try
						{
							if(DataBase.assignmentLoader().stream().map(Assignment::getAssignmentId).anyMatch(x -> x.equals(assignmentId)))
							{
								Assignment assignment = (Assignment)DataBase.assignmentLoader().stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0];

								if(!assignment.isActive())
								{
									System.out.println(ANSI_RED + "\nThe assignment is inactive.\n" + ANSI_RESET);
									break;
								}

								assignment.inactive();
								DataBase.addAssignment(assignment);

								System.out.println(ANSI_GREEN + "\nInactivating the assignment is successful.\n" + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_RED + "\nAssignment with this ID isn't exist.\n" + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Inactivating the assignment isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "19":
					{
						System.out.print("Student ID: ");
						String studentId = input.nextLine();
						Student student;

						try
						{
							if(DataBase.studentLoader().stream().map(Student::getStudentId).anyMatch(x -> x.equals(studentId)))
							{
								student = (Student) DataBase.studentLoader().stream().filter(x -> x.getStudentId().equals(studentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nStudent with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Entering/editing score for a student's course isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Course ID: ");
						String courseId = input.nextLine();

						try
						{
							if(student.getTermCoursesId().containsKey(courseId))
							{
								System.out.print("Score: ");
								double score;
								score = input.nextDouble();
								input.nextLine();

								student.getTermCoursesId().replace(courseId, score);
							}
							else if(student.getPassedCoursesId().containsKey(courseId))
							{
								System.out.print("Score: ");
								double score;
								score = input.nextDouble();
								input.nextLine();

								student.getPassedCoursesId().replace(courseId, score);
							}
							else
							{
								System.out.println(ANSI_RED + "\nThe student doesn't have this course.\n" + ANSI_RESET);
								break;
							}
						}
						catch(InputMismatchException e)
						{
							System.out.println(ANSI_RED + "\nError: Entering/editing score for a student's course isn't successful.\n" + ANSI_RESET);
							input.nextLine();
							break;
						}

						try
						{
							DataBase.addStudent(student);
							System.out.println(ANSI_GREEN + "\nEntering/editing score for a student's course is successful.\n" + ANSI_RESET);
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Entering/editing score for a student's course isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "0":
					{
						flag = false;

						break;
					}
					default:

						System.out.println(ANSI_YELLOW + "\nYour number must be between 0 and 19.\n" + ANSI_RESET);
				}
			}
		}
		// Teacher
		else
		{
			Teacher teacher;

			while(true)
			{
				System.out.print("Please Enter your teacher ID: ");
				String teacherId = input.next();

				try
				{
					if(DataBase.teacherLoader().stream().map(Teacher::getTeacherId).noneMatch(x -> x.equals(teacherId)))
					{
						System.out.print(ANSI_YELLOW + "\nTeacher with this ID isn't exist. " + ANSI_RESET);
					}
					else
					{
						teacher = (Teacher) DataBase.teacherLoader().stream().filter(x -> x.getTeacherId().equals(teacherId)).toArray()[0];
						break;
					}
				}
				catch(IOException | ClassNotFoundException e)
				{
					System.out.println(ANSI_RED + "\nError: Please try again.\n" + ANSI_RESET);
					return;
				}
			}

			System.out.println(ANSI_GREEN + "\nWelcome " + teacher.getName() + "!\n" + ANSI_RESET);

			Set<Course> courses = new HashSet<>();

			try
			{
				Set<Course> dataBaseCourses = DataBase.courseLoader();

				for(String courseId: teacher.getCoursesId())
				{
					for(Course dataBaseCourse: dataBaseCourses)
					{
						if(dataBaseCourse.getCourseId().equals(courseId))
						{
							courses.add(dataBaseCourse);
							break;
						}
					}
				}
			}
			catch(IOException | ClassNotFoundException e)
			{
				System.out.println(ANSI_RED + "\nError: Please try again.\n" + ANSI_RESET);
				return;
			}

			boolean flag = true;

			input.nextLine();
			while(flag)
			{
				System.out.println(ANSI_BLUE + "Menu:");
				System.out.println("\t1. Print list of courses");
				System.out.println("\t2. Adding/editing assignment");
				System.out.println("\t3. Print list of assignments");
				System.out.println("\t4. Deleting assignment");
				System.out.println("\t. Adding student to course");
				System.out.println("\t. Deleting student from course");
				System.out.println("\t. Print list of students in a course");
				System.out.println("\t. Set deadline of an assignment");
				System.out.println("\t. Inactive an assignment");
				System.out.println("\t. Enter/edit a score for a student's course");
				System.out.println("\t0. Exit\n" + ANSI_RESET);

				System.out.print("Please enter a number between 0 and : ");				//TODO

				switch (input.nextLine())
				{
					case "1":
					{
						System.out.println();
						courses.stream().sorted((x, y) -> x.getCourseId().compareTo(y.getCourseId())).forEach(System.out::println);
						System.out.println();

						break;
					}
					case "2":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						System.out.print("Course ID: ");
						String courseId = input.nextLine();

						if(courses.stream().map(Course::getCourseId).noneMatch(x-> x.equals(courseId)))
						{
							System.out.println(ANSI_RED + "\nYou don't have access to this course.\n" + ANSI_RESET);
							break;
						}

						Course course = (Course)courses.stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];

						try
						{
							Set<Assignment> assignments = DataBase.assignmentLoader();

							if(assignments.stream().anyMatch(x -> x.getAssignmentId().equals(assignmentId)))
							{
								Assignment assignment = (Assignment)assignments.stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0];

								if(!assignment.getCourseId().equals(courseId))
								{
									System.out.println(ANSI_RED + "\nThis assignment doesn't belong to this course.\n" + ANSI_RESET);
									break;
								}

								System.out.println(ANSI_BLUE + "Assignment with this ID is exist." + ANSI_RESET);
							}
							else
							{
								System.out.println(ANSI_BLUE + "Assignment with this ID isn't exist." + ANSI_RESET);
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Adding/editing assignment isn't successful.\n" + ANSI_RESET);
							break;
						}

						System.out.print("Detail: ");
						String detail = input.nextLine();

						System.out.print(ANSI_BLUE + "Is the assignment active?(y/n) " + ANSI_RESET);

						while(true)
						{
							try
							{
								String answer = input.nextLine();
								if(answer.equals("y"))
								{
									System.out.print("Deadline: ");
									String deadline = input.nextLine();

									DataBase.addAssignment(new Assignment(assignmentId, detail, courseId, deadline));

									course.addAssignment(assignmentId);
									DataBase.addCourse(course);

									System.out.println(ANSI_GREEN + "\nAdding/editing assignment is successful.\n" + ANSI_RESET);

									break;
								}
								else if(answer.equals("n"))
								{
									DataBase.addAssignment(new Assignment(assignmentId, detail, courseId));

									course.addAssignment(assignmentId);
									DataBase.addCourse(course);

									System.out.println(ANSI_GREEN + "\nAdding/editing assignment is successful.\n" + ANSI_RESET);

									break;
								}

								System.out.print(ANSI_BLUE + "Is the assignment active?(y/n) " + ANSI_RESET);
							}
							catch(IOException | ClassNotFoundException e)
							{
								System.out.println(ANSI_RED + "\nError: Adding/editing assignment isn't successful.\n" + ANSI_RESET);
							}
						}

						break;
					}
					case "3":
					{
						System.out.print("Course ID: ");
						String courseId = input.nextLine();

						if(courses.stream().map(Course::getCourseId).noneMatch(x-> x.equals(courseId)))
						{
							System.out.println(ANSI_RED + "\nYou don't have access to this course.\n" + ANSI_RESET);
							break;
						}

						Course course = (Course)courses.stream().filter(x -> x.getCourseId().equals(courseId)).toArray()[0];

						try
						{
							Set<Assignment> assignments = DataBase.assignmentLoader();

							System.out.println();
							for(Object object: course.getAssignmentsId().stream().sorted().toArray())
							{
								String assignmentId = (String)object;
								if(assignments.stream().anyMatch(x -> x.getAssignmentId().equals(assignmentId)))
								{
									System.out.println(((Assignment) assignments.stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0]));
								}
							}
							System.out.println();
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Printing list of assignments isn't successful.\n"+ ANSI_RESET);
							break;
						}

						break;
					}
					case "4":
					{
						System.out.print("Assignment ID: ");
						String assignmentId = input.nextLine();

						Assignment assignment;
						try
						{
							Set<Assignment> assignments = DataBase.assignmentLoader();

							if(assignments.stream().anyMatch(x -> x.getAssignmentId().equals(assignmentId)))
							{
								assignment = (Assignment)assignments.stream().filter(x -> x.getAssignmentId().equals(assignmentId)).toArray()[0];
							}
							else
							{
								System.out.println(ANSI_RED + "\nAssignment with this ID isn't exist.\n" + ANSI_RESET);
								break;
							}
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting assignment isn't successful.\n" + ANSI_RESET);
							break;
						}

						if(courses.stream().map(Course::getCourseId).noneMatch(x-> x.equals(assignment.getCourseId())))
						{
							System.out.println(ANSI_RED + "\nYou don't have access to this course.\n" + ANSI_RESET);
							break;
						}

						Course course = (Course)courses.stream().filter(x -> x.getCourseId().equals(assignment.getCourseId())).toArray()[0];

						try
						{
							DataBase.removeAssignment(assignment);

							course.deleteAssignment(assignmentId);
							DataBase.addCourse(course);

							System.out.println(ANSI_GREEN + "\nDeleting assignment is successful.\n" + ANSI_RESET);
							break;
						}
						catch(IOException | ClassNotFoundException e)
						{
							System.out.println(ANSI_RED + "\nError: Deleting assignment isn't successful.\n" + ANSI_RESET);
						}

						break;
					}
					case "5":
					{

						break;
					}
					case "6":
					{

						break;
					}
					case "7":
					{

						break;
					}
					case "8":
					{

						break;
					}
					case "9":
					{

						break;
					}
					case "10":
					{

						break;
					}
					case "0":
					{
						flag = false;

						break;
					}
					default:

						System.out.println(ANSI_YELLOW + "\nYour number must be between 0 and .\n" + ANSI_RESET);		//TODO
				}
			}
		}


		input.close();
	}
}
