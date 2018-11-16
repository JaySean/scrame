package scrame.print;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import scrame.*;
import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.StudentCourse;

/**
 * Prints the transcript of all courses a student is registered for
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class PrintStudentTranscript {
    /**
     * Main method of PrintStudentTranscript method
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();

        for (StudentCourse studentCourse : Main.studentCourseList)
            if (studentCourse.getStudentMatric().equals(studentMatric)) {
                Course course = CourseManager.getCourse(studentCourse.getCourseCode());
                System.out.println();

                int number = 4;
                if (course.hasAssignment()) {
                    number++;
                }
                if (course.hasClassPart()) {
                    number++;
                }

                String[] headers = new String[]{"Course Name", "Course Code"};
                String[][] data = new String[number][2];
                data[0][0] = course.getCourseName();
                data[0][1] = course.getCourseCode();
                data[1][0] = "---Component---";
                data[1][1] = "---Marks---";


                data[2][0] = "Exam: " + course.getExamComponent().getPercentage() + "%";
                data[2][1] = Double.toString(studentCourse.getExamMarks());

                int i = 1;

                if (course.hasAssignment()) {
                    data[i + 2][0] = "Assignment: " + course.getAssignmentComponent().getPercentage() + "%";
                    data[i + 2][1] = Double.toString(studentCourse.getAssignmentMarks());
                    i++;
                }

                if (course.hasClassPart()) {
                    data[i + 2][0] = "Class Participation: " + course.getClassPartComponent().getPercentage() + "%";
                    data[i + 2][1] = Double.toString(studentCourse.getClassPartMarks());
                    i++;
                }

                // Calculates weighted overall marks
                double adjustedExam = (double) studentCourse.getExamMarks() * course.getExamComponent().getPercentage() / 100;
                double adjustedAssignment = (double) studentCourse.getAssignmentMarks() * course.getAssignmentComponent().getPercentage() / 100;
                double adjustedClassPart = (double) studentCourse.getClassPartMarks() * course.getClassPartComponent().getPercentage() / 100;
                double totalMarks = adjustedExam + adjustedAssignment + adjustedClassPart;

                data[i + 2][0] = "Total Marks";
                data[i + 2][1] = Double.toString(totalMarks);

                // Outputs data in an ASCII table
                System.out.println(ASCIITable.fromData(headers, data).toString());
                break;
            }
    }
}
