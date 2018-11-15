package scrame.course;

import scrame.Input;
import scrame.course.sessions.Laboratory;
import scrame.course.sessions.Lecture;
import scrame.course.sessions.Tutorial;

import java.util.ArrayList;

/**
 * Prints the vacancies of each session of the course
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class CheckVacancy {
    /**
     * This is the main method of the CheckVacancy function
     */
    public static void run() {
        int index;

        String courseCode = Input.getCourseCode();

        Course course = CourseManager.getCourse(courseCode);

        ArrayList<Lecture> lectures = course.getLectures();
        ArrayList<Tutorial> tutorials = course.getTutorials();
        ArrayList<Laboratory> labs = course.getLaboratories();

        index = 1;
        for (Lecture lecture : lectures) {
            System.out.println(
                    "Lecture " + index + ": " +
                            lecture.getVacancy() + "/" +
                            lecture.getCapacity());
            index++;
        }

        index = 1;
        for (Tutorial tutorial : tutorials) {
            System.out.println(
                    "Tutorial " + index + ": " +
                            tutorial.getVacancy() + "/" +
                            tutorial.getCapacity());
            index++;
        }

        index = 1;
        for (Laboratory lab : labs) {
            System.out.println(
                    "Laboratory " + index + ": " +
                            lab.getVacancy() + "/" +
                            lab.getCapacity());
            index++;
        }
    }
}
