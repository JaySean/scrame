package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

public class EnterExamMarks {

    static Scanner sc = new Scanner(System.in);

    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getCourseFromStudent(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.getStudentCourse(studentMatric, courseCode);

        if (course.hasExam()) enterExamMarks(studentCourse);

        StudentCourseManager.updateStudentCourse(studentCourse);
    }

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
