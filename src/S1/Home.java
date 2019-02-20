package Semester1;
/*
Aaron Wu
10/29/18
Program creates a House object and allows the user to input values for budget, l/w/h, style, and calculates cost from those.
Also allows user to change values for any given private variable until a sentinel is entered, then prompts for a new user.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home {

    // CONSTANTS
    public static final int MINIMUM_COST = 100;
    public static final int STANDARD_COST = 125;
    public static final int ENERGY_COST = 150;
    public static final int CUSTOM_COST = 200;

    // PRIVATE DATA
    private int budget = 0;
    private int length = 0;
    private int width = 0;
    private int floors = 0;
    private char style = ' ';

    // CONSTRUCTOR (No arguments)
    public Home() {

    }

    // INPUT METHODS
    /*
     General method for l/w/f and money, checks for positive integer, no error
     trap for integer since it'll crash the program if you enter a decimal
     */
    public static int inputValue(String variable) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter " + variable + ": ");
        int i = Integer.parseInt(in.readLine());
        while (i <= 0) {
            System.out.print("Value is zero or not positive\nTry Again: ");
            i = Integer.parseInt(in.readLine());
        }
        return i;
    }

    // Method to run inputValue for each private variable to save room in main
    public void runInputValues() throws IOException {
        this.budget = inputValue("budget");
        this.length = inputValue("length");
        this.width = inputValue("width");
        this.floors = inputValue("no. of floors");
    }

    // Method for style - separate from others since it takes char not integer
    public void inputStyle() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your house's style code: ");
        char c = in.readLine().toUpperCase().charAt(0);
        while (c != 'M' && c != 'S' && c != 'E' && c != 'C') {
            System.out.print("Doesn't match any available styles\nTry Again: ");
            c = in.readLine().toUpperCase().charAt(0);
        }
        this.style = c;
    }

    // METHODS TO WORK WITH PRIVATE DATA
    // This method will never show up in main, runs as part changeDataLoop
    // Prompts user to choose a private variable to change
    public void changeValues() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which value would you like to change?");
        System.out.print("Enter the first letter: ");
        char change = in.readLine().toUpperCase().charAt(0);
        while (change != 'B' && change != 'L' && change != 'W' && change != 'F' && change != 'S') {
            System.out.print("Letter doesn't match any private data values\nTry Again: ");
            change = in.readLine().toUpperCase().charAt(0);
        }
        if (change == 'B') {
            this.budget = inputValue("new budget");
        } else if (change == 'L') {
            this.length = inputValue("new length");
        } else if (change == 'W') {
            this.width = inputValue("new width");
        } else if (change == 'F') {
            this.floors = inputValue("new no. of floors");
        } else {
            this.inputStyle();
        }
    }

    // Method to prompt user to change a private data value, calls changeValues
    public void changeDataLoop() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Would you like to change any values? (Y/N)");
        char query = in.readLine().toUpperCase().charAt(0);
        int cost;
        while (query != 'N') {
            this.changeValues();
            cost = this.calculateCost();
            System.out.println("\nNew information for your house: " + this.toString());
            System.out.println("\nThe cost of your house is: " + cost);
            checkCost(cost, this.budget);
            System.out.println("Would you like to change any other values? (Y/N)");
            query = in.readLine().toUpperCase().charAt(0);
        }
    }

    // CALCULATIONS/UTILITY (printArray, etc)
    // Calculates the cost of a house from a "house" object's style
    public int calculateCost() {
        int totalArea = this.length * this.width * this.floors;
        char c = this.style;
        if (c == 'M') {
            totalArea *= MINIMUM_COST;
        } else if (c == 'S') {
            totalArea *= STANDARD_COST;
        } else if (c == 'E') {
            totalArea *= ENERGY_COST;
        } else {
            totalArea *= CUSTOM_COST;
        }
        return totalArea;
    }

    // Method to check if budget is greater than cost and print out if it's enough
    public static void checkCost(int cost, int budget) {
        if (cost > budget) {
            System.out.println("Budget is not enough.");
        } else {
            System.out.println("Budget is enough.");
        }
    }

    // Method to convert style character to full word
    public static String convertStyle(char c) {
        String output;
        if (c == 'M') {
            output = "Minimum";
        } else if (c == 'S') {
            output = "Standard";
        } else if (c == 'E') {
            output = "Energy-Efficient";
        } else {
            output = "Custom";
        }
        return output;
    }

    // Converts private data to string
    public String toString() {
        String style = convertStyle(this.style);
        return "\nBudget: " + this.budget + "\nLength: " + this.length + "\nWidth: "
                + this.width + "\nFloors: " + this.floors + "\nStyle: " + style;
    }

    public static void main(String[] args) throws IOException {
        Home house = new Home();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int houseCounter = 0;
        char userLoopCheck = 'Y';
        System.out.println("All numeric values entered should be positive integers");
        while (userLoopCheck == 'Y') {
            houseCounter++;
            System.out.println("Program starting for house no. " + houseCounter);
            house.runInputValues();
            house.inputStyle();
            System.out.println("\n" + "Information for your house:" + house.toString());
            int cost = house.calculateCost();
            System.out.println("\nThe cost of your house is: " + cost);
            checkCost(cost, house.budget);
            house.changeDataLoop();
            System.out.println("Program complete.");
            System.out.println("Would you like to start another house? (Y/N)");
            userLoopCheck = in.readLine().charAt(0);
        }
        System.out.println("Program terminating, have a nice day.");
    }
}

