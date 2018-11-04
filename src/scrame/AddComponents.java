package scrame;

import java.util.ArrayList;

public class AddComponents {

	public static ArrayList<Components> add(int examPercent, int courseWorkPercent, int assignmentPercent,
			int classPartPercent) {
		ArrayList<Components> components = new ArrayList<>(3);
		
		Exam exam = new Exam(examPercent);
		components.add(exam);
		Assignment assignment = new Assignment(assignmentPercent*courseWorkPercent/100);
		components.add(assignment);
		ClassPart classPart = new ClassPart(classPartPercent*courseWorkPercent/100);
		components.add(classPart);

		return components;
	}
}
