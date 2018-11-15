package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.Input;
import scrame.StudentCourseManager;

public class PrintCourseStatistics {

	public static void run() {

		String courseCode = Input.getCourseCode();

		Course course = CourseManager.getCourse(courseCode);

		/*
		// Show Exam
		int examPercentage = course.getExamComponent().getPercentage();
		System.out.println("Average Grade Percentage for Exams (" + examPercentage + "%)");
		double examAveMarks = StudentCourseManager.getAverageExamForCourse(courseCode);
		System.out.println(examAveMarks);

		// Show Coursework
		int courseworkPercentage = 0;
		double courseworkAveMarks = 0;
		if (course.hasClassPart() || course.hasAssignment()) {

			int assignmentPercentage = course.getAssignmentComponent().getPercentage();
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

		*/



		String[] headers = new String[]{"Component", "Average Grade"};
		String[][] data = new String[3][2];

		int i = 0;

		// Show xam only
		int examPercentage = course.getExamComponent().getPercentage();
		double examGrade = StudentCourseManager.getAveExamMarks(courseCode);
		data[i][0] = "Exam (" + examPercentage + "%)";
		data[i][1] = Double.toString(examGrade);
		i++;

		// Show coursework only
		double courseworkGrade = 0;
		int courseworkPercentage = 0;
		if (course.hasClassPart() || course.hasAssignment()) {
			int assignmentPercentage = course.getAssignmentComponent().getPercentage();
			int classPartPercentage = course.getClassPartComponent().getPercentage();
			courseworkPercentage = assignmentPercentage + classPartPercentage;

			double aveAssignmentMarks = StudentCourseManager.getAveAssignmentMarks(courseCode);
			double aveClassPartMarks = StudentCourseManager.getAveClassPartMarks(courseCode);
			double assignmentGrade = (double) assignmentPercentage * aveAssignmentMarks / courseworkPercentage;
			double classPartGrade = (double) classPartPercentage * aveClassPartMarks / courseworkPercentage;
			courseworkGrade = assignmentGrade + classPartGrade;

			data[i][0] = "Coursework (" + (100 - examPercentage) + "%)";
			data[i][1] = Double.toString(courseworkGrade);
			i++;
		}

		// Show overall
		double gradePercentage =
				((examGrade * examPercentage) / 100) +
				((courseworkGrade * courseworkPercentage) / 100);
		data[i][0] = "Overall (100%)";
		data[i][1] = Double.toString(gradePercentage);

		// Ouput data
		System.out.println(ASCIITable.fromData(headers, data).toString());
	}
}
