package scrame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that puts together a student's unique particulars and their course marks and
 * stores them as a record
 * @author CZ2002 SS3 Group 1
 * @version 5.0
 */
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentMatric;
    private String courseCode;
    private int[] marksRecord; //exam assignment classPart

    /**
     * constructors for class
     * @param studentMatric matric number of the student
     * @param courseCode unqiue course code of course
     */
    public StudentCourse(String studentMatric, String courseCode) {
        this.studentMatric = studentMatric;
        this.courseCode = courseCode;
        this.marksRecord = new int[3];
    }

    /**
     * getter method for a student's matric number
     * @return the student's matric number
     */
    public String getStudentMatric() {
        return studentMatric;
    }

    /**Getter method for a student's course code
     * @return the unique code that refers to a course
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Getter method for exams marks
     * @return the marks a student got for an exam
     */
    public int getExamMarks() {
        return marksRecord[0];
    }

    /**
     * Setter method to set exam marks for a student
     * @param mark amount of marks a student got for an exam of a course
     */
    public void setExamMarks(int mark) {
        marksRecord[0] = mark;
    }

    /**
     * Getter method to get assignment mark
     * @return the amount of marks a student got for an assignment
     */
    public int getAssignmentMarks() {
        return marksRecord[1];
    }

    /**
     * Setter method to set the assignment marks of a student
     * @param mark The amount of marks a student scored for his assignment component
     */
    public void setAssignmentMarks(int mark) {
        marksRecord[1] = mark;
    }

    /**
     * Getter method to get class part marks
     * @return the class part marks a student got for this component
     */
    public int getClassPartMarks() {
        return marksRecord[2];
    }

    /**
     * setter method for classpart marks
     * @param mark the amount of marks a student has scored for classpart
     */
    public void setClassPartMarks(int mark) {
        marksRecord[2] = mark;
    }
}
