package S1;
/*
Aaron Wu
12/12/18
S2.Student class, contains constants for courses and codes
Private data: S2.Student id, score, course taken (code)
 */

public class Student {

    // CONSTANTS
    public static final char code1 = 'C';
    public static final String course1 = "Computer Science";
    public static final char code2 = 'E';
    public static final String course2 = "Education";
    public static final char code3 = 'M';
    public static final String course3 = "Mathematics";
    public static final char code4 = 'B';
    public static final String course4 = "Business";
    public static final char code5 = 'N';
    public static final String course5 = "Engineering";
    public static final char code6 = 'A';
    public static final String course6 = "Art";

    // PRIVATE DATA
    private int id;
    private int score;
    private char course;

    // CONSTRUCTOR
    public Student(int id, int score, char course) {
        this.id = id;
        this.score = score;
        this.course = course;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public char getCourse() {
        return course;
    }

    // SETTERS - setCourse never used
    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Converts code to full string, doesn't use private data so static
    public static String convertCode(char code) {
        if (Character.toUpperCase(code) == code1) {
            return course1;
        } else if (Character.toUpperCase(code) == code2) {
            return course2;
        } else if (Character.toUpperCase(code) == code3) {
            return course3;
        } else if (Character.toUpperCase(code) == code4) {
            return course4;
        } else if (Character.toUpperCase(code) == code5) {
            return course5;
        } else if (Character.toUpperCase(code) == code6) {
            return course6;
        } else {
            return "Incorrect Course Code";
        }
    }

    // TOSTRING
    public String toString() {
        return "Id: " + getId() + "\nScore: " + getScore() + "\nCourse: " + convertCode(getCourse());
    }

}