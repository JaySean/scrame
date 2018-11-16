package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

/**
 * Takes in user's input of exam marks and sets it in the record
 *
 * @author CZ2002 SS3 Group 1
 * @version 4.0
 */
public class EnterExamMarks {

    static Scanner sc = new Scanner(System.in);

    /**
     * The main method of the EnterCourseworkMarks function
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getStudentInCourse(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric, courseCode);

        if (course.hasExam()) enterExamMarks(studentCourse);

        // Creates/updates the marks record
        StudentCourseManager.updateStudentCourse(studentCourse);
    }

    /**
     * Takes in the user's input and sets the exam marks
     *
     * @param studentCourse Record between a student and a course
     */
    private static void enterExamMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Exam Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setExamMarks(marks);
        } catch (Exception e) {
            Input.inputMismatchCapture(e);
            enterExamMarks(studentCourse);
        }
    }
}
