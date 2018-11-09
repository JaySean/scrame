package scrame;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCourse {
	
	private final static String courseFile = "data/Courses.txt";

	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		//read file to array
		ArrayList<Course> courseList = DatabaseManager.read(courseFile);

		String courseName = getCourseName(sc);
		String courseCode = getCourseCode(sc);
		String courseCoordinator = getCourseCoordinator(sc);
		int courseCapacity = getCourseCapacity(sc);
		int tutNumber = getTutNumber(sc);
		int labNumber = getLabNumber(sc);
		System.out.println("Exam and Coursework Weightage:");
		int examPercent = getExamPercent(sc);
		int courseWorkPercent = getCourseWorkPercent(sc);

		int assignmentPercent = 0;
		int classPartPercent = 0;
		if (courseWorkPercent != 0) {
			System.out.println("Assignment and Class Participation Weightage:");
			assignmentPercent = getAssignmentPercent(sc);
			classPartPercent = getClassPartPercent(sc);
		}

		// Create sessions
		ArrayList<Session> session = AddSession.add(courseCapacity, tutNumber, labNumber);
		// Create components
		ArrayList<Components> components = AddComponents.add(examPercent, courseWorkPercent, assignmentPercent,
				classPartPercent);
		// Create new instance of course
		Course course = new Course(courseName, courseCode, courseCoordinator, session, tutNumber, labNumber,
				components);
		// Add course to array
		courseList.add(course);
		
		// Print list of ALL courses
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println(courseList.get(i).getCourseName() + " " + courseList.get(i).getCourseCode() + " "
					+ courseList.get(i).getCourseCoordinator());
		}

		// Write array to file
		DatabaseManager.write(courseList, courseFile);
	}

	//methods to process inputs
	private static String getCourseName(Scanner sc) {
		String courseName;
		while (true) {
			try {
				System.out.println("Enter Course Name");
				courseName = sc.nextLine();
				FormatValidator.validateName(courseName);
				return courseName;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static String getCourseCode(Scanner sc) {
		String courseCode;
		while (true) {
			try {
				System.out.println("Enter Course Code"); // need to check validity: of format e.g. CZ2002; check for repeated course
				courseCode = sc.nextLine();
				validateNewCourseCode(courseCode);
				return courseCode;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static String getCourseCoordinator(Scanner sc) {
		String courseCoordinator;
		while (true) {
			try {
				System.out.println("Enter Course Coordinator"); // need to check validity: only alphabets
				courseCoordinator = sc.nextLine();
				FormatValidator.validateName(courseCoordinator);
				return courseCoordinator;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getCourseCapacity(Scanner sc) {
		int courseCapacity;
		while (true) {
			try {
				System.out.println("Enter Course Capacity"); // need to check validity: only integer
				courseCapacity = sc.nextInt();
				return courseCapacity;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getTutNumber(Scanner sc) {
		int tutNumber;
		while (true) {
			try {
				System.out.println("Enter Number of Tutorial Class"); // need to check validity: only integer
				tutNumber = sc.nextInt();
				return tutNumber;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getLabNumber(Scanner sc) {
		int labNumber;
		while (true) {
			try {
				System.out.println("Enter Number of Laboratory Class"); // need to check validity: only integer
				labNumber = sc.nextInt();
				return labNumber;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getExamPercent(Scanner sc) {
		int examPercent;
		while (true) {
			try {
				System.out.println("Enter Exam Percentage:"); // need to check validity: only integer, between  0-100
				examPercent = sc.nextInt();
				validatePercentage(examPercent);
				return examPercent;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getCourseWorkPercent(Scanner sc) {
		int courseWorkPercent;
		while (true) {
			try {
				System.out.println("Enter Coursework Percentage:"); // need to check validity: only integer, between  0-100
				courseWorkPercent = sc.nextInt(); // check = 100%
				validatePercentage(courseWorkPercent);
				return courseWorkPercent;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getAssignmentPercent(Scanner sc) {
		int assignmentPercent;
		while (true) {
			try {
				System.out.println("Enter Assignment Percentage:"); // need to check validity: only integer, between  0-100
				assignmentPercent = sc.nextInt();
				validatePercentage(assignmentPercent);
				return assignmentPercent;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static int getClassPartPercent(Scanner sc) {
		int classPartPercent;
		while (true) {
			try {
				System.out.println("Enter Class Participation Percentage:"); // need to check validity: only integer, between  0-100
				classPartPercent = sc.nextInt(); // check = 100%
				validatePercentage(classPartPercent);
				return classPartPercent;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	//utility methods
	private static void validateNewCourseCode(String newCourseCode) throws Exception{
		//check for format
		FormatValidator.validateCourseCode(newCourseCode);
		//check for existence
		boolean exists = CourseManager.checkCourseExistence(newCourseCode);
		if (!exists) throw new Exception("Course already exists!");
	}
	private static void validatePercentage(int percentage) throws Exception{
		if (percentage > 100 || percentage < 0) throw new Exception("A percentage must be between 1-100");
	}
}
