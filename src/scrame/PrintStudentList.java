package scrame;

import java.util.Scanner;

public class PrintStudentList {

    static Scanner sc = new Scanner(System.in);

    public static void run() {

        String courseCode = Input.getCourseCode();
        Course course = CourseManager.getCourse(courseCode);

        printMenu();

        int choice = getChoice();

        switch (choice) {
            case 1:
                printListByLec(course);
                break;
            case 2:
                printListByTut(course);
                break;
            case 3:
                printListByLab(course);
                break;
            case 4:
                printListByLec(course);
                printListByTut(course);
                printListByLab(course);
                break;
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1 : Print student list by lecture");
        System.out.println("2 : Print student list by tutorial");
        System.out.println("3 : Print student list by laboratory session");
        System.out.println("4 : Print student list in all");
        System.out.println();
    }

    private static int getChoice() {
        try {
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();
            if (choice < 1 || choice > 4) {
                throw new Exception("Choice out of range! It must be from 1-4\n");
            }
            sc.nextLine();
            return choice;
        } catch (Exception e) {
            sc.nextLine();
            System.out.println(e.getMessage());
            return getChoice();
        }
    }

    private static void printListByLec(Course course) {
        if (course == null) return;
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
    }

    private static void printListByTut(Course course) {
        if (course == null) return;
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
    }

    private static void printListByLab(Course course) {
        if (course == null) return;
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
