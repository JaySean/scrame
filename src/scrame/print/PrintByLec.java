package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Lecture;
/**
 * Holds methods used to print out the list of students in a particular lecture session of a course
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class PrintByLec implements PrintStrategy {
    /**
     * inherited method from interface PrintStrategy to print out the list of students in a particular lecture session of a course
     * @param course object of Class course type
     */
    public void print(Course course) {
        System.out.println("\nStudents in " + course.getCourseCode() + " " + course.getCourseName() + " Lectures");
        int index = 1;
        String[] studentList;
        for (Lecture lec : course.getLectures()) {
            System.out.println("Lecture " + index);
            studentList = lec.getStudentList();
            for (String student : studentList) {
                if (student != null) {
                    System.out.println(student);
                }
            }
            index++;
        }
        return;
    }
}


