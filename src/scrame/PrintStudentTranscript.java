package scrame;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintStudentTranscript {

	public static void run() {
		Scanner sc = new Scanner(System.in);

		String studentMatric = getStudentMatric(sc);

		StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric);
		String courseCode = studentCourse.getCourseCode();
		Course course = CourseManager.getCourse(courseCode);
		System.out.println("Course: " + course.getCourseName() + " " + courseCode);

		int eMarks = studentCourse.getExamMarks();
		int aMarks = studentCourse.getAssignmentMarks();
		int cMarks = studentCourse.getClassPartMarks();

		System.out.println("Exam: " + course.getExamComponent().getPercentage() + "%");
		System.out.println(studentCourse.getExamMarks());
		if (course.hasAssignment()) {
			System.out.println("Assignment: " + course.getAssignmenComponent().getPercentage() + "%");
			System.out.println(studentCourse.getAssignmentMarks());
		}
		if (course.hasClassPart()) {
			System.out.println("Class Participation: " + course.getClassPartComponent().getPercentage() + "%");
			System.out.println(studentCourse.getClassPartMarks());
		}
		double adjustedExam = (double) studentCourse.getExamMarks() * course.getExamComponent().getPercentage() / 100;
		double adjustedAssignment = (double) studentCourse.getAssignmentMarks() * course.getAssignmenComponent().getPercentage() / 100;
		double adjustedClassPart = (double) studentCourse.getClassPartMarks() * course.getClassPartComponent().getPercentage() / 100;
		double total = adjustedExam + adjustedAssignment + adjustedClassPart;
		System.out.println("Total:");
		System.out.println(total);

		/*
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
		*/
	}

	private static String getStudentMatric(Scanner sc) {
		try {
			System.out.println("Enter Student Matriculation Number");
			String studentMatric = sc.nextLine();
			//validate format
			FormatValidator.validateMatricNo(studentMatric);
			//validate existence
			if (!StudentManager.checkStudentExistence(studentMatric)) throw new Exception("Student does not exist!");
			return studentMatric;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getStudentMatric(sc);
		}
	}
}
