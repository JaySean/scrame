package scrame.student;

import scrame.Input;
import scrame.print.PrintStudent;

/**
 * Creates a new student object and appends it to the existing list of students
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */

public class AddStudent {

    /**
     * This is the main method of the AddStudent function
     */
    public static void run() {

        // Print list of ALL students
        PrintStudent.run();

        // Enter student name
        String studentName = Input.getStudentName();
        // Enter matriculation no.
        String studentMatricNo = Input.newStudentMatric();

        // New instance of Student
        Student student = new Student(studentName, studentMatricNo);

        // Update student list
        StudentManager.updateStudent(student);

        // Print list of ALL students
        PrintStudent.run();
    }
}
