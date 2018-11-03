package scrame;

import java.util.Scanner;

public class PrintStudentList {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		Course course = CourseManager.getCourse(courseName);
		int tutNumber = course.getTutNumber();
		int labNumber = course.getLabNumber();
		String[] studentList;
//		for (int i = 0; i < course.getSession().size(); i++) {
//			studentList = course.getSession().get(i).getStudentList();
//			for (int j = 0; j < studentList.length; j++) {
//				if (studentList[j] != null) {
//					System.out.println(studentList[j]);
//				}
//			}
//			System.out.println();
//		}

		System.out.println("Lecture:");
		studentList = course.getSession().get(0).getStudentList();
		for (int j = 0; j < studentList.length; j++) {
			if (studentList[j] != null) {
				System.out.println(studentList[j]);
			}
		}

		for (int i = 1; i < 1 + tutNumber; i++) {
			studentList = course.getSession().get(i).getStudentList();
			System.out.println("Tutorial " + i + ":");
			for (int j = 0; j < studentList.length; j++) {
				if (studentList[j] != null) {
					System.out.println(studentList[j]);
				}
			}
		}
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
