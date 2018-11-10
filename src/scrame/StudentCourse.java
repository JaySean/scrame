package scrame;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentCourse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String studentMatric;
	private String courseCode;
//	private ArrayList<MarksRecord> marksRecord;
	private int[] marksRecord;
	
	public StudentCourse(String studentMatric, String courseCode) {
		this.studentMatric = studentMatric;
		this.courseCode = courseCode;
		this.marksRecord = new int[3];
	}
	
	public String getStudentMatric() {
		return studentMatric;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public int[] getMarksRecord() {
		return marksRecord;
	}
	
	public void setMarksRecord(int i, int marks) {
		marksRecord[i] = marks;
	}
}
