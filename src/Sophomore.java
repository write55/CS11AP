
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
			return "Sophomore";
		} else {
			return Integer.toString(input);
		}
	}

	public String toString() {
		String gradeOut = Double.toString(Math.round(mathGrade * 100.0) / 100.0);
		return super.toString() + "Math Grade Freshman Year: " + gradeOut;

	}

}
