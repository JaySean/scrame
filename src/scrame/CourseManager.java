package scrame;

import java.io.*;
import java.util.*;

public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;
	public final static String courseFile = "data/Courses.txt";

	public static void addCourse(String courseName, String courseCode) {

		Course course = new Course(courseName, courseCode);
		course.addCoordinator();
		course.addVacancy();
		course.addSession();
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		courseList.add(course);
		DatabaseManager.write(courseList, courseFile);

	}
	
	public static boolean checkCourse(String courseName) {
		boolean checkCourse = false;
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getCourseName().equals(courseName)) {
				checkCourse = true;
			}
		}
		return checkCourse;
	}
	
	public static void testCourse() {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		while(courseList.iterator().hasNext()) {
			System.out.println(courseList.iterator().next());
		}
		
	}
}
