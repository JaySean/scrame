package scrame;

import java.util.Scanner;

public class EnterExamMarks {
	
	final static String studentCourseFile = "data/StudentCourse.txt";

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Matriculation Number");
		String studentMatric = sc.nextLine();
		System.out.println("Enter Course Code");
		String courseCode = sc.nextLine();
		
		Course course = CourseManager.getCourse(courseCode);
		
		StudentCourse studentCourse = StudentCourseManager.createStudentCourse(studentMatric, courseCode);
		
		int marks;
		
		// Enter Exam Marks
		Components examComponent = course.getComponents().get(0);
		if (examComponent.getPercentage() != 0){
			System.out.println("Enter " + examComponent.getType() + " Marks:");
			marks = sc.nextInt(); // check mark range
			studentCourse.setMarksRecord(0, marks);
		}
		
		StudentCourseManager.amendStudentCourse(studentCourse);
	}
}
