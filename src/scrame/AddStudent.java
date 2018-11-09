package scrame;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Scanner;

public class AddStudent {
	
	private static final String studentFile = "data/Students.txt";

	public static void run(){
		Scanner sc = new Scanner(System.in);
		boolean correctInput;

		//enter student name
		String studentName = "";
		correctInput = false;
		while (!correctInput) {
			try {
				System.out.println("Enter Student's Name");
				studentName = sc.nextLine();
				correctInput = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//enter matriculation no.
		String studentMatricNo = "";
		correctInput = false;
		while (!correctInput) {
			try {
				System.out.println("Enter Student's Matriculation Number");
				studentMatricNo = sc.nextLine();
				validateNewStudentMatricNo(studentMatricNo);
				correctInput = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// New instance of Student
		Student student = new Student(studentName, studentMatricNo);
		// Read file to array
		ArrayList<Student> studentList = DatabaseManager.read(studentFile);
		// Add instance of student to array
		studentList.add(student);

		// Print list of ALL students
		System.out.println("Name / Matriculation Number");
		System.out.println("---------------------------");
		for (int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getStudentName() + " / " + studentList.get(i).getStudentMatricNo());
		}
		
		// Write array to file
		DatabaseManager.write(studentList, studentFile);
	}

	private static void validateNewStudentMatricNo(String studentMatricNo) throws Exception {
		String matricFormat = "[A-Z][0-9]{7}[A-Z]";
		//validate format
		if (!studentMatricNo.matches(matricFormat)) {
			throw new Exception("Student matriculation number format incorrect - must begin and end with capital letters and have 7 digits in between");
		}
		//validate existence
		ArrayList<Student> studentList = DatabaseManager.read(studentFile);
		for (Student student : studentList) {
			if (student.getStudentMatricNo().equals(studentMatricNo)) {
				throw new Exception("Student already exists!");
			}
		}
	}
}
