package scrame;

import java.util.ArrayList;

/**
 * Control class that manages the marks of a student in all his components
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public class StudentCourseManager {
    /**
     * Storing data on a student's performance in a particular course in a .txt file
     */
    final static String studentCourseFile = "data/StudentCourse.txt";

    /**
     * Gets the index when raversing through the Student records
     * @param studentMatric The matric number of the student
     * @param courseCode The code unique to the course.
     * @return the index of the record being searched
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
     * getter method to get the record of a student
     * @param studentMatric matric number of the student
     * @param courseCode course code of the student
     * @return the record of the student
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
     * updates student oourse record
     * @param studentCourse the record of a student in a particular course
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
     * instantiates an array list of course names along with its course code
     * @param courseCode the unique code of a course
     * @return list of courses in the array list
     */
    public static ArrayList<StudentCourse> getCourse(String courseCode) {
        ArrayList<StudentCourse> listByCourse = new ArrayList<>(0);
        for (StudentCourse studentCourse : Main.studentCourseList) {
            if (studentCourse.getCourseCode().equals(courseCode)) {
                listByCourse.add(studentCourse);
            }
        }
        return listByCourse;
    }

    /**
     * calculates the eaverage exam marks of a course
     * @param courseCode unique code of courses
     * @return average marks students got for the exam of a course
     */
    public static double getAveExamMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourse(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getExamMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }

    /**
     * Calculates average marks students got for the assignment component of the course
     * @param courseCode Unique code to a course
     * @return average marks students got for the assignment component
     */
    public static double getAveAssignmentMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourse(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getAssignmentMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }
    /**
     * Calculates average marks students got for the class part component of the course
     * @param courseCode Unique code to a course
     * @return average marks students got for the class part component
     */
    public static double getAveClassPartMarks(String courseCode) {
        ArrayList<StudentCourse> studentCourseList = getCourse(courseCode);
        int totalMarks = 0;
        for (StudentCourse studentCourse : studentCourseList) {
            totalMarks += studentCourse.getClassPartMarks();
        }
        return (double) totalMarks / studentCourseList.size();
    }
}
