package scrame;

import java.util.ArrayList;

/**
 * Control class for the marks record between a student and a course
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public class StudentCourseManager {
    /**
     * Location of data of a student's marks in a particular course
     */
    final static String studentCourseFile = "data/StudentCourse.txt";

    /**
     * @param studentMatric The student's matriculation number
     * @param courseCode    The course code
     * @return the index of the marks record being searched
     */
    public static int getIndex(String studentMatric, String courseCode) {
        for (int i = 0; i < Main.studentCourseList.size(); i++) {
            if (Main.studentCourseList.get(i).getStudentMatric().equals(studentMatric)) {
                if (Main.studentCourseList.get(i).getCourseCode().equals(courseCode)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @param studentMatric The student's matriculation number
     * @param courseCode    The course code
     * @return the marks record of the student for a particular course
     */
    public static StudentCourse getStudentCourse(String studentMatric, String courseCode) {
        StudentCourse studentCourse;

        int index = getIndex(studentMatric, courseCode);

        if (index == -1) {
            studentCourse = new StudentCourse(studentMatric, courseCode);
        } else {
            studentCourse = Main.studentCourseList.get(index);
        }

        return studentCourse;
    }

    /**
     * If the marks record is new and being added, it is appended to the end of the list of courses
     * If the marks record is being amended, it is updated in its previous index of the list
     *
     * @param studentCourse the marks record of a student for a particular course
     */
    public static void updateStudentCourse(StudentCourse studentCourse) {
        if (studentCourse == null) return;
        int index = getIndex(studentCourse.getStudentMatric(), studentCourse.getCourseCode());
        if (index == -1) {
            Main.studentCourseList.add(studentCourse);
        } else {
            Main.studentCourseList.set(index, studentCourse);
        }
        DatabaseManager.write(Main.studentCourseList, studentCourseFile);
    }

    /**
     * @param courseCode The course code
     * @return List of marks record of the particular course
     */
    public static ArrayList<StudentCourse> getCourseList(String courseCode) {
        ArrayList<StudentCourse> courseList = new ArrayList<>(0);
        for (StudentCourse studentCourse : Main.studentCourseList) {
            if (studentCourse.getCourseCode().equals(courseCode)) {
                courseList.add(studentCourse);
            }
        }
        return courseList;
    }

    /**
     * Calculates the average exam marks of a course
     *
     * @param courseCode The course code
     * @return Average marks that the students got for the exam of the course
     */
    public static double getAveExamMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourseList(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getExamMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }

    /**
     * Calculates the average assignment marks of a course
     *
     * @param courseCode The course code
     * @return Average marks that the students got for the assignment of the course
     */
    public static double getAveAssignmentMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourseList(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getAssignmentMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }

    /**
     * Calculates the average class participation marks of a course
     *
     * @param courseCode The course code
     * @return Average marks that the students got for the class participation of the course
     */
    public static double getAveClassPartMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourseList(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getClassPartMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }
}
