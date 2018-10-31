
/*
Aaron Wu
10/29/18
Program to do something with house values and stuff - change this later
https://stackoverflow.com/questions/31752352/eclipses-outline-window-equivalent-in-intellij
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
     * General method for l/w/f and money, checks for positive integer, no error
     * trap for integer since it'll crash the program if you enter a decimal so
     * it's not needed (no NumberFormatException)
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
        char c = Character.toUpperCase(in.readLine().charAt(0));
        while (c != 'M' && c != 'S' && c != 'E' && c != 'C') {
            System.out.print("Doesn't match any available styles\nTry Again: ");
            c = Character.toUpperCase(in.readLine().charAt(0));
        }
        this.style = c;
    }

    // METHODS TO CHANGE PRIVATE DATA

    // This method will never show up in main, runs as part changeData
    // Allows user to choose a private variable to change
    public void changeValues() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which value would you like to change?");
        System.out.print("Enter the first letter: ");
        char change = Character.toUpperCase(in.readLine().charAt(0));
        while (change != 'B' && change != 'L' && change != 'W' && change != 'F' && change != 'S') {
            System.out.print("Letter doesn't match any private data values\nTry Again: ");
            change = Character.toUpperCase(in.readLine().charAt(0));
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

    // Method to prompt user to change a private data value
    public void changeData(int cost) throws IOException {
        char query;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        query = Character.toUpperCase(in.readLine().charAt(0));
        while (query == 'Y') {
            this.changeValues();
            System.out.println("\nNew " + this.toString());
            if (cost > this.budget) {
                System.out.println("Your budget is still not enough.");
            } else {
                System.out.println("Budget is enough.");
            }
            System.out.println("\nWould you like to change any others? (Y/N)");
            query = Character.toUpperCase(in.readLine().charAt(0));
        }
    }

    // CALCULATIONS/UTILITY (toString, etc)

    // Calculates the cost of a house from a "house" object's style
    public int calculateCost() {
        int cost = 0;
        int area = this.length * this.width;
        char c = this.style;
        if (c == 'M') {
            cost += MINIMUM_COST * area;
        } else if (c == 'S') {
            cost += STANDARD_COST * area;
        } else if (c == 'E') {
            cost += ENERGY_COST * area;
        } else {
            cost += CUSTOM_COST * area;
        }
        cost *= this.floors;
        return cost;
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
        return "Information for your house:\nBudget: " + this.budget + "\nLength: " + this.length + "\nWidth: "
                + this.width + "\nFloors: " + this.floors + "\nStyle: " + style;
    }

    public static void main(String[] args) throws IOException {
        Home house = new Home();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int counter = 1;
        char sentinel = 'Y';
        System.out.println("All numeric values entered should be positive integers");
        while (sentinel != 'N') {
            System.out.println("User " + counter + " has started their house");
            house.runInputValues();
            house.inputStyle();
            System.out.println("\n" + house.toString() + "\n");
            int cost = house.calculateCost();
            System.out.println("The cost of your house is: " + cost);
            while (cost > house.budget) {
                System.out.println("Your budget isn't enough to cover costs.");
                System.out.println("Would you like to change your house's dimensions or style? (Y/N)");
                house.changeData(cost);
            }
            System.out.println("Program complete. Go build your house, user " + counter + ".");
            System.out.println("Would you like to start another house? (Y/N)");
            sentinel = in.readLine().charAt(0);
        }
    }
}
