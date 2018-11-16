package scrame.course.sessions;

/**
 * Subclass of session
 * There is only 1 lecture session
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class Lecture extends Session {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new lecture session
	 *
	 * @param capacity Total number of students that can register for the course
	 */
	public Lecture(int capacity) {
		this.capacity = capacity;
		this.vacancy = capacity;
		studentList = new String[vacancy];
	}
}
