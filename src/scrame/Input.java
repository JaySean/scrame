package scrame;

import java.util.Scanner;

public class Input {

    static Scanner sc = new Scanner(System.in);

    // Student
    public static String getStudentName() {
        String studentName;
        while (true) {
            try {
                System.out.println("Enter Student's Name");
                studentName = sc.nextLine();
                InputValidator.studentNameFormat(studentName);
                return studentName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getStudentMatric() {
        String studentMatric;
        while (true) {
            try {
                System.out.println("Enter Student's Matriculation Number");
                studentMatric = sc.nextLine();
                InputValidator.studentMatricFormat(studentMatric);
                InputValidator.existStudentMatric(studentMatric);
                return studentMatric;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String newStudentMatric() {
        String studentMatric;
        while (true) {
            try {
                System.out.println("Enter Student's Matriculation Number");
                studentMatric = sc.nextLine();
                InputValidator.studentMatricFormat(studentMatric);
                InputValidator.newStudentMatric(studentMatric);
                return studentMatric;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Course
    public static String getCourseName() {
        String courseName;
        while (true) {
            try {
                System.out.println("Enter Course Name");
                courseName = sc.nextLine();
                InputValidator.courseNameFormat(courseName);
                return courseName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getCourseCode() {
        String courseCode;
        while (true) {
            try {
                System.out.println("Enter Course Code");
                courseCode = sc.nextLine();
                InputValidator.courseCodeFormat(courseCode);
                InputValidator.existCourseCode(courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String newCourseCode() {
        String courseCode;
        while (true) {
            try {
                System.out.println("Enter Course Code");
                courseCode = sc.nextLine();
                InputValidator.courseCodeFormat(courseCode);
                InputValidator.newCourseCode(courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getCourseCoordinator() {
        String courseCoordinator;
        while (true) {
            try {
                System.out.println("Enter Course Coordinator");
                courseCoordinator = sc.nextLine();
                InputValidator.studentNameFormat(courseCoordinator);
                return courseCoordinator;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getCourseCapacity() {
        int courseCapacity;
        while (true) {
            try {
                System.out.println("Enter Course Capacity");
                courseCapacity = sc.nextInt();
                if (courseCapacity < 1)
                    throw new Exception("There must be at least a capacity of 1!");
                sc.nextLine();
                return courseCapacity;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getTutNumber() {
        int tutNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Tutorial Class");
                tutNumber = sc.nextInt();
                if (tutNumber < 0)
                    throw new Exception("Number cannot be negative!");
                sc.nextLine();
                return tutNumber;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getLabNumber() {
        int labNumber;
        while (true) {
            try {
                System.out.println("Enter Number of Laboratory Class");
                labNumber = sc.nextInt();
                if (labNumber < 0)
                    throw new Exception("Number cannot be negative!");
                sc.nextLine();
                return labNumber;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getExamPercent() {
        int examPercent;
        while (true) {
            try {
                System.out.println("Enter Exam Percentage:");
                examPercent = sc.nextInt();
                InputValidator.validatePercentage(examPercent);
                sc.nextLine();
                return examPercent;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getCourseWorkPercent() {
        int courseWorkPercent;
        while (true) {
            try {
                System.out.println("Enter Coursework Percentage:");
                courseWorkPercent = sc.nextInt();
                InputValidator.validatePercentage(courseWorkPercent);
                sc.nextLine();
                return courseWorkPercent;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getAssignmentPercent() {
        int assignmentPercent;
        while (true) {
            try {
                System.out.println("Enter Assignment Percentage:");
                assignmentPercent = sc.nextInt();
                InputValidator.validatePercentage(assignmentPercent);
                sc.nextLine();
                return assignmentPercent;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getClassPartPercent() {
        int classPartPercent;
        while (true) {
            try {
                System.out.println("Enter Class Participation Percentage:");
                classPartPercent = sc.nextInt();
                InputValidator.validatePercentage(classPartPercent);
                sc.nextLine();
                return classPartPercent;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }

    // Student and Course
    public static String getCourseFromStudent(String studentMatric){
        String courseCode;
        while (true) {
            try {
                courseCode = Input.getCourseCode();
                InputValidator.studentCourse(studentMatric, courseCode);
                return courseCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
