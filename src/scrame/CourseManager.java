package scrame;

import java.io.*;
import java.util.*;

public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static String courseFile = "data/Courses.txt";

	private static ArrayList<Course> courseList = DatabaseManager.read(courseFile);
	
	public static void addCourse(String courseName, String courseCode) {

		Course course = new Course(courseName, courseCode);
		course.addCoordinator();
		course.addSession();
		course.addComponents();
		getCourseList().add(course);
		DatabaseManager.write(getCourseList(), courseFile);

	}

	public static boolean checkCourse(String courseName) {
		boolean checkCourse = false;
		for (int i = 0; i < getCourseList().size(); i++) {
			Course c = getCourseList().get(i);
			if (c.getCourseName().equals(courseName)) {
				checkCourse = true;
			}
		}
		return checkCourse;
	}
	
	public static Course getCourse(String courseName) {
		Course c = null;
		for (int i = 0; i < getCourseList().size(); i++) {
			c = getCourseList().get(i);
			if (c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		return c;
	}

	public static ArrayList<Course> getCourseList() {
		return courseList;
	}

	public static void setCourseList(ArrayList<Course> courseList) {
		CourseManager.courseList = courseList;
	}

//	public static void testCourse() {
//		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
//		while(courseList.iterator().hasNext()) {
//			System.out.println(courseList.iterator().next());
//		}
//		
//	}
}
