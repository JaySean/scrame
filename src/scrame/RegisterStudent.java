package scrame;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisterStudent {

	public static void run() {
		Scanner sc = new Scanner(System.in);

		String courseCode = getCourseCode(sc);

		Course course = CourseManager.getCourse(courseCode);
		String studentMatric = getStudentMatric(sc,course);

		// Select Lecture
		registerLecture(sc, studentMatric, course);
		// Select Tutorial
		registerTutorial(sc, studentMatric,course );
		// Select Laboratory
		registerLaboratory(sc, studentMatric, course);
		//amend course in persistent memory
		CourseManager.amendCourse(course);
	}

	private static String getCourseCode(Scanner sc) {
		try {
			System.out.println("Enter Course Code");
			String courseCode = sc.nextLine();
			//check format
			FormatValidator.validateCourseCode(courseCode);
			//check existence
			boolean exist = CourseManager.checkCourseExistence(courseCode);
			if (!exist) throw new Exception("Course does not exist!");
			//check vacancy
			if (!CourseManager.getCourse(courseCode).hasVacancy()) throw new Exception("There are no vacancies left in this course!");
			return courseCode;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getCourseCode(sc);
		}
	}
	private static String getStudentMatric(Scanner sc, Course course) {
		try {
			System.out.println("Enter Student Matriculation Number"); // check validity: whether student exits
			String studentMatric = sc.nextLine();
			//check format
			FormatValidator.validateMatricNo(studentMatric);
			//check existence
			boolean exist = StudentManager.checkStudentExistence(studentMatric);
			if (!exist) throw new Exception("Student does not exist!");
			//check if already in course
			if (course.hasStudent(studentMatric)) throw new Exception("Student is already registered for this course!");
			return studentMatric;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getStudentMatric(sc,course);
		}
	}
	private static void registerLecture(Scanner sc, String matricNumber, Course course) {
		if (course == null) return;
		ArrayList<Lecture> lectures = course.getLectures();
		int index = 1;
		try {
			System.out.println("Select Lecture Session:");
			//print lectures
			for (Lecture lecture : lectures) {
				System.out.println("Lecture " + index + ": " + lecture.getVacancy() + " vacancies");
				index++;
			}
			int choice = sc.nextInt();
			//check choice validity
			if (choice > lectures.size() || choice < 1) throw new Exception("No such lecture!");
			sc.nextLine();
			//add student to course
			lectures.get(choice - 1).addStudent(matricNumber);
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			registerLecture(sc, matricNumber, course);
		}
	}
	private static void registerTutorial(Scanner sc, String matricNumber, Course course) {
		if (course == null) return;
		ArrayList<Tutorial> tutorials = course.getTutorials();
		int index = 1;
		try {
			System.out.println("Select Tutorial Session:");
			//print lectures
			for (Tutorial tutorial : tutorials) {
				System.out.println("Tutorial " + index + ": " + tutorial.getVacancy() + " vacancies");
				index++;
			}
			int choice = sc.nextInt();
			//check choice validity
			if (choice > tutorials.size() || choice < 1) throw new Exception("No such tutorial!");
			sc.nextLine();
			//add student to course
			tutorials.get(choice - 1).addStudent(matricNumber);
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			registerTutorial(sc, matricNumber, course);
		}
	}
	private static void registerLaboratory(Scanner sc, String matricNumber, Course course) {
		if (course == null) return;
		ArrayList<Laboratory> laboratories = course.getLaboratories();
		int index = 1;
		try {
			System.out.println("Select Laboratory Session:");
			//print lectures
			for (Laboratory laboratory : laboratories) {
				System.out.println("Lab " + index + ": " + laboratory.getVacancy() + " vacancies");
				index++;
			}
			int choice = sc.nextInt();
			//check choice validity
			if (choice > laboratories.size() || choice < 1) throw new Exception("No such laboratory!");
			sc.nextLine();
			//add student to course
			laboratories.get(choice - 1).addStudent(matricNumber);
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			registerLaboratory(sc, matricNumber, course);
		}
	}
}