// OUTPUT

// All numeric values entered should be positive integers
// Program starting for house no. 1
// Enter budget: -10
// Value is zero or not positive
// Try Again: 0
// Value is zero or not positive
// Try Again: 1000
// Enter length: 0
// Value is zero or not positive
// Try Again: -3
// Value is zero or not positive
// Try Again: 5
// Enter width: -33
// Value is zero or not positive
// Try Again: 0
// Value is zero or not positive
// Try Again: 10
// Enter no. of floors: -3
// Value is zero or not positive
// Try Again: 0
// Value is zero or not positive
// Try Again: 3
// Enter your house's style code: w
// Doesn't match any available styles
// Try Again: a
// Doesn't match any available styles
// Try Again: x
// Doesn't match any available styles
// Try Again: m
//
// Information for your house:
// Budget: 1000
// Length: 5
// Width: 10
// Floors: 3
// Style: Minimum
//
// The cost of your house is: 15000
// Budget is not enough.
// Would you like to change any values? (Y/N)
// Y
// Which value would you like to change?
// Enter the first letter: w
// Enter new width: 0
// Value is zero or not positive
// Try Again: -3
// Value is zero or not positive
// Try Again: 3
//
// New information for your house:
// Budget: 1000
// Length: 5
// Width: 3
// Floors: 3
// Style: Minimum
//
// The cost of your house is: 4500
// Budget is not enough.
// Would you like to change any other values? (Y/N)
// Y
// Which value would you like to change?
// Enter the first letter: f
// Enter new no. of floors: 2
//
// New information for your house:
// Budget: 1000
// Length: 5
// Width: 3
// Floors: 2
// Style: Minimum
//
// The cost of your house is: 3000
// Budget is not enough.
// Would you like to change any other values? (Y/N)
// Y
// Which value would you like to change?
// Enter the first letter: s
// Enter your house's style code: x
// Doesn't match any available styles
// Try Again: e
//
// New information for your house:
// Budget: 1000
// Length: 5
// Width: 3
// Floors: 2
// Style: Energy-Efficient
//
// The cost of your house is: 4500
// Budget is not enough.
// Would you like to change any other values? (Y/N)
// Y
// Which value would you like to change?
// Enter the first letter: b
// Enter new budget: 4500
//
// New information for your house:
// Budget: 4500
// Length: 5
// Width: 3
// Floors: 2
// Style: Energy-Efficient
//
// The cost of your house is: 4500
// Budget is enough.
// Would you like to change any other values? (Y/N)
// N
// Program complete.
// Would you like to start another house? (Y/N)
// Y
// Program starting for house no. 2
// Enter budget: 100000
// Enter length: 10
// Enter width: 10
// Enter no. of floors: 10
// Enter your house's style code: c
//
// Information for your house:
// Budget: 100000
// Length: 10
// Width: 10
// Floors: 10
// Style: Custom
//
// The cost of your house is: 200000
// Budget is not enough.
// Would you like to change any values? (Y/N)
// Y
// Which value would you like to change?
// Enter the first letter: s
// Enter your house's style code: m
//
// New information for your house:
// Budget: 100000
// Length: 10
// Width: 10
// Floors: 10
// Style: Minimum
//
// The cost of your house is: 100000
// Budget is enough.
// Would you like to change any other values? (Y/N)
// N
// Program complete.
// Would you like to start another house? (Y/N)
// N
// Program terminating, have a nice day.