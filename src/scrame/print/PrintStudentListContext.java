package scrame.print;

import scrame.course.Course;

public class PrintStudentListContext {
    private PrintStudentListStrategy strategy;

    public PrintStudentListContext(PrintStudentListStrategy strategy){
        this.strategy = strategy;
    }

    public void beginPrint(Course course){
        strategy.print(course);
    }
}
