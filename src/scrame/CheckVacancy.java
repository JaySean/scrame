package scrame;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckVacancy {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		int index;

		String courseCode = getCourseCode(sc);
		//course has to exist, check done above
		Course course = CourseManager.getCourse(courseCode);

		ArrayList<Lecture> lectures = course.getLectures();
		ArrayList<Tutorial> tutorials = course.getTutorials();
		ArrayList<Laboratory> labs = course.getLaboratories();

		index = 1;
		for (Lecture lecture : lectures) {
			System.out.println("Lecture " + index + ": " + lecture.getVacancy() + "/" + lecture.getCapacity());
			index++;
		}

		index = 1;
		for (Tutorial tutorial : tutorials) {
			System.out.println("Tutorial " + index + ": " + tutorial.getVacancy() + "/" + tutorial.getCapacity());
			index++;
		}

		index = 1;
		for (Laboratory lab : labs) {
			System.out.println("Laboratory " + index + ": " + lab.getVacancy() + "/" + lab.getCapacity());
			index++;
		}
	}

	private static String getCourseCode(Scanner sc) {
		try {
			System.out.println("Enter Course Code");
			String courseCode = sc.nextLine();
			//check format
			FormatValidator.validateCourseCode(courseCode);
			//check existence
			boolean exists = CourseManager.checkCourseExistence(courseCode);
			if (!exists) throw new Exception("Course does not exist!");
			return courseCode;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getCourseCode(sc);
		}
	}
}
