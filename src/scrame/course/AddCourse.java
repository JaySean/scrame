package scrame.course;

import scrame.Input;
import scrame.print.PrintCourse;

public class AddCourse {

    public static void run() {

        PrintCourse.run();

        boolean repeat;

        String courseName = Input.getCourseName();
        String courseCode = Input.newCourseCode();
        String courseCoordinator = Input.getCourseCoordinator();
        int courseCapacity = Input.getCourseCapacity();
        int tutNumber = Input.getTutNumber();
        int labNumber = Input.getLabNumber();

        // Get exam and coursework percentages
        int examPercent = 0;
        int courseWorkPercent = 0;
        repeat = true;
        while (repeat) {
            try {
                System.out.println("Exam and Coursework Weights (Total 100%):");
                examPercent = Input.getExamPercent();
                courseWorkPercent = Input.getCourseWorkPercent();
                if (examPercent + courseWorkPercent != 100 && examPercent > 0 && courseWorkPercent > 0)
                    throw new Exception("Exam and Course Work percentages must total 100 and there must be an Exam and Coursework component");
                repeat = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Get assignment and class participation percentages
        int assignmentPercent = 0;
        int classPartPercent = 0;
        repeat = true;
        while (repeat) {
            try {
                System.out.println("\nCoursework Components");
                System.out.println("Assignment and Class Participation Weights (Total 100%):");
                assignmentPercent = Input.getAssignmentPercent();
                classPartPercent = Input.getClassPartPercent();
                if (assignmentPercent + classPartPercent != 100) {
                    throw new Exception("Assignment and Class Participation percentage must total 100");
                }
                repeat = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Create new instance of course
        Course course = new Course(
                courseName, courseCode, courseCoordinator,
                courseCapacity, tutNumber, labNumber,
                examPercent, courseWorkPercent, assignmentPercent, classPartPercent);

        // Update course list
        CourseManager.updateCourse(course);

        // Print list of ALL courses
        PrintCourse.run();
    }
}
