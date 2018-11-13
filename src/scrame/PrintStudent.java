package scrame;

import com.mitchtalmadge.asciidata.table.ASCIITable;

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
