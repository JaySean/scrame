package scrame;

import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.student.Student;

/**
 * Validates the user's inputs
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */

public abstract class InputValidator {

    /**
     * Checks if student name matches given regex format
     *
     * @param name User input for the student's name
     * @throws Exception containing error message to prompt user for correct format
     */
    static void studentNameFormat(String name) throws Exception {
        final String nameFormat = "[A-z]+[A-z\\s]*";
        if (!name.matches(nameFormat)) {
            throw new Exception("Name format invalid - Must contain only letters and spaces, it must also not be blank\n");
        }
    }

    /**
     * Checks if student matriculation matches given regex format
     *
     * @param studentMatric User input for the student's matriculation number
     * @throws Exception containing error message to prompt user for correct format
     */
    static void studentMatricFormat(String studentMatric) throws Exception {
        final String matricFormat = "[A-Z][0-9]{7}[A-Z]";
        if (!studentMatric.matches(matricFormat)) {
            throw new Exception("Student matriculation number format invalid - Must begin and end with capital letters and have 7 digits in between\n");
        }
    }

    /**
     * Checks if the student is not in system
     *
     * @param newStudentMatricNo User input for the new student's matriculation number
     * @throws Exception containing error message telling user that the student already exists
     */
    static void newStudentMatric(String newStudentMatricNo) throws Exception {
        // Validate existence
        for (Student student : Main.studentList) {
            if (student.getStudentMatricNo().equals(newStudentMatricNo)) {
                throw new Exception("Student already exists!\n");
            }
        }
    }

    /**
     * Checks if the student is already in system
     *
     * @param existStudentMatric User input for the existing student's matriculation number
     * @throws Exception containing error message telling user that student doesn't exist
     */
    static void existStudentMatric(String existStudentMatric) throws Exception {
        // Check for existence
        boolean exists = false;
        for (Student student : Main.studentList) {
            if (student.getStudentMatricNo().equals(existStudentMatric)) {
                exists = true;
            }
        }
        if (!exists)
            throw new Exception("Student does not exist!\n");
    }

    /**
     * Checks if student course name matches given regex format
     *
     * @param courseName User input for the course name
     * @throws Exception containing error message prompting user for correct format
     */
    static void courseNameFormat(String courseName) throws Exception {
        final String nameFormat = "[A-z0-9]+[A-z0-9\\s]*";
        if (!courseName.matches(nameFormat)) {
            throw new Exception("Name format invalid - It must also not be blank\n");
        }
    }

    /**
     * Checks if student course code matches given regex format
     *
     * @param newCourseCode User input for the course code
     * @throws Exception containing error message prompting user for correct format
     */
    static void courseCodeFormat(String newCourseCode) throws Exception {
        final String courseCodeFormat = "[A-Z]{2}[0-9]{4}";
        if (!newCourseCode.matches(courseCodeFormat)) {
            throw new Exception("Course code format invalid - Must begin with 2 capital letters followed by 4 digits\n");
        }
    }

    /**
     * Checks if the course is not in the system
     *
     * @param newCourseCode User input for the new course code
     * @throws Exception containing error message telling user that the course already exists
     */
    static void newCourseCode(String newCourseCode) throws Exception {
        // Check for existence
        boolean exists = false;
        for (Course course : Main.courseList) {
            if (course.getCourseCode().equals(newCourseCode)) {
                exists = true;
            }
        }
        if (exists)
            throw new Exception("Course already exists!\n");
    }

    /**
     * Checks if the course is already in the system
     *
     * @param newCourseCode User input for the course code
     * @throws Exception containing error message telling user that course does not exist
     */
    static void existCourseCode(String newCourseCode) throws Exception {
        // Check for existence
        boolean exists = false;
        for (Course course : Main.courseList) {
            if (course.getCourseCode().equals(newCourseCode)) {
                exists = true;
            }
        }
        if (!exists)
            throw new Exception("Course does not exist!\n");
    }

    /**
     * Checks if such a session exists in the system
     *
     * @param choice  User input for the session number
     * @param size    Number of session of that type in the course
     * @param session Type of session
     * @throws Exception containing error message telling user that session does not exist
     */
    public static void existSession(int choice, int size, String session) throws Exception {
        if (choice > size || choice < 1) {
            throw new Exception("No such " + session + "!\n");
        }
    }

    /**
     * Checks if the number of sessions to be created is in the correct range
     *
     * @param sessionNumber  User input for the number of sessions
     * @param courseCapacity Total number of sessions that can be created
     * @throws Exception containing error message telling user that the number of sessions is incorrect
     */
    static void validateSessionNumber(int sessionNumber, int courseCapacity) throws Exception {
        if (sessionNumber <= 0)
            throw new Exception("Number must be more than zero!\n");
        if (sessionNumber > courseCapacity) {
            throw new Exception("Number of sessions cannot exceed course capacity!\n");
        }
    }

    /**
     * Checks if there are remaining vacancies for a student to register for a course
     *
     * @param vacancy Remaining slots in the course being registered for
     * @throws Exception containing error message telling user that there are no more vacancies
     */
    public static void existVacancy(int vacancy) throws Exception {
        if (vacancy == 0) {
            throw new Exception("No vacancies!\n");
        }
    }

    /**
     * Checks if the percentage is from 1 to 100
     *
     * @param percentage User input for the component's percentage
     * @throws Exception containing error message telling user that percentage must be from 1-100
     */
    static void validatePercentage(int percentage) throws Exception {
        if (percentage > 100 || percentage < 0)
            throw new Exception("A percentage must be between 1-100\n");
    }


    /**
     * Checks if the components' percentages add up to 100
     *
     * @param percentage1 Percentage of first component
     * @param percentage2 Percentage of second component
     * @throws Exception containing error message telling user that percentages must add to 100
     */
    public static void validateTotalPercentage(int percentage1, int percentage2) throws Exception {
        if (percentage1 + percentage2 != 100)
            throw new Exception("Percentages must total 100!\n");
    }

    /**
     * Checks if the marks being added is from 1 to 100
     *
     * @param mark User input for the marks to be added to the record
     * @throws Exception containing error message telling user that the marks must be in the correct range
     */
    public static void validateMark(int mark) throws Exception {
        if (mark > 100 || mark < 0)
            throw new Exception("Marks must be between 0-100");
    }

    /**
     * Checks if student is registered for the course
     *
     * @param studentMatric User input for the student's matriculation number
     * @param courseCode    User input for the course code
     * @throws Exception containing error message that user not registered for the course
     */
    static void checkStudentInCourse(String studentMatric, String courseCode) throws Exception {
        Course course = CourseManager.getCourse(courseCode);
        if (!course.hasStudent(studentMatric)) {
            throw new Exception("Student is not registered for this course!\n");
        }
    }

    /**
     * Checks if student is already registered for course
     *
     * @param studentMatric User input for the student's matriculation number
     * @param courseCode    User input for the course code
     * @throws Exception containing error message that user already registered for the course
     */
    static void checkStudentNotInCourse(String studentMatric, String courseCode) throws Exception {
        Course course = CourseManager.getCourse(courseCode);
        if (course.hasStudent(studentMatric)) {
            throw new Exception("Student is already registered for this course!\n");
        }
    }
}
