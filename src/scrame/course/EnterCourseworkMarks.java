package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

/**
 * Class to implement the entering Coursework marks
 * @author CZ2002 SS3 group 1
 * @version 3.0
 */

public class EnterCourseworkMarks {

    static Scanner sc = new Scanner(System.in);
    /**
     * A method to implement all the methods required to add a course into the array list
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getCourseFromStudent(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric, courseCode);

        if (course.hasAssignment()) {
            enterAssignmentMarks(studentCourse);
        }
        if (course.hasClassPart()) {
            enterClassPartMarks(studentCourse);
        }

        StudentCourseManager.updateStudentCourse(studentCourse);
    }

    /**
     * Method to validate and enter the amount of marks scored in an assignment section
     * @param studentCourse
     */
    private static void enterAssignmentMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Assignment Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setAssignmentMarks(marks);
        } catch (Exception e) {
            Input.inputMismatchCapture(e);
            enterAssignmentMarks(studentCourse);
        }
    }

    /**
     * Method to validate and enter the amount of marks scored in the classpart section
     * @param studentCourse
     */
    private static void enterClassPartMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Class Participation Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setClassPartMarks(marks);
        } catch (Exception e) {
            Input.inputMismatchCapture(e);
            enterClassPartMarks(studentCourse);
        }
    }
}
