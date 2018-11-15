package scrame.student;

import scrame.Main;

import java.io.*;

public class StudentManager implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String studentFile = "data/Students.txt";

	public static boolean checkStudentExistence(String matricNo) {

		for (Student student : Main.studentList) {
			if (student.getStudentMatricNo().equals(matricNo)) return true;
		}
		return false;
	}
}
