package scrame;

import java.util.Scanner;

public class PrintCourseStatistics {

	public static void run() {

		Scanner sc = new Scanner(System.in);

		int[] totalMarks = new int[3];
		int numberOfStudents = 0;

		System.out.println("Enter Course Code");

		String courseCode = sc.nextLine(); // check

		for (StudentCourse studentCourse : Main.studentCourseList) {
			if (studentCourse.getCourseCode().equals(courseCode)) {
				totalMarks[0] += studentCourse.getMarksRecord()[0];
				totalMarks[1] += studentCourse.getMarksRecord()[1];
				totalMarks[2] += studentCourse.getMarksRecord()[2];
				numberOfStudents++;
			}
		}

		Course course = CourseManager.getCourse(courseCode);

		int examPercentage = course.getComponents().get(0).getPercentage();
		int assignmentPercentage = course.getComponents().get(1).getPercentage();
		int classPartPercentage = course.getComponents().get(2).getPercentage();

		// Show exam only
		double examGrade = 0;
		if (examPercentage != 0) {
			System.out.println("Average Grade Percentage for Exams (" + examPercentage + "%)");
			examGrade = (double) totalMarks[0] / numberOfStudents;
			System.out.println(examGrade);
		}

		// Show coursework only
		int courseWorkPercentage = assignmentPercentage + classPartPercentage;
		double assignmentGrade = 0;
		double classPartGrade = 0;
		double courseworkGrade = 0;
		if (courseWorkPercentage != 0) {
			System.out.println("Average Grade Percentage for Coursework (" + (100 - examPercentage) + "%)");
			assignmentGrade = (double) (assignmentPercentage * totalMarks[1]) / courseWorkPercentage;
			classPartGrade = (double) (classPartPercentage * totalMarks[2]) / courseWorkPercentage;
			courseworkGrade = (assignmentGrade + classPartGrade) / numberOfStudents;
			System.out.println(courseworkGrade);
		}

		// Show overall
		System.out.println("Average Grade Percentage for Overall (100%)");
		double gradePercentage = 
				((examGrade * examPercentage) / 100) + 
				((courseworkGrade * courseWorkPercentage) / 100);
		System.out.println(gradePercentage);
	}
}
