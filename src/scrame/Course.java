package scrame;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseName;
	private String courseCode;
	private String courseCoordinator;
	private int courseVacancy;
//	private boolean courseTut;
//	private boolean courseLab;
//	private int lecVacancy;
	private int tutVacancy;
	private int labVacancy;
	private ArrayList<Tutorial> courseTut;
	private ArrayList<Laboratory> courseLab;
	private CourseSession courseSession;
	private ArrayList<Student> studentsInCourse;

	public Course(String courseName, String courseCode) {
		this.courseName = courseName;
		this.courseCode = courseCode;
	}

	public Course(String courseName, String courseCode, String courseCoordinator, int courseVacancy, int tutVacancy, int labVacancy) {
		super();
		this.courseCoordinator = courseCoordinator;
		this.courseVacancy = courseVacancy;
		// lec vacancy
		this.tutVacancy = tutVacancy;
		this.labVacancy = labVacancy;
	}

	public void addCoordinator() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Coordinator");
		courseCoordinator = sc.nextLine();
	}

	public void addVacancy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Vacancy");
		courseVacancy = sc.nextInt();
		System.out.println("Enter Size of Tutorial Class");
		tutVacancy = sc.nextInt();
		System.out.println("Enter Size of Laboratory Class");
		labVacancy = sc.nextInt();
	}

	public void addSession() {
//		Scanner sc = new Scanner(System.in);
//		char input;
//		System.out.println("Tutorial? (Y/N)");
//		input = sc.next().charAt(0);
//		switch (input) {
//		case 'Y': case 'y':
//			courseTut = true;
//		}
//		System.out.println("Laboratory? (Y/N)");
//		input = sc.next().charAt(0);
//		switch (input) {
//		case 'Y': case 'y':
//			courseLab = true;
//		}
//		CourseSession courseSession = new CourseSession(courseTut, courseLab);
	}
	
	public void createTut(int tutVacancy) {
		int noOfClass = (int) Math.ceil(courseVacancy%tutVacancy);
		ArrayList<Tutorial> courseTut = new ArrayList<Tutorial>();
		for (int i=0; i<noOfClass; i++) {
			Tutorial "[i]" = new Tutorial
		}
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void registerStudent(Student s) {
		studentsInCourse.add(e)
	}
	

}
