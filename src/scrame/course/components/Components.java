package scrame.course.components;

import java.io.Serializable;

/**
 * Superclass that handles the serialization of scores obtained from a course
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public abstract class Components implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * weightage for a component
	 */
	private int percentage;

	/**
	 * Constructor for percentage
	 * @param percentage
	 */
	public Components(int percentage) {
		this.percentage = percentage;
	}

	/**
	 * Getter method for retrieving percentage
	 * @return
	 */
	public int getPercentage() {
		return percentage;
	}
	
}
