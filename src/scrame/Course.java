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

	public boolean hasStudent(String matricNo) {
		try {
			 if (getLectures().get(0).hasStudent(matricNo)) return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean hasVacancy() {
		try {
			if (getLectures().size() > 0) {
				return getLectures().get(0).getVacancy() > 0;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public int getExamPercent() {
		if (components != null) return components.get(0).getPercentage();
		return 0;
	}

	public int getCourseWorkPercent() {
		if (components != null) return components.get(1).getPercentage() + components.get(1).getPercentage();
		return 0;
	}

	public int getAssignmentPercent() {
		if (components != null) return components.get(1).getPercentage();
		return 0;
	}

	public int getClassPartPercent() {
		if (components != null) return components.get(2).getPercentage();
		return 0;
	}

	public ArrayList<Tutorial> getTutorials() {
		ArrayList<Tutorial> tutorials = new ArrayList<>(0);
		if (session != null) {
			for (Session aSession : session) {
				if (aSession instanceof Tutorial) tutorials.add((Tutorial) aSession);
			}
		}
		return tutorials;
	}

	public ArrayList<Lecture> getLectures() {
		ArrayList<Lecture> lectures = new ArrayList<>(0);
		if (session != null) {
			for (Session aSession : session) {
				if (aSession instanceof Lecture) lectures.add((Lecture) aSession);
			}
		}
		return lectures;
	}

	public ArrayList<Laboratory> getLaboratories() {
		ArrayList<Laboratory> labs = new ArrayList<>(0);
		if (session != null) {
			for (Session aSession : session) {
				if (aSession instanceof Laboratory) labs.add((Laboratory) aSession);
			}
		}
		return labs;
	}

}
