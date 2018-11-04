package scrame;
import java.util.ArrayList;
import java.util.Scanner;

public class AddStudent {
	
	public static final String studentFile = "data/Students.txt";

	public static void run(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student's Name"); //need to check validity
		String studentName = sc.nextLine();
		System.out.println("Enter Student's Matriculation Number"); //need to check validity
		String studentMatricNo = sc.nextLine();
		
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
}
