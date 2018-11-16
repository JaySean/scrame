package scrame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Creates a new marks record between a student and a course
 *
 * @author CZ2002 SS3 Group 1
 * @version 5.0
 */
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentMatric;
    private String courseCode;
    private int[] marksRecord; // Exam, Assignment, Class Participation

    /**
     * Creates a new marks record
     *
     * @param studentMatric The student's matriculation number
     * @param courseCode    The course code
     */
    StudentCourse(String studentMatric, String courseCode) {
        this.studentMatric = studentMatric;
        this.courseCode = courseCode;
        this.marksRecord = new int[3];
    }

    /**
     * @return The student's matriculation number
     */
    public String getStudentMatric() {
        return studentMatric;
    }

    /**
     * @return The course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @return The marks a student got for an exam
     */
    public int getExamMarks() {
        return marksRecord[0];
    }

    /**
     * Sets the exam marks that a student got for a course
     *
     * @param mark The student's exam marks for a course
     */
    public void setExamMarks(int mark) {
        marksRecord[0] = mark;
    }

    /**
     * @return The marks a student got for an assignment
     */
    public int getAssignmentMarks() {
        return marksRecord[1];
    }

    /**
     * Sets the assignment marks that a student got for a course
     *
     * @param mark The student's assignment marks for a course
     */
    public void setAssignmentMarks(int mark) {
        marksRecord[1] = mark;
    }

    /**
     * @return The marks a student got for class participation
     */
    public int getClassPartMarks() {
        return marksRecord[2];
    }

    /**
     * Sets the  marks that a student got for a course
     *
     * @param mark The student's class participation marks for a course
     */
    public void setClassPartMarks(int mark) {
        marksRecord[2] = mark;
    }
}
