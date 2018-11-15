package scrame.student;

import scrame.DatabaseManager;
import scrame.Main;

import java.io.*;

/**
 * Control class for Student
 *
 * @author CZ2002 SS3 Group 1
 * @version 5.0
 */

public class StudentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String studentFile = "data/Students.txt";

    /**
     * Adds the new student to the array of existing students and saves the array to the file
     *
     * @param student Student object being updated
     */
    public static void updateStudent(Student student) {
        if (student == null) return;
        Main.studentList.add(student);
        DatabaseManager.write(Main.studentList, studentFile);
    }
}
