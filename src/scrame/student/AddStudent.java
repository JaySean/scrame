package scrame.student;

import scrame.Input;
import scrame.print.PrintStudent;

/
public class AddStudent {

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
