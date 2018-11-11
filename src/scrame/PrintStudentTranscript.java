package scrame;

import com.mitchtalmadge.asciidata.table.ASCIITable;

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

				int numberOfCourses = course.getComponentNo();
				String[] headers = new String[]{"Course Name", "Course Code"};
				String[][] data = new String[numberOfCourses+3][2];
				data[0][0] = course.getCourseName();
				data[0][1] = course.getCourseCode();
				data[1][0] = "---Component---";
				data[1][1] = "---Marks---";

				ArrayList<Components> components = course.getComponents();
				double totalMarks = 0;
				for (int i = 0; i < 3; i++) {
					int componentPercentage = components.get(i).getPercentage();
					if (componentPercentage != 0) {
						double componentMarks = studentCourse.getMarksRecord()[i];
						data[i+2][0] = components.get(i).getType() + "(" + componentPercentage + "%)";
						data[i+2][1] = Double.toString(componentMarks);
						totalMarks += (componentPercentage * componentMarks) / 100;
					}
				}
				data[numberOfCourses+2][0] = "Total Marks";
				data[numberOfCourses+2][1] = Double.toString(totalMarks);

				// Output data
				System.out.println(ASCIITable.fromData(headers, data).toString());
			}
		}
	}
}
