package scrame.course.components;

/**
 * Subclass of Components used in calculating weightage of classpart
 * @author CZ2002 SS3 Group 1
 */

public class ClassPart extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * method that receives the percentage of class part to be serialized
     * @param percentage weightage for a component
     */
    public ClassPart(int percentage) {
        super(percentage);
    }
}
