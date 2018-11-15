package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.Main;

/**
 * Class that prints the course details in an ASCII table from the attributes below
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */

public class PrintCourse {
    /**
     * Run method that implements all the required method to print out course details
     */
    public static void run() {
        String[] headers = new String[]{
                "No.",
                "Course Name",
                "Course Code",
                "Course Coordinator"
        };

        int numberOfCourses = Main.courseList.size();
        String[][] data = new String[numberOfCourses][4];

        for (int i = 0; i < numberOfCourses; i++) {
            data[i][0] = Integer.toString(i + 1);
            data[i][1] = Main.courseList.get(i).getCourseName();
            data[i][2] = Main.courseList.get(i).getCourseCode();
            data[i][3] = Main.courseList.get(i).getCourseCoordinator();
        }
        System.out.println(ASCIITable.fromData(headers, data).toString());
    }
}
