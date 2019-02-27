/*
Aaron Wu
2/21/19
Abstract Class for HSStudent, will be implemented with four grade levels
 */

public abstract class HSStudent implements Student, Comparable<HSStudent> {

    private String firstName;
    private String lastName;
    private int grade;
    private double qpa;

    public HSStudent() {
        super();
    }

    public HSStudent(String f, String l, int g, double q) {
        super();
        firstName = f;
        lastName = l;
        grade = g;
        qpa = q;
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

    public double getQpa() {
        return qpa;
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

    public void setQpa(double q) {
        this.qpa = q;
    }

    // positive if compare is grade/lexically higher, negative if lower
    public int compareTo(HSStudent compare) {
        if (this.grade == compare.getGrade()) {
            int firstValue = this.getFirstName().compareTo(compare.getFirstName());
            int lastValue = this.getLastName().compareTo(compare.getLastName());
            if (lastValue != 0) {
                return lastValue;
            } else if (firstValue != 0) {
                return firstValue;
            } else {
                return 0;
            }
        } else {
            return this.grade - compare.getGrade();
        }
    }

    public abstract String convertGrade(int input);

    public String toString() {
        return "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGrade: " + convertGrade(grade) + "\nQPA: "
                + qpa;
    }
}
