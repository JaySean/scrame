package scrame;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;		
		do {
			showMenu();
			input = sc.nextInt();
			sc.nextLine();
			switch(input) {
			case 1:
				AddStudent.run();
				break;
			case 2:
				AddCourse.run();
				break;
			case 3:
				RegisterStudent.run();
				break;
			case 4:
				CheckVacancy.run();
				break;
			case 5:
				PrintStudentList.run();
				break;
			case 7:
				EnterCourseworkMarks.run();
				break;
			case 8:
				EnterExamMarks.run();
				break;
			default:
				break;
			}				
		}
		while (input != 11);

	}
	
	public static void showMenu() {
		System.out.println();
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Register student for a course");
		System.out.println("4: Check available slot in a class");
		System.out.println("5: Print student list by lecture, tutorial or laboratory session for a course");
		System.out.println("6: Enter course assessment components weightage");
		System.out.println("7: Enter coursework mark – inclusive of its components");
		System.out.println("8: Enter exam mark");
		System.out.println("9: Print course statistics");
		System.out.println("10: Print student transcript");
		System.out.println("11: Quit");
	}

}
