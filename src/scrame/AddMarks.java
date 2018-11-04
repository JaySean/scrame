package scrame;

import java.util.ArrayList;

public class AddMarks {

	public static void add(Course course, String studentMatricNo, int marks, int assessmentType) {

		int courseIndex = CourseManager.getCourseIndex(course.getCourseCode());

		ArrayList<MarksRecord> marksRecord = course.getComponents().get(assessmentType).getRecord();
		MarksRecord marksEntry = new MarksRecord(studentMatricNo, marks);
		
		Components component = course.getComponents().get(assessmentType);
		
		if (component.getPercentage() != 0) {
			marksRecord.add(marksEntry);
			component.setRecord(marksRecord);
		}
		CourseManager.updateCourse(courseIndex, course);
	}
}
