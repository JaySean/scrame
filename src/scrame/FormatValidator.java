package scrame;

public abstract class FormatValidator {
    public static void validateMatricNo(String newMatricNo) throws Exception {
        final String matricFormat = "[A-Z][0-9]{7}[A-Z]";
        if (!newMatricNo.matches(matricFormat)) {
            throw new Exception("Student matriculation number format invalid - Must begin and end with capital letters and have 7 digits in between");
        }
    }
    public static void validateCourseCode(String newCourseCode) throws Exception {
        final String courseCodeFormat = "[A-Z]{2}[0-9]{4}";
        if (!newCourseCode.matches(courseCodeFormat)) {
            throw new Exception("Course code format invalid - Must begin with 2 capital letters followed by 4 digits");
        }
    }

    public static void validateName(String name) throws Exception {
        final String nameFormat = "[A-z]+[A-z\\s]*";
        if (!name.matches(nameFormat)) {
            throw  new Exception("Name format invalid - Must contain only letters and spaces, it must also not be blank");
        }
    }

    public static void validateCourseName(String courseName) throws Exception {
        final String nameFormat = "[A-z0-9]+[A-z0-9\\s]*";
        if (!courseName.matches(nameFormat)) {
            throw  new Exception("Name format invalid - It must also not be blank");
        }
    }
}
