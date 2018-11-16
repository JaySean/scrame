package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Laboratory;

/**
 * Prints out the list of students in a particular laboratory session of a course
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class PrintByLab implements PrintStrategy {
    /**
     * Inherited method from PrintStrategy interface
     *
     * @param course Course object which contains the laboratory session
     */
    public void print(Course course) {
        System.out.println("\nStudents in " + course.getCourseCode() + " " + course.getCourseName() + " Laboratories");
        int index = 1;
        String[] studentList;
        for (Laboratory lab : course.getLaboratories()) {
            System.out.println("Laboratory " + index);
            studentList = lab.getStudentList();
            for (String student : studentList) {
                if (student != null) {
                    System.out.println(student);
                }
            }
            index++;
        }
    }
}

