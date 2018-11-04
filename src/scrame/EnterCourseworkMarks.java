package scrame;
import java.util.Scanner;

public class EnterCourseworkMarks {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Code");
		String courseCode = sc.nextLine();
		System.out.println("Enter Student Matriculation Number");
		String studentMatric = sc.nextLine();
		
		int assignmentMarks = 0;
		int classPartMarks = 0;
		
		Course course = CourseManager.getCourse(courseCode);
		int courseIndex = CourseManager.getCourseIndex(courseCode);
		
		// Enter Assignment Marks
		Components assignmentComponent = course.getComponents().get(1);
		if (assignmentComponent.getPercentage() != 0){
			System.out.println("Enter " + assignmentComponent.getType() + " Marks:");
			assignmentMarks = sc.nextInt(); // check mark range
		}
		
		// Enter Class Part Marks
		Components classPartComponent = course.getComponents().get(2);
		if (classPartComponent.getPercentage() != 0){
			System.out.println("Enter " + classPartComponent.getType() + " Marks:");
			classPartMarks = sc.nextInt(); // check mark range
		}
		
		AddMarks.add(course, studentMatric, assignmentMarks, 1);
		AddMarks.add(course, studentMatric, assignmentMarks, 2);
	}
}
