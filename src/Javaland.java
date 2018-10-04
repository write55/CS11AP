
// Aaron Wu
// 9/28/18
// Program taxes input from the user creates a "Javaland" object to store the income.
// It then uses if statements in the applytax() method to calculate taxes and then prints out the result.

import java.io.*;

public class Javaland {

    // DECLARE CONSTANTS
    public final static double PERCENT1 = .01;
    public final static double PERCENT2 = .05;
    public final static double PERCENT3 = .1;
    public final static int LIVINGFEE = 500;
    public final static int LIVINGLIMIT = 1000;
    public final static int LIM1 = 10000;
    public final static int LIM2 = 30000;

    // PRIVATE DATA
    private int income = 0;

    // Constructor for a new "Javaland" object, assigns argument to object
    public Javaland(int i) {
        income = i;
    }

    // Getter for Javaland current value
    public int getIncome() {
        return income;
    }

    // Setter for changing value of existing "Javaland" object
    public void setIncome(int i) {
        income = i;
    }

    // Calcluates tax from a Javaland object storing income
    public double applyTax() {
        double tax = 0.0;
        if (income > LIVINGLIMIT) {
            tax += LIVINGFEE;
        }
        if (income > LIM2) {
            tax += LIM1 * PERCENT1;
            tax += (LIM2 - LIM1) * PERCENT2;
            tax += (income - LIM2) * PERCENT3;
        } else if (income > LIM1) {
            tax += (income - LIM1) * PERCENT2;
            tax += LIM1 * PERCENT1;
        } else {
            tax += income * PERCENT1;
        }
        return tax;
    }

    // Changes Javaland object to string for output
    public String toString() {
        return "Income is " + getIncome();
    }

    // Gets Input for income and returns an int
    public static int getInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your current income rounded to the nearest integer: ");
        String input = in.readLine();
        System.out.println("You entered " + input + " For your income");
        int i = new Integer(input);
        return i;
    }

    /*
     * Runs getInput() method and assigns int to Javaland object, then
     * calculates tax with applyTax() then prints the answer
     */
    public static void main(String[] args) throws IOException {
        Javaland income = new Javaland(Javaland.getInput());
        double tax = income.applyTax();
        System.out.println(income.toString());
        System.out.println("Tax is " + tax);
    }
}

// Outputs

// Enter your current income rounded to the nearest integer: 0
// You entered 0 For your income
// Income is 0
// Tax is 0.0

// Enter your current income rounded to the nearest integer: 500
// You entered 500 For your income
// Income is 500
// Tax is 5.0

// Enter your current income rounded to the nearest integer: 5432
// You entered 5432 For your income
// Income is 5432
// Tax is 554.32

// Enter your current income rounded to the nearest integer: 15006
// You entered 15006 For your income
// Income is 15006
// Tax is 850.3

// Enter your current income rounded to the nearest integer: 32999
// You entered 32999 For your income
// Income is 32999
// Tax is 1899.9

// Enter your current income rounded to the nearest integer: 100555
// You entered 100555 For your income
// Income is 100555
// Tax is 8655.5
