package scrame.course;

import scrame.Input;
import scrame.InputValidator;
import scrame.print.PrintCourse;

/**
 * Class that handles the edition of a course
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */

public class AddCourse {
    /**
     * A method to implement all the methods required to add a course in the console
     */
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
                InputValidator.validateTotalPercentage(examPercent, courseWorkPercent);
                repeat = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Get assignment and class participation percentages
        int assignmentPercent = 0;
        int classPartPercent = 0;
        repeat = true;
        System.out.println("\nCoursework Components");
        while (repeat) {
            try {
                System.out.println("Assignment and Class Participation Weights (Total 100%):");
                assignmentPercent = Input.getAssignmentPercent();
                classPartPercent = Input.getClassPartPercent();
                InputValidator.validateTotalPercentage(assignmentPercent, classPartPercent);
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
