package scrame.course.components;

/**
 * Subclass of Components
 * Type of coursework
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class Assignment extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new assignment component
     *
     * @param percentage Weightage of assignment in coursework
     */
    public Assignment(int percentage) {
        super(percentage);
    }
}
