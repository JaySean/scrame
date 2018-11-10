package scrame;

import java.util.Scanner;

public class EnterCourseworkMarks {

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
		
		// Enter Assignment Marks
		Components assignmentComponent = course.getComponents().get(1);
		if (assignmentComponent.getPercentage() != 0){
			System.out.println("Enter " + assignmentComponent.getType() + " Marks:");
			marks = sc.nextInt(); // check mark range
			studentCourse.setMarksRecord(1, marks);
		}
		
		// Enter Class Part Marks
		Components classPartComponent = course.getComponents().get(2);
		if (classPartComponent.getPercentage() != 0){
			System.out.println("Enter " + classPartComponent.getType() + " Marks:");
			marks = sc.nextInt(); // check mark range
			studentCourse.setMarksRecord(2, marks);
		}
		
		StudentCourseManager.amendStudentCourse(studentCourse);
	}
}
