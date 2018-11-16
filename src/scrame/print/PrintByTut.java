package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Tutorial;

/**
 * Prints out the list of students in a particular tutorial session of a course
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class PrintByTut implements PrintStrategy {
    /**
     * Inherited method from PrintStrategy interface
     *
     * @param course Course object which contains the tutorial session
     */
    public void print(Course course) {
        System.out.println("\nStudents in " + course.getCourseCode() + " " + course.getCourseName() + " Tutorials");
        int index = 1;
        String[] studentList;
        for (Tutorial tut : course.getTutorials()) {
            System.out.println("Tutorial " + index);
            studentList = tut.getStudentList();
            for (String student : studentList) {
                if (student != null) {
                    System.out.println(student);
                }
            }
            index++;
        }
    }
}

