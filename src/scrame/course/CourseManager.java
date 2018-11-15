package scrame.course;

import scrame.DatabaseManager;
import scrame.Main;

import java.io.*;

/**
 * Control class to manage Courses
 * @author CZ2002 SS3 Group 1
 * @version 2
 */
public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Read course data into a .txt file
	 */
	private final static String courseFile = "data/Courses.txt";

	/**
	 * getter method to return the list of courses
	 * @param courseCode
	 * @return
	 */
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

	/**
	 * counter that returns the index of the course that the user is try to update
	 * @param courseCode code of a course that unique to each course
	 * @return
	 */
	public static int getIndex(String courseCode) {
		Course c;
		for (int i = 0; i < Main.courseList.size(); i++) {
			c = Main.courseList.get(i);
			if (c.getCourseCode().equals(courseCode)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * method to update a particular course
	 * @param course
	 */
	public static void updateCourse(Course course) {
		if (course == null) return;
		int index = getIndex(course.getCourseCode());
		if (index == -1){
			Main.courseList.add(course);
		}
		else {
			Main.courseList.set(index, course);
		}
		DatabaseManager.write(Main.courseList, courseFile);
	}
}
