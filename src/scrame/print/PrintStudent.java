package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.Main;

/**
 * Prints student details into an ASCII table
 * @author CZ2002 SS3 Group 1
 * @version 4.0
 */
public class PrintStudent {

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
        System.out.println(ASCIITable.fromData(headers, data).toString());
    }
}
