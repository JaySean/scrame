package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.Main;

public class PrintCourse {

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
