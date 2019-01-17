package Semester1;
// Aaron Wu
// 10/17/18

public class InterestProgram {

	public static void main(String[] args) {
		double startingValue = 1000.00;
		int startingInterest = 6; // Enter as percent

		// Used a separate interest variable for convenience
		for (int interest = startingInterest; interest <= 12; interest++) {
			System.out.println("------- Interest rate is " + interest + "% -------");
			for (int year = 0; year <= 10; year++) {
				double value = (int) (startingValue * Math.pow(1 + interest / 100.0, year) * 100.0 + .5) / 100.0;
				System.out.println("Investment at year " + year + " is $" + value);
			}
		}
	}
}
