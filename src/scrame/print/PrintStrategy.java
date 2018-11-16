package scrame.print;

import scrame.course.Course;

/**
 * Interface for implementing the print strategy
 *
 * @author CZ2002 SS3 Group 1
 */
public interface PrintStrategy {
    /**
     * Abstract method to print out the list of students in a particular session of a course
     *
     * @param course
     */
    void print(Course course);
}
