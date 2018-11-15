package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Tutorial;

public class PrintStudentListByTut implements PrintStudentListStrategy {
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
        return;
    }
}

