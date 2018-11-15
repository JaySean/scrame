package scrame;

import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.student.Student;

public abstract class InputValidator {

    // Student
    public static void studentNameFormat(String name) throws Exception {
        final String nameFormat = "[A-z]+[A-z\\s]*";
        if (!name.matches(nameFormat)) {
            throw new Exception("Name format invalid - Must contain only letters and spaces, it must also not be blank\n");
        }
    }

    public static void studentMatricFormat(String studentMatric) throws Exception {
        final String matricFormat = "[A-Z][0-9]{7}[A-Z]";
        if (!studentMatric.matches(matricFormat)) {
            throw new Exception("Student matriculation number format invalid - Must begin and end with capital letters and have 7 digits in between\n");
        }
    }

    public static void newStudentMatric(String newStudentMatricNo) throws Exception {
        // Validate existence
        for (Student student : Main.studentList) {
            if (student.getStudentMatricNo().equals(newStudentMatricNo)) {
                throw new Exception("Student already exists!\n");
            }
        }
    }

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

    // Course
    public static void courseNameFormat(String courseName) throws Exception {
        final String nameFormat = "[A-z0-9]+[A-z0-9\\s]*";
        if (!courseName.matches(nameFormat)) {
            throw new Exception("Name format invalid - It must also not be blank\n");
        }
    }

    public static void courseCodeFormat(String newCourseCode) throws Exception {
        final String courseCodeFormat = "[A-Z]{2}[0-9]{4}";
        if (!newCourseCode.matches(courseCodeFormat)) {
            throw new Exception("Course code format invalid - Must begin with 2 capital letters followed by 4 digits\n");
        }
    }

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

    public static void validatePercentage(int percentage) throws Exception {
        if (percentage > 100 || percentage < 0)
            throw new Exception("A percentage must be between 1-100\n");
    }

    public static void validateTotalPercentage(int percentage1, int percentage2) throws Exception {
        if (percentage1 + percentage2 != 100)
            throw new Exception("Percentages must total 100!\n");
    }

    // Marks
    public static void validateMark(int mark) throws Exception {
        if (mark > 100 || mark < 0)
            throw new Exception("A mark must be between 0-100");
    }

    // Student and Course
    public static void studentCourse(String studentMatric, String courseCode) throws Exception {
        Course course = CourseManager.getCourse(courseCode);
        if (course.hasStudent(studentMatric)) {
            throw new Exception("Student is already registered for this course!\n");
        }
    }
}
