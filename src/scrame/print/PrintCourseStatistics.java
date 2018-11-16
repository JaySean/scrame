package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.Input;
import scrame.StudentCourseManager;

/**
 * Calculates and prints the mean grade percentage
 * Prints by overall (exam + coursework), exam only and coursework only
 *
 * @author CZ2002 SS3 Group 1
 * @version 4.0
 */
public class PrintCourseStatistics {
	/**
	 * Main method of the PrintCourseStatistics function
	 */
	public static void run() {

		String courseCode = Input.getCourseCode();

		Course course = CourseManager.getCourse(courseCode);

		String[] headers = new String[]{"Component", "Average Grade"};
		String[][] data = new String[3][2];

		int i = 0;

		// Show exam only
		int examPercentage = course.getExamComponent().getPercentage();
		double examGrade = StudentCourseManager.getAveExamMarks(courseCode);
		data[i][0] = "Exam (" + examPercentage + "%)";
		data[i][1] = Double.toString(examGrade);
		i++;

		// Show coursework only
		double courseworkGrade = 0;
		int courseworkPercentage = 0;
		if (course.hasClassPart() || course.hasAssignment()) {
			int assignmentPercentage = course.getAssignmentComponent().getPercentage();
			int classPartPercentage = course.getClassPartComponent().getPercentage();
			courseworkPercentage = assignmentPercentage + classPartPercentage;

			double aveAssignmentMarks = StudentCourseManager.getAveAssignmentMarks(courseCode);
			double aveClassPartMarks = StudentCourseManager.getAveClassPartMarks(courseCode);
			double assignmentGrade = (double) assignmentPercentage * aveAssignmentMarks / courseworkPercentage;
			double classPartGrade = (double) classPartPercentage * aveClassPartMarks / courseworkPercentage;
			courseworkGrade = assignmentGrade + classPartGrade;

			data[i][0] = "Coursework (" + (100 - examPercentage) + "%)";
			data[i][1] = Double.toString(courseworkGrade);
			i++;
		}

		// Show overall
		double gradePercentage =
				((examGrade * examPercentage) / 100) +
				((courseworkGrade * courseworkPercentage) / 100);
		data[i][0] = "Overall (100%)";
		data[i][1] = Double.toString(gradePercentage);

		// Ouput data
		System.out.println(ASCIITable.fromData(headers, data).toString());
	}
}
