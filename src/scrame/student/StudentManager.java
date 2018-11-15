package scrame.student;

import scrame.DatabaseManager;
import scrame.Main;

import java.io.*;

public class StudentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String studentFile = "data/Students.txt";

    public static void updateStudent(Student student) {
        if (student == null) return;
        Main.studentList.add(student);
        DatabaseManager.write(Main.studentList, studentFile);
    }
}
