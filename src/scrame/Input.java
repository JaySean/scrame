package scrame;

import scrame.course.CourseManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Holds all the input methods
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class Input {

    static Scanner sc = new Scanner(System.in);

    // Student

    /**
     * Getter method to validate the format the name of a student.
     * @return student name
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
     * Getter Method to validate format and check for duplicates of the student matric number
     * @return the matric number of the student.
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
     * method to input student matric number and validate it
     * @return the matric number of the student.
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
     * method to validate the format of the inputted course name
     * @return the course name
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
     *method to validate the format and check for duplicates of the inputted course code
     * @return the course code.
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
     * Validates the format and the existence of the course code inputted
     * @return the course code.
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
     * validates the format of the name of the course coordinator inputted
     * @return the name of the course coordinator
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
     * method for inputting the course capacity of a course
     * @return the course with the set course capacity
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
     * method for inputting the number of tutorial classes in a course
     * @return the number of tutorials to be stored in the course
     */
    public static int getTutNumber() {
        int tutNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Tutorial Class");
                tutNumber = sc.nextInt();
                if (tutNumber < 0)
                    throw new Exception("Number cannot be negative!");
                sc.nextLine();
                return tutNumber;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * method for inputting the number of lab sessions in a course
     * @return the number of lab sessions to be stored in the course.
     */
    public static int getLabNumber() {
        int labNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Laboratory Class");
                labNumber = sc.nextInt();
                if (labNumber < 0)
                    throw new Exception("Number cannot be negative!");
                sc.nextLine();
                return labNumber;
            } catch (Exception e) {
                sc.nextLine();
                inputMismatchCapture(e);
            }
        }
    }

    /**
     * input method to enter the weightage an exam has in a course.
     * @return the weightage an exam has on a course.
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
     * method to enter the weighttage coursework has on a course
     * @return the weightage the coursework has on a course.
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
     * input method for entering the weightage an assignment has on coursework
     * @return the weightage the assignment has on coursework component
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
     * input method for entering the weightage class part has on coursework
     * @return the weightage class part has on coursework.
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
     *input method to validate whether or not a student is registered in a course.
     * @param studentMatric
     * @return the course code.
     */
    public static String getCourseFromStudent(String studentMatric){

    public static String getCourseFromStudent(String studentMatric) {

        String courseCode;
        while (true) {
            try {
                courseCode = Input.getCourseCode();
                InputValidator.studentCourse(studentMatric, courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * validates if inputted value is a mismatch based on type
     * @param e exception object
     */
    public static void inputMismatchCapture(Exception e) {
        System.out.println(e instanceof InputMismatchException ? "Input cannot be a integer!" : e.getMessage());
    }
}
