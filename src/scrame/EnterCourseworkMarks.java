package scrame;

import java.util.Scanner;

public class EnterCourseworkMarks {

    final static String studentCourseFile = "data/StudentCourse.txt";
    static Scanner sc = new Scanner(System.in);

    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getCourseFromStudent(studentMatric);

        Course course = CourseManager.getCourse(courseCode);
        StudentCourse studentCourse = StudentCourseManager.createStudentCourse(studentMatric, courseCode);

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
