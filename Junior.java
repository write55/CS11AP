
public class Junior extends HSStudent {

	private String keystoneScore;

	public Junior() {
		super();
	}

	public Junior(String fn, String ln, int g, double q, String ks) {
		super(fn, ln, g, q);
		keystoneScore = ks;
	}

	public String convertGrade(int input) {
		if (input == 11) {
			return "Junior";
		} else {
			return Integer.toString(input);
		}
	}

	public String toString() {
		return super.toString() + "Algebra Keystone Score: " + keystoneScore;
	}
}
