package scrame;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {

	public static Scanner sc = new Scanner(System.in);

	private static final long serialVersionUID = 1L;
	
	private String courseName;
	private String courseCode;

	private String courseCoordinator;

	private int tutNumber;
	private int labNumber;

	ArrayList<Session> session;
	ArrayList<Components> components;
	
	public Course(String courseName, String courseCode, String courseCoordinator, ArrayList<Session> session, int tutNumber, int labNumber, ArrayList<Components> components) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseCoordinator = courseCoordinator;
		this.session = session;
		this.tutNumber = tutNumber;
		this.labNumber = labNumber;
		this.components = components;
	}

	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseCoordinator() {
		return courseCoordinator;
	}

	public int getTutNumber() {
		return tutNumber;
	}

	public int getLabNumber() {
		return labNumber;
	}

	public ArrayList<Session> getSession() {
		return session;
	}
	
	public ArrayList<Components> getComponents() {
		return components;
	}


}
