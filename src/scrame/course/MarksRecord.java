package scrame.course;

import java.io.Serializable;

public class MarksRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	private String studentMatric; // remove
	private double marks;
	
	public MarksRecord(String studentMatric, double marks) {
		this.studentMatric = studentMatric;
		this.marks = marks;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public String getStudentMatric() {
		return studentMatric;
	}
}
