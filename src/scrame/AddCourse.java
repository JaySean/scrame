package scrame;

import com.mitchtalmadge.asciidata.table.ASCIITable;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCourse {

	final static String courseFile = "data/Courses.txt";

	public static void run() {
		Scanner sc = new Scanner(System.in);
		boolean repeat;

		// read file to array
//		ArrayList<Course> courseList = DatabaseManager.read(courseFile);

		String courseName = getCourseName(sc);
		String courseCode = getCourseCode(sc);
		String courseCoordinator = getCourseCoordinator(sc);
		int courseCapacity = getCourseCapacity(sc);
		int tutNumber = getTutNumber(sc);
		int labNumber = getLabNumber(sc);

		// Get exam and coursework percentages
		int examPercent = 0;
		int courseWorkPercent = 0;
		repeat = true;
		while (repeat) {
			try {
				System.out.println("Exam and Coursework Weights:");
				examPercent = getExamPercent(sc);
				courseWorkPercent = getCourseWorkPercent(sc);
				if (examPercent + courseWorkPercent != 100)
					throw new Exception("Exam and Course Work percentages must total 100");
				repeat = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// Get assignment and class participation percentages
		int assignmentPercent = 0;
		int classPartPercent = 0;
		if (courseWorkPercent != 0) {
			repeat = true;
			while (repeat) {
				try {
					System.out.println("Assignment and Class Participation Weights:");
					assignmentPercent = getAssignmentPercent(sc);
					classPartPercent = getClassPartPercent(sc);
					if (assignmentPercent + classPartPercent != 100)
						throw new Exception("Assignment and Class Participation percentage must total 100");
					repeat = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		// Create new instance of course
		Course course = new Course(courseName, courseCode, courseCoordinator, courseCapacity, tutNumber, labNumber,
				examPercent, courseWorkPercent, assignmentPercent, classPartPercent);
		// Add course to array
		Main.courseList.add(course);

		// Print list of ALL courses
//		System.out.println("Course Name / Code / Course Coordinator");
//		System.out.println("----------------------------------------------");
//		for (int i = 0; i < Main.courseList.size(); i++) {
//			System.out.println(
//				Main.courseList.get(i).getCourseName() + " / " +
//				Main.courseList.get(i).getCourseCode() + " / " +
//				Main.courseList.get(i).getCourseCoordinator());
//		}

		String[] headers = new String[]{"No.", "Course Name", "Course Code", "Course Coordinator"};

		int numberOfCourses = Main.courseList.size();
		String[][] data = new String[numberOfCourses][4];

		for (int i = 0; i < numberOfCourses; i++) {
			data[i][0] = Integer.toString(i + 1);
			data[i][1] = Main.courseList.get(i).getCourseName();
			data[i][2] = Main.courseList.get(i).getCourseCode();
			data[i][3] = Main.courseList.get(i).getCourseCoordinator();
		}
		System.out.println(ASCIITable.fromData(headers, data).toString());

		// Write array to file
		DatabaseManager.write(Main.courseList, courseFile);
	}

	// methods to process inputs
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
				System.out.println("Enter Course Code");
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
				System.out.println("Enter Course Coordinator");
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
				System.out.println("Enter Course Capacity");
				courseCapacity = sc.nextInt();
				sc.nextLine();
				return courseCapacity;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getTutNumber(Scanner sc) {
		int tutNumber;
		while (true) {
			try {
				System.out.println("Enter Number of Tutorial Class");
				tutNumber = sc.nextInt();
				if (tutNumber < 1)
					throw new Exception("There must be at least 1 tutorial!");
				sc.nextLine();
				return tutNumber;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getLabNumber(Scanner sc) {
		int labNumber;
		while (true) {
			try {
				System.out.println("Enter Number of Laboratory Class");
				labNumber = sc.nextInt();
				if (labNumber < 1)
					throw new Exception("There must be at least 1 lab component!");
				sc.nextLine();
				return labNumber;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getExamPercent(Scanner sc) {
		int examPercent;
		while (true) {
			try {
				System.out.println("Enter Exam Percentage:");
				examPercent = sc.nextInt();
				validatePercentage(examPercent);
				sc.nextLine();
				return examPercent;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getCourseWorkPercent(Scanner sc) {
		int courseWorkPercent;
		while (true) {
			try {
				System.out.println("Enter Coursework Percentage:");
				courseWorkPercent = sc.nextInt();
				validatePercentage(courseWorkPercent);
				sc.nextLine();
				return courseWorkPercent;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getAssignmentPercent(Scanner sc) {
		int assignmentPercent;
		while (true) {
			try {
				System.out.println("Enter Assignment Percentage:");
				assignmentPercent = sc.nextInt();
				validatePercentage(assignmentPercent);
				sc.nextLine();
				return assignmentPercent;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	private static int getClassPartPercent(Scanner sc) {
		int classPartPercent;
		while (true) {
			try {
				System.out.println("Enter Class Participation Percentage:");
				classPartPercent = sc.nextInt();
				validatePercentage(classPartPercent);
				sc.nextLine();
				return classPartPercent;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
		}
	}

	// Utility methods
	private static void validateNewCourseCode(String newCourseCode) throws Exception {
		// Check for format
		FormatValidator.validateCourseCode(newCourseCode);
		// Check for existence
		boolean exists = CourseManager.checkCourseExistence(newCourseCode);
		if (exists)
			throw new Exception("Course already exists!");
	}

	private static void validatePercentage(int percentage) throws Exception {
		if (percentage > 100 || percentage < 0)
			throw new Exception("A percentage must be between 1-100");
	}
}
