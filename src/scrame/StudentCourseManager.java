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
	public static StudentCourse getStudentCourse(String matricNumber) {
		ArrayList<StudentCourse> studentCourseList = DatabaseManager.read(studentCourseFile);
		for (StudentCourse studentCourse : studentCourseList) {
			if (studentCourse.getStudentMatric().equals(matricNumber)) return studentCourse;
		}
		return null;
	}
	public static ArrayList<StudentCourse> getStudentsCourseByCourseCode(String courseCode) {
		ArrayList<StudentCourse> studentCourseList = DatabaseManager.read(studentCourseFile);
		ArrayList<StudentCourse> studentCourseListByCourse  = new ArrayList<>(0);
		for (StudentCourse studentCourse : studentCourseList) {
			if (studentCourse.getCourseCode().equals(courseCode)) {
				studentCourseListByCourse.add(studentCourse);
			}
		}
		return studentCourseListByCourse;
	}
	public static double getAverageExamForCourse(String courseCode) {
		ArrayList<StudentCourse> studentCourseList = getStudentsCourseByCourseCode(courseCode);
		int totalMarks = 0;
		for (StudentCourse studentCourse : studentCourseList) {
			totalMarks += studentCourse.getExamMarks();
		}
		return (double) totalMarks/studentCourseList.size();
	}
	public static double getAverageAssignmentForCourse(String courseCode) {
		ArrayList<StudentCourse> studentCourseList = getStudentsCourseByCourseCode(courseCode);
		int totalMarks = 0;
		for (StudentCourse studentCourse : studentCourseList) {
			totalMarks += studentCourse.getAssignmentMarks();
		}
		return (double) totalMarks/studentCourseList.size();
	}
	public static double getAverageClassPartForCourse(String courseCode) {
		ArrayList<StudentCourse> studentCourseList = getStudentsCourseByCourseCode(courseCode);
		int totalMarks = 0;
		for (StudentCourse studentCourse : studentCourseList) {
			totalMarks += studentCourse.getClassPartMarks();
		}
		return (double) totalMarks/studentCourseList.size();
	}
}
