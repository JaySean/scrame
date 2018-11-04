package scrame;

import java.util.Scanner;

public class PrintStudentList {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Code");
		String courseCode = sc.nextLine();
		Course course = CourseManager.getCourse(courseCode);
		
		int tutNumber = course.getTutNumber();
		int labNumber = course.getLabNumber();
		
		String[] studentList;

		// Print list by Lecture
		System.out.println("Lecture:");
		studentList = course.getSession().get(0).getStudentList();
		for (int j = 0; j < studentList.length; j++) {
			if (studentList[j] != null) {
				System.out.println(studentList[j]);
			}
		}

		// Print list by Tutorial group/s
		for (int i = 1; i < 1 + tutNumber; i++) {
			studentList = course.getSession().get(i).getStudentList();
			System.out.println("Tutorial " + i + ":");
			for (int j = 0; j < studentList.length; j++) {
				if (studentList[j] != null) {
					System.out.println(studentList[j]);
				}
			}
		}
		
		// Print list by Lab group/s
		for (int i = 1 + tutNumber; i < 1 + tutNumber + labNumber; i++) {
			studentList = course.getSession().get(i).getStudentList();
			System.out.println("Lab " + (i - tutNumber) + ":");
			for (int j = 0; j < studentList.length; j++) {
				if (studentList[j] != null) {
					System.out.println(studentList[j]);
				}
			}
		}
	}
}
