package scrame.course.components;

/**
 * subclass of Components used in calculating weightage of Exam
 * @author CZ2002 SS3 Group 1
 * @version 2.0
 */

public class Exam extends Components {

    private static final long serialVersionUID = 1L;

    /**
     * method that receives the percentage of exam to be serialized
     * @param percentage weightage for a component
     */
    public Exam(int percentage) {
        super(percentage);
    }
}
