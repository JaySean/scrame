package scrame.course;

import scrame.DatabaseManager;
import scrame.Main;

import java.io.*;

/**
 * Control class for Course
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class CourseManager implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Location of data of courses
     */
    private final static String courseFile = "data/Courses.txt";

    /**
     * Get the course from the array list of courses based on the unique course code
     *
     * @param courseCode Code of a course that unique to each course
     * @return The course with the particular course code
     */
    public static Course getCourse(String courseCode) {
        Course c;
        for (int i = 0; i < Main.courseList.size(); i++) {
            c = Main.courseList.get(i);
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Gets the index position of a course in the array list of courses
     *
     * @param courseCode Code of a course that unique to each course
     * @return The index position of the course in the array list of coruses
     */
    static int getIndex(String courseCode) {
        Course c;
        for (int i = 0; i < Main.courseList.size(); i++) {
            c = Main.courseList.get(i);
            if (c.getCourseCode().equals(courseCode)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * If the course is new and being added, it is appended to the end of the list of courses
     * If the course is being amended, it is updated in its previous index of the list
     *
     * @param course Course object bring updated
     */
    public static void updateCourse(Course course) {
        if (course == null) return;
        int index = getIndex(course.getCourseCode());
        if (index == -1) {
            Main.courseList.add(course);
        } else {
            Main.courseList.set(index, course);
        }
        DatabaseManager.write(Main.courseList, courseFile);
    }
}
