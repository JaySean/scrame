package scrame;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {

	public static Scanner sc = new Scanner(System.in);

	private static final long serialVersionUID = 1L;
	private String courseName;
	private String courseCode;

	private String courseCoordinator;
	private int courseVacancy;

	private static int tutNumber;
	private static int labNumber;

	private static Session[] session;

	private Components[] components = new Components[3];

	public Course(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseCoordinator() {
		return courseCoordinator;
	}

	public static int getTutNumber() {
		return tutNumber;
	}

	public static int getLabNumber() {
		return labNumber;
	}

	public void addCoordinator() {
		System.out.println("Enter Course Coordinator");
		courseCoordinator = sc.nextLine();
	}

	public void addSession() {
		System.out.println("Enter Course Vacancy");
		courseVacancy = sc.nextInt();
		System.out.println("Enter Number of Tutorial Class");
		tutNumber = sc.nextInt();
		System.out.println("Enter Number of Laboratory Class");
		labNumber = sc.nextInt();
		session = new Session[1 + tutNumber + labNumber];
		session[0] = new Lecture(courseVacancy);
		for (int i = 1; i < 1 + tutNumber; i++) {
			session[i] = new Tutorial((int) (Math.ceil(courseVacancy / tutNumber)));
		}
		for (int j = tutNumber + 1; j < 1 + tutNumber + labNumber; j++) {
			session[j] = new Laboratory((int) (Math.ceil(courseVacancy / labNumber)));
		}
	}

	public void addComponents() {
		System.out.println("Weightage of Exam and Coursework:");
		System.out.println("Enter Exam Percentage:");
		int examPercent = sc.nextInt();
		if (examPercent != 0) {
			components[0] = new Exam(examPercent);
		}
		System.out.println("Enter Coursework Percentage:");
		int courseWorkPercent = sc.nextInt(); // check =100%
		if (courseWorkPercent != 0) {
			System.out.println("Weightage of Assignment and Class Participation in CourseWork");
			System.out.println("Enter Assignment Percentage:");
			int assignmentPercent = sc.nextInt();
			if (assignmentPercent != 0) {
				components[1] = new Assignment(assignmentPercent);
			}
			System.out.println("Enter Class Participation Percentage:");
			int classPartPercent = sc.nextInt();
			if (classPartPercent != 0) {
				components[2] = new ClassPart(classPartPercent);
			}
		}
	}

	public static void registerStudent(String student) {
		String enterCourse;
		int choice;
				
		// Select Lecture
		System.out.println("Select Lecture Session:");
		System.out.println("Lecture 1: " + session[1].getVacancy() + " vacancy");
		choice = sc.nextInt();
		session[0].setVacancy(session[0].getVacancy() - 1);
		
		// Select Tutorial
		System.out.println("Select Tutorial Session:");
		for (int i = 1; i < 1 + getTutNumber(); i++) {
			System.out.println("Tutorial " + i + ": " + session[i].getVacancy() + " vacancy");
		}
		choice = sc.nextInt();
		session[choice].setVacancy(session[choice].getVacancy() - 1); // set method for this
		session[choice].addStudent(student);
		
//		Select Laboratory
		System.out.println("Select Laboratory Session:");
		for (int j = 1 + getTutNumber(); j < 1 + getTutNumber() + getLabNumber(); j++) {
			System.out.println("Tutorial " + (j - getTutNumber()) + ": " + session[j].getVacancy() + " vacancy");
		}
		session[choice+getTutNumber()].setVacancy(session[choice+getTutNumber()].getVacancy() - 1);
		session[choice+getTutNumber()].addStudent(student);
		
		// Error handling: how to handle register for same course again? By course/lec/tut/lab?
	}

}
