package scrame.print;

import scrame.course.Course;

/**
 * Prints student list based on selected strategy
 *
 * @author CZ2002 SS3 Group 1
 * @version 3.0
 */
class PrintContext {
    private PrintStrategy strategy;

    /**
     * Creates a context for the strategy pattern
     *
     * @param strategy selected print strategy
     */
    PrintContext(PrintStrategy strategy) {
        this.strategy = strategy;
    }

    void beginPrint(Course course) {
        strategy.print(course);
    }
}
