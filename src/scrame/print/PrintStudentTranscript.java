package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.*;
import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.student.StudentCourse;

public class PrintStudentTranscript {

	public static void run() {

		/*
		String studentMatric = Input.getStudentMatric();

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
			System.out.println("Assignment: " + course.getAssignmentComponent().getPercentage() + "%");
			System.out.println(studentCourse.getAssignmentMarks());
		}
		if (course.hasClassPart()) {
			System.out.println("Class Participation: " + course.getClassPartComponent().getPercentage() + "%");
			System.out.println(studentCourse.getClassPartMarks());
		}
		double adjustedExam = (double) studentCourse.getExamMarks() * course.getExamComponent().getPercentage() / 100;
		double adjustedAssignment = (double) studentCourse.getAssignmentMarks() * course.getAssignmentComponent().getPercentage() / 100;
		double adjustedClassPart = (double) studentCourse.getClassPartMarks() * course.getClassPartComponent().getPercentage() / 100;
		double total = adjustedExam + adjustedAssignment + adjustedClassPart;
		System.out.println("Total:");
		System.out.println(total);
		*/

		String studentMatric = Input.getStudentMatric();

		for (StudentCourse studentCourse : Main.studentCourseList)
			if (studentCourse.getStudentMatric().equals(studentMatric)) {
				Course course = CourseManager.getCourse(studentCourse.getCourseCode());
				System.out.println();

				int number = 4;
				if (course.hasAssignment()) {
					number++;
				}
				if (course.hasClassPart()) {
					number++;
				}

				String[] headers = new String[]{"Course Name", "Course Code"};
				String[][] data = new String[number][2];
				data[0][0] = course.getCourseName();
				data[0][1] = course.getCourseCode();
				data[1][0] = "---Component---";
				data[1][1] = "---Marks---";


				data[2][0] = "Exam: " + course.getExamComponent().getPercentage() + "%";
				data[2][1] = Double.toString(studentCourse.getExamMarks());

				int i = 1;

				if (course.hasAssignment()) {
					data[i + 2][0] = "Assignment: " + course.getAssignmentComponent().getPercentage() + "%";
					data[i + 2][1] = Double.toString(studentCourse.getAssignmentMarks());
					i++;
				}

				if (course.hasClassPart()) {
					data[i + 2][0] = "Class Participation: " + course.getClassPartComponent().getPercentage() + "%";
					data[i + 2][1] = Double.toString(studentCourse.getClassPartMarks());
					i++;
				}

				double adjustedExam = (double) studentCourse.getExamMarks() * course.getExamComponent().getPercentage() / 100;
				double adjustedAssignment = (double) studentCourse.getAssignmentMarks() * course.getAssignmentComponent().getPercentage() / 100;
				double adjustedClassPart = (double) studentCourse.getClassPartMarks() * course.getClassPartComponent().getPercentage() / 100;
				double totalMarks = adjustedExam + adjustedAssignment + adjustedClassPart;

				data[i + 2][0] = "Total Marks";
				data[i + 2][1] = Double.toString(totalMarks);

				// Output data
				System.out.println(ASCIITable.fromData(headers, data).toString());
			}

	}
}
