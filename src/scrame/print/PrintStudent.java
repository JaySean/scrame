package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.Main;

/**
 * Prints the list of created students
 * Contains details of student name and matriculation number
 *
 * @author CZ2002 SS3 Group 1
 * @version 4.0
 */
public class PrintStudent {

    /**
     * Main method of the PrintStudent function
     */
    public static void run() {

        String[] headers = new String[]{
                "No.",
                "Name",
                "Matriculation Number"
        };

        int numberOfStudents = Main.studentList.size();
        String[][] data = new String[numberOfStudents][3];

        for (int i = 0; i < numberOfStudents; i++) {
            data[i][0] = Integer.toString(i + 1);
            data[i][1] = Main.studentList.get(i).getStudentName();
            data[i][2] = Main.studentList.get(i).getStudentMatricNo();
        }

        // Outputs data in an ASCII table
        System.out.println(ASCIITable.fromData(headers, data).toString());
    }
}
