package scrame;

import java.io.*;
import java.util.*;

public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Scanner sc = new Scanner(System.in);

	private final static String courseFile = "data/Courses.txt";

	public static boolean checkCourseExistence(String courseCode) {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		for (Course course : courseList) {
			if (course.getCourseCode().equals(courseCode)) return true;
		}
		return false;
	}

	public static Course getCourse(String courseCode) {
		Course c = null;
		for (int i = 0; i < getCourseList().size(); i++) {
			c = getCourseList().get(i);
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
		}
		return null; // Should return with what? Exception handling?
	}

	public static int getCourseIndex(String courseCode) {
		Course c = null;
		for (int i = 0; i < getCourseList().size(); i++) {
			c = getCourseList().get(i);
			if (c.getCourseCode().equals(courseCode)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<Course> getCourseList() {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		return courseList;
	}

	public static void updateCourse(int courseIndex, Course c) {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		courseList.set(courseIndex, c);
		DatabaseManager.write(courseList, courseFile);
	}

}
