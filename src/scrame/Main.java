package scrame;

import java.util.*;

public class Main {

	// Global Variables
	public static ArrayList<Course> courseList;
	public static ArrayList<Student> studentList;
	public static ArrayList<StudentCourse> studentCourseList;
	
	public static void main(String[] args) {
		
		// Global variables
		final String courseFile = "data/Courses.txt";
		final String studentFile = "data/Students.txt";
		final String studentCourseFile = "data/StudentCourse.txt";
		
		// Read file to array
		courseList = DatabaseManager.read(courseFile);
		studentList = DatabaseManager.read(studentFile);
		studentCourseList = DatabaseManager.read(studentCourseFile);
		
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		int input;
		do {
			showMenu();
			// get input choice number + validation of choice
			try {
				input = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			// switch input
			switch (input) {
				case 1:
					AddStudent.run();
					break;
				case 2:
					AddCourse.run();
					break;
				case 3:
					RegisterStudent.run();
					break;
				case 4:
					CheckVacancy.run();
					break;
				case 5:
					PrintStudentList.run();
					break;
				case 7:
					EnterCourseworkMarks.run();
					break;
				case 8:
					EnterExamMarks.run();
					break;
				case 9:
					PrintCourseStatistics.run();
					break;
				case 10:
					PrintStudentTranscript.run();
					break;
				case 11:
					repeat = false;
					DatabaseManager.write(courseList, courseFile);
					DatabaseManager.write(studentList, studentFile);
					break;
				default:
					System.out.println("Choice out of range: Choice must be 1-11");
					break;
			}
		} while (repeat);
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Register student for a course");
		System.out.println("4: Check available slot in a class");
		System.out.println("5: Print student list by lecture, tutorial or laboratory session for a course");
		System.out.println("6: Enter course assessment components weightage");
		System.out.println("7: Enter coursework mark - inclusive of its components");
		System.out.println("8: Enter exam mark");
		System.out.println("9: Print course statistics");
		System.out.println("10: Print student transcript");
		System.out.println("11: Save and Quit");
	}
}
