package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

/**
 * Takes in user's input of coursework marks and sets it in the record
 *
 * @author CZ2002 SS3 group 1
 * @version 4.0
 */

public class EnterCourseworkMarks {

    static Scanner sc = new Scanner(System.in);

    /**
     * The main method of the EnterCourseworkMarks function
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getStudentInCourse(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric, courseCode);

        if (course.hasAssignment()) {
            enterAssignmentMarks(studentCourse);
        }
        if (course.hasClassPart()) {
            enterClassPartMarks(studentCourse);
        }

        // Creates/updates the marks record
        StudentCourseManager.updateStudentCourse(studentCourse);
    }

    /**
     * Takes in the user's input and sets the assignment marks
     *
     * @param studentCourse Record between a student and a course
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
     * Takes in the user's input and sets the class participation marks
     *
     * @param studentCourse Record between a student and a course
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
