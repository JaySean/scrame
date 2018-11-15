package scrame;

import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.student.Student;

/**
 A class holding all validation methods used by the Input class
 @author Lim Han Quan
 @version 6.0
 */

public abstract class InputValidator {

    /**
     Checks if student name matches given regex format
     * @param name proposed name of student
     * @throws Exception containing error message to prompt user for correct format
     */
    public static void studentNameFormat(String name) throws Exception {
        final String nameFormat = "[A-z]+[A-z\\s]*";
        if (!name.matches(nameFormat)) {
            throw new Exception("Name format invalid - Must contain only letters and spaces, it must also not be blank\n");
        }
    }

    /**
     Checks if student matriculation matches given regex format
     * @param studentMatric proposed student matriculation number
     * @throws Exception containing error message to prompt user for correct format
     */
    public static void studentMatricFormat(String studentMatric) throws Exception {
        final String matricFormat = "[A-Z][0-9]{7}[A-Z]";
        if (!studentMatric.matches(matricFormat)) {
            throw new Exception("Student matriculation number format invalid - Must begin and end with capital letters and have 7 digits in between\n");
        }
    }

    /**
     Checks if student matric is already in system
     * @param newStudentMatricNo proposed new student matriculation number
     * @throws Exception containing error message telling user that student matric is taken
     */
    public static void newStudentMatric(String newStudentMatricNo) throws Exception {
        // Validate existence
        for (Student student : Main.studentList) {
            if (student.getStudentMatricNo().equals(newStudentMatricNo)) {
                throw new Exception("Student already exists!\n");
            }
        }
    }

    /**
     Checks if student matric is already in system
     * @param newStudentMatric proposed new student matriculation number
     * @throws Exception containing error message telling user that student doesn't exist in system
     */
    public static void existStudentMatric(String newStudentMatric) throws Exception {
        // Check for existence
        boolean exists = false;
        for (Student student : Main.studentList) {
            if (student.getStudentMatricNo().equals(newStudentMatric)) {
                exists = true;
            }
        }
        if (!exists)
            throw new Exception("Student does not exist!\n");
    }

    /**
     Checks if student course name matches given regex format
     * @param courseName course name to validated
     * @throws Exception containing error message prompting user for correct format
     */
    public static void courseNameFormat(String courseName) throws Exception {
        final String nameFormat = "[A-z0-9]+[A-z0-9\\s]*";
        if (!courseName.matches(nameFormat)) {
            throw new Exception("Name format invalid - It must also not be blank\n");
        }
    }

    /**
     Checks if student course code matches given regex format
     * @param newCourseCode course code to validate
     * @throws Exception containing error message prompting user for correct format
     */
    public static void courseCodeFormat(String newCourseCode) throws Exception {
        final String courseCodeFormat = "[A-Z]{2}[0-9]{4}";
        if (!newCourseCode.matches(courseCodeFormat)) {
            throw new Exception("Course code format invalid - Must begin with 2 capital letters followed by 4 digits\n");
        }
    }

    /**
     Checks if new course code is already in system
     * @param newCourseCode course code to validate
     * @throws Exception containing error message telling user that Course Code is taken
     */
    public static void newCourseCode(String newCourseCode) throws Exception {
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
     Checks if course is in system by course code
     * @param newCourseCode course code to validate
     * @throws Exception containing error message telling user that course does not exist
     */
    public static void existCourseCode(String newCourseCode) throws Exception {
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
     Validates if percentage is within 0-100
     * @param percentage percentage to input
     * @throws Exception containing error message telling user that percentage must be between 1-100
     */
    public static void validatePercentage(int percentage) throws Exception {
        if (percentage > 100 || percentage < 0)
            throw new Exception("A percentage must be between 1-100\n");
    }


    /**
     validates is both input percentages add up to 100
     * @param percentage1 percentage to input
     * @param percentage2 percentage to input
     * @throws Exception containing error message telling user that percentage must add to 100
     */
    public static void validateTotalPercentage(int percentage1, int percentage2) throws Exception {
        if (percentage1 + percentage2 != 100)
            throw new Exception("Percentages must total 100!\n");
    }

    /**
     validates if mark adds is 100
     * @param mark
     * @throws Exception
     */
    public static void validateMark(int mark) throws Exception {
        if (mark > 100 || mark < 0)
            throw new Exception("A mark must be between 0-100");
    }

    /**
     Checks if student already registered for course
     * @param studentMatric student
     * @param courseCode course to check using course code
     * @throws Exception containing error message that user is already in course
     */
    public static void studentCourse(String studentMatric, String courseCode) throws Exception {
        Course course = CourseManager.getCourse(courseCode);
        if (!course.hasStudent(studentMatric)) {
            throw new Exception("Student is not registered for this course!\n");
        }
    }
}
