package scrame;

import java.util.Scanner;

public class EnterExamMarks {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		System.out.println("Enter Student Matric Number");
		String studentMatricNo = sc.nextLine();
		int examMarks = 0;
		System.out.println("Enter " + CourseManager.getCourse(courseName).getComponents().get(0).getType() + " Marks:");
		examMarks = sc.nextInt();
		CourseManager.addCourseworkMarks(courseName, studentMatricNo, examMarks, 0);
	}
}
