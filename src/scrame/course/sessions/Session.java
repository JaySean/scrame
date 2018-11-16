package scrame.course.sessions;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Superclass of sessions of a course which students register for
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Total number of students that can register for the session
     */
    int capacity;
    /**
     * Current remaining slots of the session that students can register for
     */
    int vacancy;
    /**
     * List of students that are registered for the session
     */
    public String[] studentList = new String[capacity];

    /**
     * Gets the course's vacancy
     *
     * @return The vacancy of the session
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * Gets the course's capacity
     *
     * @return The capacity of the session
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the list of register students of the session
     *
     * @return The list of registered students of the session
     */
    public String[] getStudentList() {
        return studentList;
    }

    /**
     * method to add a student to a session
     *
     * @param studentMatric
     */
    public void addStudent(String studentMatric) {
        studentList[capacity - vacancy] = studentMatric;
        vacancy--;
    }

    /**
     * Checks whether a student is registered for the session
     *
     * @param studentMatric The student's matriculation number
     * @return A boolean value of whether a student is registered for the session
     */
    public boolean hasStudent(String studentMatric) {
        for (String student : studentList) {
            if (student.equals(studentMatric)) return true;
        }
        return false;
    }
}
