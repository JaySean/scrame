package scrame;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Scanner sc = new Scanner(System.in);

    private String courseName;
    private String courseCode;

    private String courseCoordinator;

    private int tutNumber;
    private int labNumber;

    ArrayList<Session> session;
    ArrayList<Components> components;

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
        this.tutNumber = tutNumber;
        this.labNumber = labNumber;
        this.components = constructComponentsList(examPercent, courseWorkPercent, assignmentPercent, classPartPercent);
    }

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

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseCoordinator() {
        return courseCoordinator;
    }

    public int getTutNumber() {
        return tutNumber;
    }

    public int getLabNumber() {
        return labNumber;
    }

    public ArrayList<Session> getSession() {
        return session;
    }

    public ArrayList<Components> getComponents() {
        return components;
    }

    public boolean hasStudent(String matricNo) {
        try {
            if (getLectures().get(0).hasStudent(matricNo)) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean hasVacancy() {
        try {
            if (getLectures().size() > 0) {
                return getLectures().get(0).getVacancy() > 0;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean hasExam() {
        return getExamComponent().getPercentage() != 0;
    }

    public boolean hasAssignment() {
        return getAssignmentComponent().getPercentage() != 0;
    }

    public boolean hasClassPart() {
        return getClassPartComponent().getPercentage() != 0;
    }

    public Exam getExamComponent() {
        if (components != null) return (Exam) components.get(0);
        return null;
    }

    public Assignment getAssignmentComponent() {
        if (components != null) return (Assignment) components.get(1);
        return null;
    }

    public ClassPart getClassPartComponent() {
        if (components != null) return (ClassPart) components.get(2);
        return null;
    }

    public int getComponentNo() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (this.getComponents().get(i).getPercentage() != 0) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Tutorial> getTutorials() {
        ArrayList<Tutorial> tutorials = new ArrayList<>(0);
        if (session != null) {
            for (Session aSession : session) {
                if (aSession instanceof Tutorial) tutorials.add((Tutorial) aSession);
            }
        }
        return tutorials;
    }

    public ArrayList<Lecture> getLectures() {
        ArrayList<Lecture> lectures = new ArrayList<>(0);
        if (session != null) {
            for (Session aSession : session) {
                if (aSession instanceof Lecture) lectures.add((Lecture) aSession);
            }
        }
        return lectures;
    }

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
