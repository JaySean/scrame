package scrame.course;

import scrame.DatabaseManager;
import scrame.Main;

import java.io.*;

public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static String courseFile = "data/Courses.txt";

	public static boolean checkCourseExistence(String courseCode) {
		for (Course course : Main.courseList) {
			if (course.getCourseCode().equals(courseCode)) return true;
		}
		return false;
	}

	public static Course getCourse(String courseCode) {
		Course c;
		for (int i = 0; i < Main.courseList.size(); i++) {
			c = Main.courseList.get(i);
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}

	public static int getCourseIndex(String courseCode) {
		Course c;
		for (int i = 0; i < Main.courseList.size(); i++) {
			c = Main.courseList.get(i);
			if (c.getCourseCode().equals(courseCode)) {
				return i;
			}
		}
		return -1;
	}

	public static void updateCourse(Course course) {
		if (course == null) return;
		int index = getCourseIndex(course.getCourseCode());
		Main.courseList.set(index, course);
		DatabaseManager.write(Main.courseList, courseFile);
	}
}
