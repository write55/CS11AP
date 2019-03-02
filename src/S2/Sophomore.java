package S2;

public class Sophomore extends HSStudent {

    private char mathGrade;

    public Sophomore() {
        super();
    }

    public Sophomore(String fn, String ln, int g, double q, char mg) {
        super(fn, ln, g, q);
        mathGrade = mg;
    }

    public char getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(char mg) {
        mathGrade = mg;
    }

    public String convertGrade(int input) {
        if (input == 10) {
            return "S2.Sophomore";
        } else {
            return Integer.toString(input);
        }
    }

    public String toString() {
        return super.toString() + "\nMath Grade S2.Freshman Year: " + mathGrade;

    }

}
