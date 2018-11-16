package scrame.course.sessions;

/**
 * Subclass of session
 * The maximum number of tutorials is the number of vacancies in a course
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class Tutorial extends Session {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new tutorial session
	 *
	 * @param capacity Total number of students that can register for the session
	 */
	public Tutorial(int capacity) {
		this.capacity = capacity;
		this.vacancy = capacity;
		studentList = new String[vacancy];
	}
}
