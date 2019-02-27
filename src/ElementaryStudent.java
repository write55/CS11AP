
public abstract class ElementaryStudent implements Student {

    private String firstName;
    private String lastName;
    private int grade;

    public ElementaryStudent() {
        super();
    }

    public ElementaryStudent(String f, String l, int g) {
        super();
        firstName = f;
        lastName = l;
        grade = g;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public void setGrade(int g) {
        grade = g;
    }

    public String toString() {
        String grade = Integer.toString(this.grade);
        if (grade.equals("0")) {
            grade = "k";
        }
        return "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "Grade" + grade;
    }

}
