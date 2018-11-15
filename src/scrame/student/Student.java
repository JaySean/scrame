package scrame.student;

import java.io.Serializable;

/**
 * Represents a student enrolled in the school
 * A student can be enrolled in many courses
 *
 * @author CZ2002 SS3 Group 1
 * @version 5.0
 */

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The student's name
     */
    private String studentName;
    /**
     * The student's matriculation number
     */
    private String studentMatricNo;

    /**
     * Creates a new student
     *
     * @param studentName     This student's name
     * @param studentMatricNo This student's matriculation number
     */
    public Student(String studentName, String studentMatricNo) {
        this.studentName = studentName;
        this.studentMatricNo = studentMatricNo;
    }

    /**
     * Gets the student's name
     *
     * @return This student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Get the student's matriculation number
     *
     * @return This student's matriculation number
     */
    public String getStudentMatricNo() {
        return studentMatricNo;
    }
}
