package scrame.course.components;

/**
 * Subclass of Components
 *
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public class Exam extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new exam component
     *
     * @param percentage Weightage of exam
     */
    public Exam(int percentage) {
        super(percentage);
    }
}
