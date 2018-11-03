package scrame;

import java.util.Scanner;

public class CheckVacancy {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		Course course = CourseManager.getCourse(courseName);
		int tutNumber = course.getTutNumber();
		int labNumber = course.getLabNumber();
		
		System.out.println("Lecture 1: " + course.getSession().get(0).getVacancy() + "/"
				+ course.getSession().get(0).getCapacity());
		
		for (int i = 1; i < 1 + tutNumber; i++) {
			System.out.println("Tutorial " + i + ": " + course.getSession().get(i).getVacancy() + "/"
					+ course.getSession().get(i).getCapacity());
		}
		for (int i = 1 + tutNumber; i < 1 + tutNumber + labNumber; i++) {
			System.out.println("Lab " + (i - tutNumber) + ": " + course.getSession().get(i).getVacancy() + "/"
					+ course.getSession().get(i).getCapacity());
		}
	}
}
