package scrame.course.components;

/**
 * Subclass of Components
 * Type of coursework
 *
 * @author CZ2002 SS3 Group 1
 *  @version 2.0
 */

public class ClassPart extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new class participation component
     *
     * @param percentage Weightage of class participation in coursework
     */
    public ClassPart(int percentage) {
        super(percentage);
    }
}
