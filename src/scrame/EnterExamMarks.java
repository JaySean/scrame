package scrame;

import java.util.Scanner;

public class EnterExamMarks {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Code");
		String courseCode = sc.nextLine();
		System.out.println("Enter Student Matriculation Number");
		String studentMatric = sc.nextLine();
		
		int examMarks = 0;
		
		Course course = CourseManager.getCourse(courseCode);
		
		// Enter Exam Marks
		Components examComponent = course.getComponents().get(0);
		
		System.out.println("Enter " + examComponent.getType() + " Marks:");
		examMarks = sc.nextInt();
		
		AddMarks.add(course, studentMatric, examMarks, 0);
	}
}
