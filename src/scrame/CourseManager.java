package scrame;

import java.io.*;
import java.util.*;

public class CourseManager implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Scanner sc = new Scanner(System.in);

	private final static String courseFile = "data/Courses.txt";

//	private static ArrayList<Course> courseList = DatabaseManager.read(courseFile);

	public static void addCourse(String courseName, String courseCode, String courseCoordinator, int courseCapacity,
			int tutNumber, int labNumber, int examPercent, int courseWorkPercent, int assignmentPercent,
			int classPartPercent) {

//		Session[] session = addSession(courseCapacity, tutNumber, labNumber);
		ArrayList<Session> session = addSession(courseCapacity, tutNumber, labNumber);
		ArrayList<Components> components = addComponents(examPercent, courseWorkPercent, assignmentPercent,
				classPartPercent);
		Course course = new Course(courseName, courseCode, courseCoordinator, session, tutNumber, labNumber,
				components);
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		courseList.add(course);
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println(courseList.get(i).getCourseName() + " " + courseList.get(i).getCourseCode() + " "
					+ courseList.get(i).getCourseCoordinator());
		}
		DatabaseManager.write(courseList, courseFile);

	}

	public static boolean checkCourse(String courseName) {
		boolean checkCourse = false;
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getCourseName().equals(courseName)) {
				checkCourse = true;
			}
		}
		return checkCourse;
	}

	public static Course getCourse(String courseName) {
		Course c = null;
		for (int i = 0; i < getCourseList().size(); i++) {
			c = getCourseList().get(i);
			if (c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		return c;
	}

	public static int getCourseIndex(String courseName) {
		Course c = null;
		for (int i = 0; i < getCourseList().size(); i++) {
			c = getCourseList().get(i);
			if (c.getCourseName().equals(courseName)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<Course> getCourseList() {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		return courseList;
	}

//	public static Session[] addSession(int courseVacancy, int tutNumber, int labNumber) {
//
//		Session[] session = new Session[1 + tutNumber + labNumber];
//		session[0] = new Lecture(courseVacancy);
//		for (int i = 1; i < 1 + tutNumber; i++) {
//			session[i] = new Tutorial((int) (Math.ceil(courseVacancy / tutNumber)));
//		}
//		for (int j = tutNumber + 1; j < 1 + tutNumber + labNumber; j++) {
//			session[j] = new Laboratory((int) (Math.ceil(courseVacancy / labNumber)));
//		}
//		return session;
//	}

	public static ArrayList<Session> addSession(int courseVacancy, int tutNumber, int labNumber) {

		ArrayList<Session> session = new ArrayList<>(1 + tutNumber + labNumber);
		Session lecture = new Lecture(courseVacancy);
		session.add(lecture);

		for (int i = 1; i < 1 + tutNumber; i++) {
			session.add(new Tutorial((int) (Math.ceil(courseVacancy / tutNumber))));
		}

		for (int i = 1; i < 1 + labNumber; i++) {
			session.add(new Laboratory((int) (Math.ceil(courseVacancy / labNumber))));
		}

		return session;
	}

	public static ArrayList<Components> addComponents(int examPercent, int courseWorkPercent, int assignmentPercent,
			int classPartPercent) {
		ArrayList<Components> components = new ArrayList<>(3);

		if (examPercent != 0) {
			Exam exam = new Exam(examPercent);
			components.add(exam);
		}
		if (courseWorkPercent != 0) {
			if (assignmentPercent != 0) {
				Assignment assignemnt = new Assignment(assignmentPercent);
				components.add(assignemnt);
			}
			if (classPartPercent != 0) {
				ClassPart classPart = new ClassPart(classPartPercent);
				components.add(classPart);
			}
		}

		return components;
	}

	public static void registerStudent(String courseName, String studentName) {
//		String enterCourse;
		int choice;

		Course course = CourseManager.getCourse(courseName);
		int courseIndex = CourseManager.getCourseIndex(courseName);

		// Select Lecture
		System.out.println("Select Lecture Session:");
		System.out.println("Lecture 1: " + course.getSession().get(0).getVacancy() + " vacancy");
		choice = sc.nextInt() - 1;
		
		int lecCapacity = course.getSession().get(choice).getCapacity();
		int lecVacancy = course.getSession().get(choice).getVacancy();
		
		String[] lecList = course.getSession().get(choice).getStudentList();
		lecList[lecCapacity - lecVacancy] = studentName;
		course.getSession().get(choice).setStudentList(lecList);
		course.getSession().get(choice).setVacancy(lecVacancy - 1);

		// Select Tutorial
		System.out.println("Select Tutorial Session:");
		for (int i = 1; i < 1 + course.getTutNumber(); i++) {
			System.out.println("Tutorial " + i + ": " + course.getSession().get(i).getVacancy() + " vacancy");
		}
		choice = sc.nextInt();

		int tutCapacity = course.getSession().get(choice).getCapacity();
		int tutVacancy = course.getSession().get(choice).getVacancy();

		String[] tutList = course.getSession().get(choice).getStudentList();
		tutList[tutCapacity - tutVacancy] = studentName;
		course.getSession().get(choice).setStudentList(tutList);
		course.getSession().get(choice).setVacancy(tutVacancy - 1);

		// Select Laboratory
		System.out.println("Select Laboratory Session:");
		for (int j = 1 + course.getTutNumber(); j < 1 + course.getTutNumber() + course.getLabNumber(); j++) {
			System.out.println("Laboratory " + (j - course.getTutNumber()) + ": " + course.session.get(j).getVacancy()
					+ " vacancy");
		}
		choice = sc.nextInt() + course.getTutNumber();
		int labCapacity = course.getSession().get(choice).getCapacity();
		int labVacancy = course.getSession().get(choice).getVacancy();

		String[] labList = course.getSession().get(choice).getStudentList();
		labList[labCapacity - labVacancy] = studentName;
		course.getSession().get(choice).setStudentList(labList);
		course.getSession().get(choice).setVacancy(labVacancy - 1);

		updateCourse(courseIndex, course);

		// Error handling: how to handle registering for same course again? By
		// course/lec/tut/lab?
	}

	public static void addCourseworkMarks(String courseName, String studentMatricNo, int marks, int type) {
//		ArrayList<MarksRecord> marksRecord = new ArrayList<>();
		Course course = CourseManager.getCourse(courseName);
		int courseIndex = CourseManager.getCourseIndex(courseName);

		ArrayList<MarksRecord> marksRecord = course.getComponents().get(type).getRecord();
		MarksRecord marksEntry = new MarksRecord(studentMatricNo, marks);
		if (course.getComponents().get(type).getPercentage() != 0) {
			marksRecord.add(marksEntry);
			course.getComponents().get(type).setRecord(marksRecord);
		}
		updateCourse(courseIndex, course);
	}

	public static void updateCourse(int courseIndex, Course c) {
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);
		courseList.set(courseIndex, c);
		DatabaseManager.write(courseList, courseFile);
	}

}
