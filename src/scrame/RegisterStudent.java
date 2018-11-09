package scrame;
import java.util.Scanner;

public class RegisterStudent {

	public static void run() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Course Code"); // check validity: whether course exits
		String registerCourseCode = sc.nextLine();

		System.out.println("Enter Student Matriculation Number"); // check validity: whether student exits
		String registerStudentMatric = sc.nextLine();

		int choice;

		Course course = CourseManager.getCourse(registerCourseCode);
		int courseIndex = CourseManager.getCourseIndex(registerCourseCode);

		// Select Lecture
		System.out.println("Select Lecture Session:");
		System.out.println("Lecture 1: " + course.getSession().get(0).getVacancy() + " vacancy");
		choice = sc.nextInt() - 1;

		int lecCapacity = course.getSession().get(choice).getCapacity();
		int lecVacancy = course.getSession().get(choice).getVacancy();

		String[] lecList = course.getSession().get(choice).getStudentList();
		lecList[lecCapacity - lecVacancy] = registerStudentMatric;
		course.getSession().get(choice).setStudentList(lecList);
		course.getSession().get(choice).setVacancy(lecVacancy - 1);

		// Select Tutorial
		System.out.println("Select Tutorial Session:");
		for (int i = 1; i < 1 + course.getTutNumber(); i++) {
			System.out.println("Tutorial " + i + ": " + course.getSession().get(i).getVacancy() + " vacancy");
		}
		choice = sc.nextInt();

		int tutCapacity = course.getSession().get(choice).getCapacity();
		int tutVacancy = course.getSession().get(choice).getVacancy();

		String[] tutList = course.getSession().get(choice).getStudentList();
		tutList[tutCapacity - tutVacancy] = registerStudentMatric;
		course.getSession().get(choice).setStudentList(tutList);
		course.getSession().get(choice).setVacancy(tutVacancy - 1);

		// Select Laboratory
		System.out.println("Select Laboratory Session:");
		for (int j = 1 + course.getTutNumber(); j < 1 + course.getTutNumber() + course.getLabNumber(); j++) {
			System.out.println("Laboratory " + (j - course.getTutNumber()) + ": " + course.session.get(j).getVacancy()
					+ " vacancy");
		}
		choice = sc.nextInt() + course.getTutNumber();
		int labCapacity = course.getSession().get(choice).getCapacity();
		int labVacancy = course.getSession().get(choice).getVacancy();

		String[] labList = course.getSession().get(choice).getStudentList();
		labList[labCapacity - labVacancy] = registerStudentMatric;
		course.getSession().get(choice).setStudentList(labList);
		course.getSession().get(choice).setVacancy(labVacancy - 1);

		CourseManager.updateCourse(courseIndex, course);
	}
}

