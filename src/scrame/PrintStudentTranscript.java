package scrame;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintStudentTranscript {

	public static void run() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Matriculation Number");
		String studentMatric = sc.nextLine();

		for (StudentCourse studentCourse : Main.studentCourseList) {
			if (studentCourse.getStudentMatric().equals(studentMatric)) {
				Course course = CourseManager.getCourse(studentCourse.getCourseCode());
				System.out.println();
				System.out.println("Course: " + course.getCourseName() + " " + course.getCourseCode());
				ArrayList<Components> components = course.getComponents();
				double totalMarks = 0;
				for (int i = 0; i < 3; i++) {
					int componentPercentage = components.get(i).getPercentage();
					if (componentPercentage != 0) {
						double componentMarks = studentCourse.getMarksRecord()[i];
						System.out.println(
								components.get(i).getType() + "(" + componentPercentage + "%): " + componentMarks);
						totalMarks += (componentPercentage * componentMarks) / 100;
					}
				}
				System.out.println("Total Marks: " + totalMarks);
			}
		}
	}
}
