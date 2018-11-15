package scrame;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentMatric;
    private String courseCode;
    private int[] marksRecord; //exam assignment classPart

    public StudentCourse(String studentMatric, String courseCode) {
        this.studentMatric = studentMatric;
        this.courseCode = courseCode;
        this.marksRecord = new int[3];
    }

    public String getStudentMatric() {
        return studentMatric;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getExamMarks() {
        return marksRecord[0];
    }

    public void setExamMarks(int mark) {
        marksRecord[0] = mark;
    }

    public int getAssignmentMarks() {
        return marksRecord[1];
    }

    public void setAssignmentMarks(int mark) {
        marksRecord[1] = mark;
    }

    public int getClassPartMarks() {
        return marksRecord[2];
    }

    public void setClassPartMarks(int mark) {
        marksRecord[2] = mark;
    }
}
