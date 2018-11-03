package scrame;
import java.util.Scanner;

public class AddStudent {

	public static void run(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's Name"); //need to check validity
		String studentName = sc.nextLine();
		System.out.println("Enter Student's Matriculation Number"); //need to check validity
		String studentMatricNo = sc.nextLine();
		StudentManager.addStudent(studentName, studentMatricNo);
	}
}
