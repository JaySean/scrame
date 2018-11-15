package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.StudentCourse;
import scrame.StudentCourseManager;

import java.util.Scanner;

public class EnterCourseworkMarks {

    static Scanner sc = new Scanner(System.in);

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

    private static void enterAssignmentMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Assignment Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setAssignmentMarks(marks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            enterAssignmentMarks(studentCourse);
        }
    }

    private static void enterClassPartMarks(StudentCourse studentCourse) {
        try {
            System.out.println("Enter Class Participation Marks:");
            int marks = sc.nextInt();
            InputValidator.validateMark(marks);
            studentCourse.setClassPartMarks(marks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            enterClassPartMarks(studentCourse);
        }
    }
}
