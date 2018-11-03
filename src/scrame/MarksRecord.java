package scrame;

import java.io.Serializable;

public class MarksRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	private String studentMatricNo;
	private double marks;
	
	public MarksRecord(String studentMatricNo, double marks) {
		this.studentMatricNo = studentMatricNo;
		this.marks = marks;
	}
	
	public double getMarks() {
		return marks;
	}
}
