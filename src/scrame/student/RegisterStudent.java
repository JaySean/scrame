package scrame.student;

import scrame.Input;
import scrame.course.sessions.Tutorial;
import scrame.course.Course;
import scrame.course.CourseManager;
import scrame.course.sessions.Laboratory;
import scrame.course.sessions.Lecture;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student registers for a course by selecting sessions (lectures, tutorials, laboratories) that have a vacancy
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class RegisterStudent {

    static Scanner sc = new Scanner(System.in);

    /**
     * This is the main method of the RegisterStudent function
     */
    public static void run() {

        String studentMatric = Input.getStudentMatric();
        String courseCode = Input.getCourseFromStudent(studentMatric);

        Course course = CourseManager.getCourse(courseCode);

        // Select Lecture
        registerLecture(studentMatric, course);
        // Select Tutorial
        registerTutorial(studentMatric, course);
        // Select Laboratory
        registerLaboratory(studentMatric, course);
        // Amends the course list with the updated course
        CourseManager.updateCourse(course);
    }

    /**
     * Student registers for the lecture session of the course
     * There is only 1 lecture available to choose from
     *
     * @param studentMatric Student's matriculation number
     * @param course        Course that the student is registering for
     */
    private static void registerLecture(String studentMatric, Course course) {
        if (course == null) return;
        if (course.getLectures().size() == 0) return;
        ArrayList<Lecture> lectures = course.getLectures();
        int index = 1;
        try {
            System.out.println("Select Lecture Session:");
            // Print Lectures
            for (Lecture lecture : lectures) {
                System.out.println("Lecture " + index + ": " + lecture.getVacancy() + " vacancies");
                index++;
            }
            int choice = sc.nextInt();
            // Check choice validity
            if (choice > lectures.size() || choice < 1) {
                throw new Exception("No such lecture!");
            }
            sc.nextLine();
            // Add Student to Course
            lectures.get(choice - 1).addStudent(studentMatric);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println(e.getMessage());
            registerLecture(studentMatric, course);
        }
    }

    /**
     * Student registers for a tutorial session of the course
     * Student has to select a tutorial session that has available slots
     *
     * @param studentMatric Student's matriculation number
     * @param course        Course that the student is registering for
     */
    private static void registerTutorial(String studentMatric, Course course) {
        if (course == null) return;
        if (course.getTutorials().size() == 0) return;
        ArrayList<Tutorial> tutorials = course.getTutorials();
        int index;
        try {
            int choice;
            index = 1;
            System.out.println("Select Tutorial Session:");
            // Print tutorials
            for (Tutorial tutorial : tutorials) {
                System.out.println("Tutorial " + index + ": " + tutorial.getVacancy() + " vacancies");
                index++;
            }
            choice = sc.nextInt();
            // Check choice validity
            if (choice > tutorials.size() || choice < 1) {
                throw new Exception("No such tutorial!");
            }
            if (tutorials.get(choice - 1).getVacancy() == 0) {
                throw new Exception("No vacancies!");
            }
            sc.nextLine();
            // Add Student to Course
            tutorials.get(choice - 1).addStudent(studentMatric);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println(e.getMessage());
            registerTutorial(studentMatric, course);
        }
    }

    /**
     * Student registers for a laboratory session of the course
     * Student has to select a laboratory session that has available slots
     *
     * @param studentMatric Student's matriculation number
     * @param course        Course that the student is registering for
     */
    private static void registerLaboratory(String studentMatric, Course course) {
        if (course == null) return;
        if (course.getLaboratories().size() == 0) ;
        ArrayList<Laboratory> laboratories = course.getLaboratories();
        int index;
        try {
            int choice;
            index = 1;
            System.out.println("Select Laboratory Session:");
            // Print Laboratories
            for (Laboratory laboratory : laboratories) {
                System.out.println("Lab " + index + ": " + laboratory.getVacancy() + " vacancies");
                index++;
            }
            choice = sc.nextInt();
            // Check choice validity
            if (choice > laboratories.size() || choice < 1) {
                throw new Exception("No such laboratory!");
            }
            if (laboratories.get(choice - 1).getVacancy() == 0) {
                throw new Exception("No vacancies!");
            }
            sc.nextLine();
            // Add Student to Course
            laboratories.get(choice - 1).addStudent(studentMatric);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println(e.getMessage());
            registerLaboratory(studentMatric, course);
        }
    }
}

