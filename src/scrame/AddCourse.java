package scrame;

import java.util.Scanner;

public class AddCourse {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name"); // need to check validity
		String courseName = sc.nextLine();
		System.out.println("Enter Course Code"); // need to check validity
		String courseCode = sc.nextLine();

		System.out.println("Enter Course Coordinator");
		String courseCoordinator = sc.nextLine();

		System.out.println("Enter Course Capacity");
		int courseCapacity = sc.nextInt();
		System.out.println("Enter Number of Tutorial Class");
		int tutNumber = sc.nextInt();
		System.out.println("Enter Number of Laboratory Class");
		int labNumber = sc.nextInt();

		System.out.println("Weightage of Exam and Coursework:");
		System.out.println("Enter Exam Percentage:");
		int examPercent = sc.nextInt();
		System.out.println("Enter Coursework Percentage:");
		int courseWorkPercent = sc.nextInt(); // check =100%
		int assignmentPercent = 0;
		int classPartPercent = 0;
		if (courseWorkPercent != 0) {
			System.out.println("Weightage of Assignment and Class Participation in CourseWork");
			System.out.println("Enter Assignment Percentage:");
			assignmentPercent = sc.nextInt();
			System.out.println("Enter Class Participation Percentage:");
			classPartPercent = sc.nextInt();
		}

		CourseManager.addCourse(courseName, courseCode, courseCoordinator, courseCapacity, tutNumber, labNumber,
				examPercent, courseWorkPercent, assignmentPercent, classPartPercent);
	}
}
