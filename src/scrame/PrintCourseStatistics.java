package scrame;

import java.util.Scanner;

public class PrintCourseStatistics {

	public static void run() {
		System.out.println("Enter Course COde");
		Scanner sc = new Scanner(System.in);
		String courseCode = sc.nextLine();
		
		Course course = CourseManager.getCourse(courseCode);
		
		int examPercentage = course.getComponents().get(0).getPercentage();
		int assignmentPercentage = course.getComponents().get(1).getPercentage();
		int classPartPercentage = course.getComponents().get(2).getPercentage();
		
		
	}
}
