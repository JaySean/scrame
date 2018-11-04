package scrame;

import java.util.Scanner;

public class CheckVacancy {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Code");
		String courseCode = sc.nextLine();
		Course course = CourseManager.getCourse(courseCode);
		int tutNumber = course.getTutNumber();
		int labNumber = course.getLabNumber();
		
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
