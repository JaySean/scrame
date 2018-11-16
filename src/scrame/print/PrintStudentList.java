package scrame.print;

import scrame.*;
import scrame.course.*;

import java.util.Scanner;

/**
 * Console to choose option of printing student list
 * Prints by lecture group, tutorial group and/or laboratory group
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class PrintStudentList {

    static Scanner sc = new Scanner(System.in);

    /**
     * Main method of PrintStudentList function
     */
    public static void run() {

        String courseCode = Input.getCourseCode();
        Course course = CourseManager.getCourse(courseCode);

        printMenu();

        int choice = getChoice();

        switch (choice) {
            case 1:
                PrintContext context1 = new PrintContext(new PrintByLec());
                context1.beginPrint(course);
                break;
            case 2:
                PrintContext context2 = new PrintContext(new PrintByTut());
                context2.beginPrint(course);
            case 3:
                PrintContext context3 = new PrintContext(new PrintByLab());
                context3.beginPrint(course);
            case 4:
                PrintContext contextLec = new PrintContext(new PrintByLec());
                contextLec.beginPrint(course);
                PrintContext contextTut = new PrintContext(new PrintByTut());
                contextTut.beginPrint(course);
                PrintContext contextLab = new PrintContext(new PrintByLab());
                contextLab.beginPrint(course);
                break;
        }
    }

    /**
     * Displays menu of print options
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("1 : Print student list by lecture");
        System.out.println("2 : Print student list by tutorial");
        System.out.println("3 : Print student list by laboratory session");
        System.out.println("4 : Print student list in all");
        System.out.println();
    }

    /**
     * Gets the input of user's print choice
     * Validates input
     *
     * @return The print option that the user chose
     */
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
            Input.inputMismatchCapture(e);
            return getChoice();
        }
    }
}

