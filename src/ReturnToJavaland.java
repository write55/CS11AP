
/*
Aaron Wu
10/15/18
Program taxes input from the user creates a "Javaland" object to store the income.
Uses if statements in the applytax() method to calculate taxes and then prints out the result.
Added looping for input and a sentinel to end the program, and to create the sum for the total value of taxes collected.
*/

import java.io.*;

public class ReturnToJavaland {

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
    public ReturnToJavaland(int i) {
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
    public void getInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        // System.out.println("You entered " + input + " For your income");
        setIncome(new Integer(input));
    }

    /*
     * Runs getInput() method and assigns int to Javaland object, then
     * calculates tax with applyTax() then prints the answer
     * loops until sentinel is entered and finds total tax as well
     */
    public static void main(String[] args) throws IOException {
        ReturnToJavaland income = new ReturnToJavaland(0);
        // Create empty ReturnToJavaland Object to work with
        double totalTax = 0;
        System.out.println("Enter your current income or -999 end the program: ");
        System.out.print("First income value: ");
        income.getInput();
        while (income.getIncome() != -999) {
            double tax = income.applyTax();
            System.out.println("Your tax is " + tax);
            totalTax += tax;
            System.out.print("Next income value: ");
            income.getInput();
        }
        System.out.println("Total tax is " + totalTax);
    }
}

// Output
//
//    Enter your current income or -999 end the program:
//    First income value: 0
//    Your tax is 0.0
//    Next income value: 500
//    Your tax is 5.0
//    Next income value: 5432
//    Your tax is 554.32
//    Next income value: 15006
//    Your tax is 850.3
//    Next income value: 32999
//    Your tax is 1899.9
//    Next income value: 100555
//    Your tax is 8655.5
//    Next income value: -999
//    Total tax is 11965.02
