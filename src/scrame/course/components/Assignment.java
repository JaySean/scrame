package scrame.course.components;

/**
 * subclass of Components used in calculating weightage of Assignment
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */
public class Assignment extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * method that receives the percentage of assignment to be serialized
     * @param percentage marks of the component
     */
    public Assignment(int percentage) {
        super(percentage);
    }
}
