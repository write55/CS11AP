package Semester1;
/* Aaron Wu
 *  10/2/18
 *
 * Program calculates the bill for water usage of three account categories
 * Gets input for account id, code for account type, and number of gallons used then applies tax
 * Outputs all and converts account type code back to full word
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Used these to avoid wildcard import since these are only imported for input

public class WaterBill {

    // DECLARE CONSTANTS
    // Doubles used for all money values and ints for gallons for convenience
    public final static double HOME_SET_FEE = 5.00;
    public final static double HOME_PER_GALLON = .0005;
    public final static double COMMERCIAL_SET_FEE = 1000.00;
    public final static double COMMERCIAL_PER_GALLON = .00025;
    public final static double INDUSTRY_FEE1 = 1000.00;
    public final static double INDUSTRY_FEE2 = 2000.00;
    public final static double INDUSTRY_FEE3 = 3000.00;
    public final static int GALLONS_LIM1 = 4000000;
    public final static int GALLONS_LIM2 = 10000000;

    // PRIVATE DATA
    private int account = 0;
    private char code = ' ';
    private int gallons = 0;

    /*
     * Constructor for a new "WaterBill" object, assigns arguments to private
     * data, account ID then code then gallons for each new object
     */
    public WaterBill(int a, char c, int g) {
        account = a;
        code = Character.toLowerCase(c);
        // Makes sure character code is always lowercase
        gallons = g;
    }

    // GETTERS

    // Getter for account ID
    public int getAccount() {
        return account;
    }

    // Getter for code
    public char getCode() {
        return code;
    }

    // Getter for number of gallons
    public int getGallons() {
        return gallons;
    }

    // SETTERS

    // Setter for account ID
    public void setAccount(int a) {
        account = a;
    }

    // Setter for code
    public void setCode(char c) {
        code = c;
    }

    // Setter for number of gallons
    public void setGallons(int g) {
        gallons = g;
    }

    /*
     * Converts a "WaterBill" object to a string, printing out all three private
     * data values, takes care of converting the code to a complete word as well
     */
    public String toString() {
        String c = "";
        if (getCode() == 'h') {
            c = "home";
        } else if (getCode() == 'c') {
            c = "commercial";
        } else {
            c = "industrial";
        }
        return "Your account number is " + account + ", your bill is for " + c + " use" + "\n"
                + "Your amount of gallons used is " + gallons;
        // newline up there to make output look better when we combine it with
        // the tax when printing in main
    }

    /*
     * Takes a "WaterBill" object and calculates the tax, returns as double
     */
    public double applyTax() {
        double tax = 0;
        if (getCode() == 'h') {
            tax += HOME_SET_FEE + HOME_PER_GALLON * getGallons();
        } else if (getCode() == 'c') {
            tax += COMMERCIAL_SET_FEE;
            if (getGallons() > GALLONS_LIM1) {
                tax += (getGallons() - GALLONS_LIM1) * COMMERCIAL_PER_GALLON;
            }
        } else {
            if (getGallons() < GALLONS_LIM1) {
                tax += INDUSTRY_FEE1;
            } else if (getGallons() < GALLONS_LIM2) {
                tax += INDUSTRY_FEE2;
            } else {
                tax += INDUSTRY_FEE3;
            }
        }
        return tax;
    }

    /*
     * Method for input, included the print statements here because this input
     * method is specialized for assigning values to the 3 private variables of
     * a "WaterBill" object, kind of like a leveled up setter or something, made
     * it one method to avoid making three static methods or putting it in main
     */
    public void getInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your account ID Number: ");
        setAccount(new Integer(in.readLine()));
        System.out.print("Enter your account code as a single character: ");
        setCode(in.readLine().charAt(0));
        System.out.print("Enter the number of gallons used as an integer: ");
        setGallons(new Integer(in.readLine()));
    }

    public static void main(String[] args) throws IOException {
        WaterBill waterAccount = new WaterBill(0, ' ', 0);
        // makes empty "WaterBill" object to fill with getInput(),
        waterAccount.getInput();
        double tax = (int) (100.0 * waterAccount.applyTax() + .5) / 100.0;
        System.out.println(waterAccount.toString() + ", the amount due is " + tax);
    }
}

// OUTPUTS

// Enter your account ID Number: 10
// Enter your account code as a single character: c
// Enter the number of gallons used as an integer: 5000022
// Your account number is 10, your bill is for commercial use
// Your amount of gallons used is 5000022, the amount due is 1250.01

// Enter your account ID Number: 11
// Enter your account code as a single character: i
// Enter the number of gallons used as an integer: 1234567
// Your account number is 11, your bill is for industrial use
// Your amount of gallons used is 1234567, the amount due is 1000.0

// Enter your account ID Number: 12
// Enter your account code as a single character: h
// Enter the number of gallons used as an integer: 8765
// Your account number is 12, your bill is for home use
// Your amount of gallons used is 8765, the amount due is 9.38

// Enter your account ID Number: 13
// Enter your account code as a single character: c
// Enter the number of gallons used as an integer: 444444
// Your account number is 13, your bill is for commercial use
// Your amount of gallons used is 444444, the amount due is 1000.0

// Enter your account ID Number: 14
// Enter your account code as a single character: i
// Enter the number of gallons used as an integer: 5555555
// Your account number is 14, your bill is for industrial use
// Your amount of gallons used is 5555555, the amount due is 2000.0

// Enter your account ID Number: 15
// Enter your account code as a single character: i
// Enter the number of gallons used as an integer: 20000000
// Your account number is 15, your bill is for industrial use
// Your amount of gallons used is 20000000, the amount due is 3000.0
