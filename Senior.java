
public class Senior extends HSStudent {

	private boolean portfolioDone;
	private double fines;

	public Senior() {
		super();
	}

	public Senior(String fn, String ln, int g, double q, boolean p, double f) {
		super(fn, ln, g, q);
		portfolioDone = p;
		fines = f;
	}

	public String convertGrade(int input) {
		if (input == 12) {
			return "Senior";
		} else {
			return Integer.toString(input);
		}
	}

	public String toString() {
		String portfolioOut = Boolean.toString(portfolioDone);
		String finesOut = Double.toString(Math.round(fines * 100.0) / 100.0);
		return super.toString() + "\nPortfolio Complete: " + portfolioOut + "\nFines: $" + finesOut;
	}

}
