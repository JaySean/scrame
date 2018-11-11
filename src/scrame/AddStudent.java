package scrame;

import com.mitchtalmadge.asciidata.table.ASCIITable;

import java.util.ArrayList;
import java.util.Scanner;

public class AddStudent {

    final static String studentFile = "data/Students.txt";

    public static void run() {


        Scanner sc = new Scanner(System.in);
        String studentName = "";
        String studentMatricNo = "";
        boolean correct;

        // Enter student name
        correct = false;
        while (!correct) {
            try {
                System.out.println("Enter Student's Name");
                studentName = sc.nextLine();
                FormatValidator.validateName(studentName);
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Enter matriculation no.
        correct = false;
        while (!correct) {
            try {
                System.out.println("Enter Student's Matriculation Number");
                studentMatricNo = sc.nextLine();
                validateNewStudentMatricNo(studentMatricNo);
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // New instance of Student
        Student student = new Student(studentName, studentMatricNo);

        // Add instance of student to array
        Main.studentList.add(student);

        // Print list of ALL students
        String[] headers = new String[]{"No.", "Name", "Matriculation Number"};

        int numberOfStudents = Main.studentList.size();
        String[][] data = new String[numberOfStudents][3];

        for (int i = 0; i < numberOfStudents; i++) {
            data[i][0] = Integer.toString(i + 1);
            data[i][1] = Main.studentList.get(i).getStudentName();
            data[i][2] = Main.studentList.get(i).getStudentMatricNo();
        }
        System.out.println(ASCIITable.fromData(headers, data).toString());

        // Write array to file
        DatabaseManager.write(Main.studentList, studentFile);
    }

    private static void validateNewStudentMatricNo(String newStudentMatricNo) throws Exception {
        // Validate format
        FormatValidator.validateMatricNo(newStudentMatricNo);
        // Validate existence
        boolean exists = StudentManager.checkStudentExistence(newStudentMatricNo);
        if (exists) throw new Exception("Student already exists!");
    }
}
