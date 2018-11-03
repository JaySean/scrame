package scrame;
import java.util.Scanner;

public class EnterCourseworkMarks {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Name");
		String courseName = sc.nextLine();
		System.out.println("Enter Student Matric Number");
		String studentMatricNo = sc.nextLine();
		int assignmentMarks = 0;
		int classPartMarks = 0;
		if (CourseManager.getCourse(courseName).getComponents().get(1).getPercentage() != 0){
			System.out.println("Enter " + CourseManager.getCourse(courseName).getComponents().get(1).getType() + " Marks:");
			assignmentMarks = sc.nextInt();
		}
		if (CourseManager.getCourse(courseName).getComponents().get(2).getPercentage() != 0){
			System.out.println("Enter " + CourseManager.getCourse(courseName).getComponents().get(2).getType() + " Marks:");
			classPartMarks = sc.nextInt();
		}
		CourseManager.addCourseworkMarks(courseName, studentMatricNo, assignmentMarks, 1);
		CourseManager.addCourseworkMarks(courseName, studentMatricNo, classPartMarks, 2);
	}
}
