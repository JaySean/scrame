package scrame;
import java.util.Scanner;

public class RegisterStudent {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		String registerCourseName;
		System.out.println("Enter Course Name");
		registerCourseName = sc.nextLine();
		if (CourseManager.checkCourse(registerCourseName) == false) {
			System.out.println("Invalid Course Name");
			//exception handling
		}
		int courseIndex = CourseManager.getCourseList().indexOf(registerCourseName);
		String registerStudentName;
		System.out.println("Enter Student Name");
		registerStudentName = sc.nextLine();
		if (StudentManager.checkStudent(registerStudentName) == false) {
			System.out.println("Invalid Student Name");
			//exception handling
		}
		
//		Student.registerCourse(registerCourseName);
//		Course course = CourseManager.getCourse(registerCourseName);
		CourseManager.registerStudent(registerCourseName, registerStudentName);
	}
}
