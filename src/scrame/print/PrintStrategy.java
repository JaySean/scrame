package scrame.print;

import scrame.course.Course;

/**
 * interface for implementing print strategy
 * @author CZ2002 SS3 Group 1
 */
public interface PrintStrategy {
    /**
     * abstract method print to be inherited
     * @param course
     */
    void print(Course course);
}
