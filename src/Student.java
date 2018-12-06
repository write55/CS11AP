
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

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCourse(char course) {
        this.course = course;
    }

    // Convert code to full string, doesn't use private data so static
    public static String convertCode(char code) {
        switch (code) {
            case code1:
                return course1;
            case code2:
                return course2;
            case code3:
                return course3;
            case code4:
                return course4;
            case code5:
                return course5;
            case code6:
                return course6;
            default:
                return "Incorrect Course Code";
        }
    }

    // TOSTRING
    public String toString() {
        return "Id: " + getId() + "\nScore: " + getScore() + "\nCourse: " + convertCode(getCourse());
    }

}
