package scrame.print;

import scrame.course.Course;

/**
 * Context for implementing strategy pattern
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
public class PrintContext {
    private PrintStrategy strategy;

    public PrintContext(PrintStrategy strategy){
        this.strategy = strategy;
    }

    public void beginPrint(Course course){
        strategy.print(course);
    }
}
