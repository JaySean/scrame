package scrame;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = -1;		
		do {
			showMenu();
			input = sc.nextInt();
			sc.nextLine();
			switch(input) {
			case 1:
				System.out.println("Enter Student's Name"); //need to check validity
				String studentName = sc.nextLine();
				System.out.println("Enter Student's Matriculation Number"); //need to check validity
				String studentMatricNo = sc.nextLine();
				StudentManager.addStudent(studentName, studentMatricNo);
				break;
			case 2:
				System.out.println("Enter Course Name"); //need to check validity
				String courseName = sc.nextLine();
				System.out.println("Enter Course Code"); //need to check validity
				String courseCode = sc.nextLine();
				CourseManager.addCourse(courseName, courseCode);
				break;
			case 3:
				String registerCourseName;
				do {
					System.out.println("Enter Course Name");
					registerCourseName = sc.nextLine();
				}
				while (CourseManager.checkCourse(registerCourseName) == false);
				String registerStudentName;
				do {
					System.out.println("Enter Student Name");
					registerStudentName = sc.nextLine();
				}
				while (StudentManager.checkStudent(registerStudentName) == false);
//				Student.registerCourse(registerCourseName);
//				Course.registerStudent(registerStudentName);
				
			default:
				break;
			}				
		}
		while (input != 11);

	}
	
	public static void showMenu() {
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Register student for a course");
		System.out.println("4: Check available slot in a class");
		System.out.println("5: Print student list by lecture, tutorial or laboratory session for a course");
		System.out.println("6: Enter course assessment components weightage");
		System.out.println("7: Enter coursework mark – inclusive of its components");
		System.out.println("8: Enter exam mark");
		System.out.println("9: Print course statistics");
		System.out.println("10: Print student transcript");
		System.out.println("11: Quit");
	}

}
