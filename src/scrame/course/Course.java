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
 * A course has a course code starting with 2 capital letter and 4 integers
 * A course name is unique but it could have as many course components as other courses
 * @author CZ2002 SS3 Group 1
 * @Verson 5.0
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Name of the course.
     */
    private String courseName;
    /**
     * Code of the course that is unique to it.
     */
    private String courseCode;
    /**
     * Name of course coordinator
     */
    private String courseCoordinator;

    ArrayList<Session> session;
    ArrayList<Components> components;

    /**
     *
     * @param courseName Name of course
     * @param courseCode Course code unique to course
     * @param courseCoordinator Name of course coordinator
     * @param courseVacancy Vacancies in a course
     * @param tutNumber Tutorial session number
     * @param labNumber lab session number
     * @param examPercent marks of exams
     * @param courseWorkPercent marks of coursework
     * @param assignmentPercent marks of assignment as part of coursework
     * @param classPartPercent marks of classpart as part of coursework
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
     * @param courseVacancy
     * @param tutNumber
     * @param labNumber
     * @return the array list of the session that has been instantiated
     */
    private static ArrayList<Session> constructSessionsList(
            int courseVacancy,
            int tutNumber,
            int labNumber
    ) {
        // Create arraylist of lecture, tutorial and lab
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
     * Array list to store the exam and coursework grades
     * @param examPercent
     * @param courseWorkPercent
     * @param assignmentPercent
     * @param classPartPercent
     * @return the array list of the components that has been instantiated
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
     * getter method to get course name
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * getter method to get course code
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * getter method to get name of course coordinator
     * @return the name of the course coordinator
     */
    public String getCourseCoordinator() {
        return courseCoordinator;
    }

    // Check existence

    /**
     * checks existence of matric number that has been inputted
     * @param matricNo
     * @return a boolean value of whether or not a student exists.
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
     * Checks existence of an Exam component
     * @return whether or not the component exists.
     */
    public boolean hasExam() {
        return getExamComponent().getPercentage() != 0;
    }

    /**
     * Checks existence of an assignment
     * @return whether or not the component exists.
     */
    public boolean hasAssignment() {
        return getAssignmentComponent().getPercentage() != 0;
    }

    /**
     * Checks existence of a classpart component in the course
     * @return whether or not the component exists.
     */
    public boolean hasClassPart() {
        return getClassPartComponent().getPercentage() != 0;
    }

    // Get components

    /**
     * getter method for the exam component in the course
     * @return null
     */
    public Exam getExamComponent() {
        if (components != null) return (Exam) components.get(0);
        return null;
    }

    /**
     * getter method for the assignment component in the course
     * @return
     */
    public Assignment getAssignmentComponent() {
        if (components != null) return (Assignment) components.get(1);
        return null;
    }

    /**
     * getter method for the classpart component in the course
     * @return null
     */
    public ClassPart getClassPartComponent() {
        if (components != null) return (ClassPart) components.get(2);
        return null;
    }

    // Get session

    /**
     * getter method for the tutorial sessions stored in an array list
     * @return relevant tutorial session user is looking for
     */
    public ArrayList<Tutorial> getTutorials() {
        ArrayList<Tutorial> tutorials = new ArrayList<>(0);
        if (session != null) {
            for (Session aSession : session) {
                if (aSession instanceof Tutorial) tutorials.add((Tutorial) aSession);
            }
        }
        return tutorials;
    }

    /**
     * getter method for the lecture sessions stored in an array list
     * @return relevant lecture session user is looking for
     */
    public ArrayList<Lecture> getLectures() {
        ArrayList<Lecture> lectures = new ArrayList<>(0);
        if (session != null) {
            for (Session aSession : session) {
                if (aSession instanceof Lecture) lectures.add((Lecture) aSession);
            }
        }
        return lectures;
    }

    /**
     * getter method for the lab sessions stored in an array list
     * @return relevant laboratories user is looking for
     */
    public ArrayList<Laboratory> getLaboratories() {
        ArrayList<Laboratory> labs = new ArrayList<>(0);
        if (session != null) {
            for (Session aSession : session) {
                if (aSession instanceof Laboratory) labs.add((Laboratory) aSession);
            }
        }
        return labs;
    }

}
