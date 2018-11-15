package scrame.course.sessions;

/**
 * Subclass of superclass Session that instantiates a Tutorial session
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class Tutorial extends Session {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor to initialize session capacity and vacancy
	 * @param capacity total capacity of a session
	 */
	public Tutorial(int capacity) {
		this.capacity = capacity;
		this.vacancy = capacity;
		studentList = new String[vacancy];
	}
}
