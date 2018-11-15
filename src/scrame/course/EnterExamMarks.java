package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

/**
 * Class to enter the marks a student got for an exam
 * @author CZ2002 SS3 Group 1
 * @version 4.0
 */
public class EnterExamMarks {

    static Scanner sc = new Scanner(System.in);
    /**
     * A method to implement all the methods required to add a course into the array list
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getCourseFromStudent(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric, courseCode);

        if (course.hasExam()) enterExamMarks(studentCourse);

        StudentCourseManager.updateStudentCourse(studentCourse);
    }

    /**
     * Method that validates and sets the exam marks gotten by a student
     * @param studentCourse
     */
    private static void enterExamMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Exam Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setExamMarks(marks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            enterExamMarks(studentCourse);
        }
    }
}
