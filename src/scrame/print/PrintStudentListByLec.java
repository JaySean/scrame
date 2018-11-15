package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Lecture;

public class PrintStudentListByLec implements PrintStudentListStrategy {
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


