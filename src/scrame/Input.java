package scrame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Takes in user's inputs for the various functions
 * Validates the input according to the respective requirements
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class Input {

    static Scanner sc = new Scanner(System.in);

    // Student

    /**
     * @return Validated user's input of the student's name
     */
    public static String getStudentName() {
        String studentName;
        while (true) {
            try {
                System.out.println("Enter Student's Name");
                studentName = sc.nextLine();
                InputValidator.studentNameFormat(studentName);
                return studentName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return Validated user's input of the student's matriculation number
     */
    public static String getStudentMatric() {
        String studentMatric;
        while (true) {
            try {
                System.out.println("Enter Student's Matriculation Number");
                studentMatric = sc.nextLine();
                InputValidator.studentMatricFormat(studentMatric);
                InputValidator.existStudentMatric(studentMatric);
                return studentMatric;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return Validated user's input of the student's matriculation number
     */
    public static String newStudentMatric() {
        String studentMatric;
        while (true) {
            try {
                System.out.println("Enter Student's Matriculation Number");
                studentMatric = sc.nextLine();
                InputValidator.studentMatricFormat(studentMatric);
                InputValidator.newStudentMatric(studentMatric);
                return studentMatric;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Course

    /**
     * @return Validated user's input of the course name
     */
    public static String getCourseName() {
        String courseName;
        while (true) {
            try {
                System.out.println("Enter Course Name");
                courseName = sc.nextLine();
                InputValidator.courseNameFormat(courseName);
                return courseName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Takes in user input of an existing course code
     *
     * @return Validated user's input of the course code.
     */
    public static String getCourseCode() {
        String courseCode;
        while (true) {
            try {
                System.out.println("Enter Course Code");
                courseCode = sc.nextLine();
                InputValidator.courseCodeFormat(courseCode);
                InputValidator.existCourseCode(courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Takes in user input for a new course code
     *
     * @return Validated user's input of the course code.
     */
    public static String newCourseCode() {
        String courseCode;
        while (true) {
            try {
                System.out.println("Enter Course Code");
                courseCode = sc.nextLine();
                InputValidator.courseCodeFormat(courseCode);
                InputValidator.newCourseCode(courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return Validated user's input of the name of the course coordinator
     */
    public static String getCourseCoordinator() {
        String courseCoordinator;
        while (true) {
            try {
                System.out.println("Enter Course Coordinator");
                courseCoordinator = sc.nextLine();
                InputValidator.studentNameFormat(courseCoordinator);
                return courseCoordinator;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return Validated user's input of the course capacity
     */
    public static int getCourseCapacity() {
        int courseCapacity;
        while (true) {
            try {
                System.out.println("Enter Course Capacity");
                courseCapacity = sc.nextInt();
                if (courseCapacity < 1)
                    throw new Exception("There must be at least a capacity of 1!");
                sc.nextLine();
                return courseCapacity;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the number of tutorials sessions of the course
     */
    public static int getTutNumber(int courseCapacity) {
        int tutNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Tutorial Class");
                tutNumber = sc.nextInt();
                InputValidator.validateSessionNumber(tutNumber, courseCapacity);
                sc.nextLine();
                return tutNumber;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the number of laboratory sessions of the course
     */
    public static int getLabNumber(int courseCapacity) {
        int labNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Laboratory Class");
                labNumber = sc.nextInt();
                InputValidator.validateSessionNumber(labNumber, courseCapacity);
                sc.nextLine();
                return labNumber;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the exam weightage in the course
     */
    public static int getExamPercent() {
        int examPercent;
        while (true) {
            try {
                System.out.println("Enter Exam Percentage:");
                examPercent = sc.nextInt();
                InputValidator.validatePercentage(examPercent);
                sc.nextLine();
                return examPercent;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the coursework weightage in the course
     */
    public static int getCourseWorkPercent() {
        int courseWorkPercent;
        while (true) {
            try {
                System.out.println("Enter Coursework Percentage:");
                courseWorkPercent = sc.nextInt();
                InputValidator.validatePercentage(courseWorkPercent);
                sc.nextLine();
                return courseWorkPercent;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the assignment weightage in the coursework
     */
    public static int getAssignmentPercent() {
        int assignmentPercent;
        while (true) {
            try {
                System.out.println("Enter Assignment Percentage:");
                assignmentPercent = sc.nextInt();
                InputValidator.validatePercentage(assignmentPercent);
                sc.nextLine();
                return assignmentPercent;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * @return Validated user's input of the assignment weightage in the coursework
     */
    public static int getClassPartPercent() {
        int classPartPercent;
        while (true) {
            try {
                System.out.println("Enter Class Participation Percentage:");
                classPartPercent = sc.nextInt();
                InputValidator.validatePercentage(classPartPercent);
                sc.nextLine();
                return classPartPercent;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    // Student and Course

    /**
     * Takes in user input for a course code where the student is not registered for the course
     *
     * @param studentMatric The student's matriculation number
     * @return Validated user's input of the course code
     */
    public static String getStudentNotInCourse(String studentMatric) {
        String courseCode;
        while (true) {
            try {
                courseCode = Input.getCourseCode();
                InputValidator.checkStudentNotInCourse(studentMatric, courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Takes in user input for a course code where the student is already registered for the course
     *
     * @param studentMatric The student's matriculation number
     * @return Validated user's input of the course code
     */
    public static String getStudentInCourse(String studentMatric) {
        String courseCode;
        while (true) {
            try {
                courseCode = Input.getCourseCode();
                InputValidator.checkStudentInCourse(studentMatric, courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Captures inputMismatchCapture
     *
     * @param e Exception object
     */
    public static void inputMismatchCapture(Exception e) {
        System.out.println(e instanceof InputMismatchException ? "Input must be an integer!" : e.getMessage());
    }
}
