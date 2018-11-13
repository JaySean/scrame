package scrame;

public class AddCourse {

    final static String courseFile = "data/Courses.txt";

    public static void run() {

        PrintCourse.run();

        boolean repeat;

        String courseName = Input.getCourseName();
        String courseCode = Input.newCourseCode();
        String courseCoordinator = Input.getCourseCoordinator();
        int courseCapacity = Input.getCourseCapacity();
        int tutNumber = Input.getTutNumber();
        int labNumber = Input.getLabNumber();

        // * need to tidy up
        // Get exam and coursework percentages
        int examPercent = 0;
        int courseWorkPercent = 0;
        repeat = true;
        while (repeat) {
            try {
                System.out.println("Exam and Coursework Weights:");
                examPercent = Input.getExamPercent();
                courseWorkPercent = Input.getCourseWorkPercent();
                if (examPercent + courseWorkPercent != 100 && examPercent > 0 && courseWorkPercent > 0)
                    throw new Exception("Exam and Course Work percentages must total 100 and there must be an Exam and Coursework component");
                repeat = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Get assignment and class participation percentages
        int assignmentPercent = 0;
        int classPartPercent = 0;
        repeat = true;
        while (repeat) {
            try {
                System.out.println("Assignment and Class Participation Weights:");
                assignmentPercent = Input.getAssignmentPercent();
                classPartPercent = Input.getClassPartPercent();
                if (assignmentPercent + classPartPercent != 100) {
                    throw new Exception("Assignment and Class Participation percentage must total 100");
                }
                repeat = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Create new instance of course
        Course course = new Course(
                courseName, courseCode, courseCoordinator,
                courseCapacity, tutNumber, labNumber,
                examPercent, courseWorkPercent, assignmentPercent, classPartPercent);

        // Add course to array
        Main.courseList.add(course);

        // Print list of ALL courses
        PrintCourse.run();

        // Write array to file
        DatabaseManager.write(Main.courseList, courseFile);
    }
}
