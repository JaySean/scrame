package scrame.print;

import scrame.course.Course;

public class PrintContext {
    private PrintStrategy strategy;

    public PrintContext(PrintStrategy strategy){
        this.strategy = strategy;
    }

    public void beginPrint(Course course){
        strategy.print(course);
    }
}
