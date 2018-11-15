package scrame.student;

import scrame.DatabaseManager;
import scrame.Input;
import scrame.Main;
import scrame.print.PrintStudent;

public class AddStudent {

    final static String studentFile = "data/Students.txt";

    public static void run() {

        // Print list of ALL students
        PrintStudent.run();

        // Enter student name
        String studentName = Input.getStudentName();
        // Enter matriculation no.
        String studentMatricNo = Input.newStudentMatric();

        // New instance of Student
        Student student = new Student(studentName, studentMatricNo);

        // Add instance of student to array
        Main.studentList.add(student);

        // Print list of ALL students
        PrintStudent.run();

        // Write array to file
        DatabaseManager.write(Main.studentList, studentFile);
    }
}
