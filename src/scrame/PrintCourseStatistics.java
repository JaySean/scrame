package scrame;

import com.mitchtalmadge.asciidata.table.ASCIITable;

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

		/*
		=======
		String[] headers = new String[]{"Component", "Average Grade"};
		String[][] data = new String[3][2];

		int i = 0;

		// Show exam only
		double examGrade = 0;
		if (examPercentage != 0) {
			examGrade = (double) totalMarks[0] / numberOfStudents;
			data[i][0] = "Exam (" + examPercentage + "%)";
			data[i][1] = Double.toString(examGrade);
			i++;
		}

		// Show coursework only
		int courseWorkPercentage = assignmentPercentage + classPartPercentage;
		double assignmentGrade = 0;
		double classPartGrade = 0;
		double courseworkGrade = 0;
		if (courseWorkPercentage != 0) {
			assignmentGrade = (double) (assignmentPercentage * totalMarks[1]) / courseWorkPercentage;
			classPartGrade = (double) (classPartPercentage * totalMarks[2]) / courseWorkPercentage;
			courseworkGrade = (assignmentGrade + classPartGrade) / numberOfStudents;

			data[i][0] = "Coursework (" + (100 - examPercentage) + "%)";
			data[i][1] = Double.toString(courseworkGrade);
			i++;
		}

		// Show overall
		double gradePercentage =
				((examGrade * examPercentage) / 100) +
				((courseworkGrade * courseWorkPercentage) / 100);
		data[i][0] = "Overall (100%)";
		data[i][1] = Double.toString(gradePercentage);

		// Ouput data
		System.out.println(ASCIITable.fromData(headers, data).toString());
		>>>>>>> 7bb402464e9b97929307ae633d699464d5a117ef
		*/

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
