package scrame.course;

import scrame.course.components.Assignment;
import scrame.course.components.ClassPart;
import scrame.course.components.Components;
import scrame.course.components.Exam;
import scrame.course.sessions.Laboratory;
import scrame.course.sessions.Lecture;
import scrame.course.sessions.Session;
import scrame.course.sessions.Tutorial;

import java.io.Serializable;
import java.util.*;

/**
 * Represents the course that a student could be enrolled in
 * A course has a course code that is unique to it
 *
 * @author CZ2002 SS3 Group 1
 * @version 5.0
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Name of the course.
     */
    private String courseName;
    /**
     * Unique code of the course
     */
    private String courseCode;
    /**
     * Name of the course coordinator
     */
    private String courseCoordinator;

    ArrayList<Session> session;
    ArrayList<Components> components;

    /**
     * Creates a new course
     *
     * @param courseName        Name of the course
     * @param courseCode        Unique course code
     * @param courseCoordinator Name of the course coordinator
     * @param courseVacancy     Vacancies available in the course
     * @param tutNumber         Number of tutorial sessions
     * @param labNumber         Number of laboratory sessions
     * @param examPercent       Weightage of exams
     * @param courseWorkPercent Weightage of coursework
     * @param assignmentPercent Weightage of assignment as part of coursework
     * @param classPartPercent  Weightage of class participation as part of coursework
     */
    public Course(
            String courseName,
            String courseCode,
            String courseCoordinator,
            int courseVacancy,
            int tutNumber,
            int labNumber,
            int examPercent,
            int courseWorkPercent,
            int assignmentPercent,
            int classPartPercent
    ) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCoordinator = courseCoordinator;
        this.session = constructSessionsList(courseVacancy, tutNumber, labNumber);
        this.components = constructComponentsList(examPercent, courseWorkPercent, assignmentPercent, classPartPercent);
    }

    /**
     * Array list to store the course vacancy and lab & tutorial session numbers
     *
     * @param courseVacancy Vacancies available in the course
     * @param tutNumber     Number of tutorial sessions
     * @param labNumber     Number of laboratory sessions
     * @return The array list of all the sessions of the course, together with their respective capacities
     */
    private static ArrayList<Session> constructSessionsList(
            int courseVacancy,
            int tutNumber,
            int labNumber
    ) {
        // Create array list of lecture, tutorial and lab
        ArrayList<Session> session = new ArrayList<>(1 + tutNumber + labNumber);

        // Create new instance of lecture
        Session lecture = new Lecture(courseVacancy);
        session.add(lecture);

        // Create new instance(s) of tutorial
        for (int i = 1; i < 1 + tutNumber; i++) {
            session.add(new Tutorial((int) (Math.ceil((double) courseVacancy / tutNumber))));
        }

        // Create new instance(s) of lab
        for (int i = 1; i < 1 + labNumber; i++) {
            session.add(new Laboratory((int) (Math.ceil((double) courseVacancy / labNumber))));
        }
        return session;
    }

    /**
     * Array list to store the exam and coursework weightages
     *
     * @param examPercent       Weightage of exams
     * @param courseWorkPercent Weightage of coursework
     * @param assignmentPercent Weightage of assignment as part of coursework
     * @param classPartPercent  Weightage of class participation as part of coursework
     * @return The array list of all the components of the course, together with their respective weightages
     */
    private static ArrayList<Components> constructComponentsList(
            int examPercent,
            int courseWorkPercent,
            int assignmentPercent,
            int classPartPercent
    ) {
        ArrayList<Components> components = new ArrayList<>(3);
        Exam exam = new Exam(examPercent);
        components.add(exam);
        Assignment assignment = new Assignment(assignmentPercent * courseWorkPercent / 100);
        components.add(assignment);
        ClassPart classPart = new ClassPart(classPartPercent * courseWorkPercent / 100);
        components.add(classPart);

        return components;
    }

    /**
     * Get the name of the course
     *
     * @return The course's name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get the code of the course
     *
     * @return The course's code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Get the name of the course coordinator
     *
     * @return The course coordinator's name
     */
    public String getCourseCoordinator() {
        return courseCoordinator;
    }

    // Check existence

    /**
     * Checks whether a particular student has previously registered for the course
     *
     * @param matricNo The student's matriculation number
     * @return A boolean value of whether a student is registered for the course
     */
    public boolean hasStudent(String matricNo) {
        try {
            if (getLectures().get(0).hasStudent(matricNo)) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Checks whether the course has an exam component
     *
     * @return A boolean value of whether the course has an exam component
     */
    public boolean hasExam() {
        return getExamComponent().getPercentage() != 0;
    }

    /**
     * Checks whether the course has an assignment component
     *
     * @return A boolean value of whether the course has an assignment component
     */
    public boolean hasAssignment() {
        return getAssignmentComponent().getPercentage() != 0;
    }

    /**
     * Checks whether the course has a class participation component
     *
     * @return A boolean value of whether the course has a class participation component
     */
    public boolean hasClassPart() {
        return getClassPartComponent().getPercentage() != 0;
    }

    // Components

    /**
     * Get the exam component of the course
     *
     * @return The exam object of the course
     */
    public Exam getExamComponent() {
        if (components != null) return (Exam) components.get(0);
        return null;
    }

    /**
     * Get the assignment component of the course
     *
     * @return The assignment component of the course
     */
    public Assignment getAssignmentComponent() {
        if (components != null) return (Assignment) components.get(1);
        return null;
    }

    /**
     * Get the class participation component of the course
     *
     * @return The class participation component of the course
     */
    public ClassPart getClassPartComponent() {
        if (components != null) return (ClassPart) components.get(2);
        return null;
    }

    // Sessions

    /**
     * Get the lecture session of the course
     *
     * @return The list of lecture session of the course
     */
    public ArrayList<Lecture> getLectures() {
        ArrayList<Lecture> lectures = new ArrayList<>(0);
        if (session != null) {
            for (Session session : session) {
                if (session instanceof Lecture) lectures.add((Lecture) session);
            }
        }
        return lectures;
    }

    /**
     * Get the tutorial session(s) of the course
     *
     * @return The list of tutorial session(s) of the course
     */
    public ArrayList<Tutorial> getTutorials() {
        ArrayList<Tutorial> tutorials = new ArrayList<>(0);
        if (session != null) {
            for (Session session : session) {
                if (session instanceof Tutorial) tutorials.add((Tutorial) session);
            }
        }
        return tutorials;
    }


    /**
     * Get the laboratory session(s) of the course
     *
     * @return The list of laboratory session(s) of the course
     */
    public ArrayList<Laboratory> getLaboratories() {
        ArrayList<Laboratory> labs = new ArrayList<>(0);
        if (session != null) {
            for (Session session : session) {
                if (session instanceof Laboratory) labs.add((Laboratory) session);
            }
        }
        return labs;
    }
}
