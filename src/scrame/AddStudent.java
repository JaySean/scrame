package scrame;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Scanner;

public class AddStudent {
	
	private static final String studentFile = "data/Students.txt";

	public static void run(){
		Scanner sc = new Scanner(System.in);
		String studentName = "";
		String studentMatricNo = "";
		boolean correct;

		//enter student name
		correct = false;
		while (!correct) {
			try {
				System.out.println("Enter Student's Name");
				studentName = sc.nextLine();
				FormatValidator.validateName(studentName);
				correct = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		//enter matriculation no.
		correct = false;
		while (!correct) {
			try {
				System.out.println("Enter Student's Matriculation Number");
				studentMatricNo = sc.nextLine();
				validateNewStudentMatricNo(studentMatricNo);
				correct = true;
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

	private static void validateNewStudentMatricNo(String newStudentMatricNo) throws Exception {
		//validate format
		FormatValidator.validateMatricNo(newStudentMatricNo);
		//validate existence
		boolean exists = StudentManager.checkStudentExistence(newStudentMatricNo);
		if (exists) throw new Exception("Student already exists!");
	}
}
