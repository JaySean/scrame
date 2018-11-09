package scrame;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintStudentTranscript {

	private final static String courseFile = "data/Courses.txt";

	public static void run() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Matriculation Number");
		String studentMatric = sc.nextLine();

		ArrayList<Course> courseList = DatabaseManager.read(courseFile);

		for (Course course : courseList) {
			String[] studentList = course.getSession().get(0).getStudentList();
			for (int i = 0; i < studentList.length; i++) {
				if (studentList[i] != null) { // Exception handling
					if (studentList[i].equals(studentMatric)) {
						System.out.println();
						System.out.println("Course: " + course.getCourseName() + " " + course.getCourseCode());
						ArrayList<Components> components = course.getComponents();
						double totalMarks = 0;
						for (Components component : components) {
							if (component.getPercentage() != 0) {
								int componentPercentage = component.getPercentage();
								double componentMarks = component.getRecord().get(i).getMarks();
								System.out.println(component.getType() + "(" + componentPercentage + "%): " + componentMarks);
								totalMarks += (componentPercentage * componentMarks) / 100;
							}
						}
						System.out.println("Total Marks: " + totalMarks);
					}
				}
			}
		}
	}
}
