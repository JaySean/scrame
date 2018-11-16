package scrame.course.components;

import java.io.Serializable;

/**
 * Superclass of components of a course which students are graded on
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public class Components implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Weightage of the component
     */
    private int percentage;

    /**
     * Creates a new component
     *
     * @param percentage Weightage of the component
     */
    Components(int percentage) {
        this.percentage = percentage;
    }

    /**
     * Gets the component's weightage
     *
     * @return the weightage for component
     */
    public int getPercentage() {
        return percentage;
    }

}
