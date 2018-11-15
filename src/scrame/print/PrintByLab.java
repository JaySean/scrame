package scrame.print;

import scrame.course.Course;
import scrame.course.sessions.Laboratory;

public class PrintByLab implements PrintStrategy {
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
        return;
    }
}

