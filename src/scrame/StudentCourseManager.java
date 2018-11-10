package scrame;

import java.util.ArrayList;

public class StudentCourseManager {
	
	final static String studentCourseFile = "data/StudentCourse.txt";
	
	public static int getIndex(String studentMatric, String courseCode) {
		for (int i = 0; i < Main.studentCourseList.size(); i++) {
			if (Main.studentCourseList.get(i).getStudentMatric().equals(studentMatric)) {
				if (Main.studentCourseList.get(i).getCourseCode().equals(courseCode)) {
					return i;
				}
			}
		}
		return -1;
	}
	public static StudentCourse createStudentCourse(String studentMatric, String courseCode) {
		StudentCourse studentCourse;
		
		int index = getIndex(studentMatric, courseCode);
				
		if (index == -1) {
			studentCourse = new StudentCourse(studentMatric, courseCode);
		}
		else {
			studentCourse = Main.studentCourseList.get(index);
		}
		
		return studentCourse;
	}
	
	public static void amendStudentCourse(StudentCourse studentCourse) {
		if (studentCourse == null) return;
		int index = getIndex(studentCourse.getStudentMatric(), studentCourse.getCourseCode());
		if (index == -1) {
			Main.studentCourseList.add(studentCourse);
		}
		else {
			Main.studentCourseList.set(index, studentCourse);
		}
		DatabaseManager.write(Main.studentCourseList, studentCourseFile);
	}
}
