package scrame;

import java.util.Scanner;

public class PrintCourseStatistics {

	public static void run() {

		Scanner sc = new Scanner(System.in);
		String courseCode = getCourseCode(sc);

		Course course = CourseManager.getCourse(courseCode);

		//show exam
		int examPercentage = course.getExamComponent().getPercentage();
		System.out.println("Average Grade Percentage for Exams (" + examPercentage + "%)");
		double examAveMarks = StudentCourseManager.getAverageExamForCourse(courseCode);
		System.out.println(examAveMarks);

		//show coursework
		int courseworkPercentage = 0;
		double courseworkAveMarks = 0;
		if (course.hasClassPart() || course.hasAssignment()) {

			int assignmentPercentage = course.getAssignmenComponent().getPercentage();
			int classpartPercentage = course.getClassPartComponent().getPercentage();

			courseworkPercentage = assignmentPercentage + classpartPercentage;

			System.out.println("Average Grade Percentage for Coursework (" + courseworkPercentage + "%)");

			double assignmentAveMarks = StudentCourseManager.getAverageAssignmentForCourse(courseCode);
			double classpartAveMarks = StudentCourseManager.getAverageClassPartForCourse(courseCode);
			double adjustedAssignmentMarks = (double) assignmentPercentage * assignmentAveMarks / courseworkPercentage;
			double adjustedclasspartAveMarks = (double) classpartPercentage * classpartAveMarks / courseworkPercentage;

			courseworkAveMarks = adjustedAssignmentMarks + adjustedclasspartAveMarks;

			System.out.println(courseworkAveMarks);
		}

		//show overall
		System.out.println("Average Grade Percentage for Overall (100%)");
		double adjustedExamMarks = examAveMarks * examPercentage / 100;
		double adjustedCourseWorkMarks = courseworkAveMarks * courseworkPercentage / 100;
		System.out.println(adjustedExamMarks + adjustedCourseWorkMarks);

	}

	private static String getCourseCode(Scanner sc) {
		try {
			System.out.println("Enter Course Code");
			String courseCode = sc.nextLine();
			//check format
			FormatValidator.validateCourseCode(courseCode);
			//check existence
			boolean exist = CourseManager.checkCourseExistence(courseCode);
			if (!exist) throw new Exception("Course does not exist!");
			//check vacancy
			Course course = CourseManager.getCourse(courseCode);
			if (!CourseManager.getCourse(courseCode).hasVacancy()) throw new Exception("There are no vacancies left in this course!");
			return courseCode;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getCourseCode(sc);
		}
	}
}
