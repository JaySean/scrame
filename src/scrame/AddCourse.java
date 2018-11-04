package scrame;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCourse {
	
	private final static String courseFile = "data/Courses.txt";

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		// Write file to array
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		System.out.println("Enter Course Code"); // need to check validity: of format e.g. CZ2002; check for repeated course
		String courseCode = sc.nextLine();
		System.out.println("Enter Course Coordinator"); // need to check validity: only alphabets
		String courseCoordinator = sc.nextLine();
		System.out.println("Enter Course Capacity"); // need to check validity: only integer
		int courseCapacity = sc.nextInt();
		System.out.println("Enter Number of Tutorial Class"); // need to check validity: only integer
		int tutNumber = sc.nextInt();
		System.out.println("Enter Number of Laboratory Class"); // need to check validity: only integer
		int labNumber = sc.nextInt();
		System.out.println("Exam and Coursework Weightage:");
		System.out.println("Enter Exam Percentage:"); // need to check validity: only integer, between  0-100
		int examPercent = sc.nextInt();
		System.out.println("Enter Coursework Percentage:"); // need to check validity: only integer, between  0-100
		int courseWorkPercent = sc.nextInt(); // check = 100%
		int assignmentPercent = 0;
		int classPartPercent = 0;
		if (courseWorkPercent != 0) {
			System.out.println("Assignment and Class Participation Weightage");
			System.out.println("Enter Assignment Percentage:"); // need to check validity: only integer, between  0-100
			assignmentPercent = sc.nextInt();
			System.out.println("Enter Class Participation Percentage:"); // need to check validity: only integer, between  0-100
			classPartPercent = sc.nextInt(); // check = 100%
		}

		// Create sessions
		ArrayList<Session> session = AddSession.add(courseCapacity, tutNumber, labNumber);
		
		// Create components
		ArrayList<Components> components = AddComponents.add(examPercent, courseWorkPercent, assignmentPercent,
				classPartPercent);
		
		// Create new instance of course
		Course course = new Course(courseName, courseCode, courseCoordinator, session, tutNumber, labNumber,
				components);
		
		// Add course to array
		courseList.add(course);
		
		// Print list of ALL courses
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println(courseList.get(i).getCourseName() + " " + courseList.get(i).getCourseCode() + " "
					+ courseList.get(i).getCourseCoordinator());
		}

		// Write array to file
		DatabaseManager.write(courseList, courseFile);
	}
}
