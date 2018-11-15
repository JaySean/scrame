package scrame.course.sessions;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Superclass that serializes and initializes a Session
 * @author CZ2002 SS3 Group 1
 */
public abstract class Session implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Capacity of a session
	 */
	protected int capacity;
	/**
	 * Vacancy of a session
	 */
	protected int vacancy;
	/**
	 * string to store the list of students added to a session
	 */
	public String[] studentList = new String[capacity];

	/**
	 * getter method to get vacancy of session
	 * @return
	 */
	public int getVacancy() {
		return vacancy;
	}

	/**
	 * getter method to get capacity of session
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * getter method to return the list of students
	 * @return
	 */
	public String[] getStudentList() {
		return studentList;
	}

	/**
	 * method to add a student to a session
	 * @param studentMatric
	 */
	public void addStudent(String studentMatric) {
		studentList[capacity - vacancy] = studentMatric;
		vacancy--;
	}

	/**
	 * method to check for an existence of a student using matric number
	 * @param studentMatric
	 * @return
	 */
	public boolean hasStudent(String studentMatric) {
		for (String student : studentList) {
			if (student.equals(studentMatric)) return true;
		}
		return false;
	}
}
