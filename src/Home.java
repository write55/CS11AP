/*
Aaron Wu
10/29/18
Program to do something with house values and stuff - change this later
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
    private int money = 0;
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
     trap for integer since it'll crash the program if you enter a decimal so
     it's not needed (no NumberFormatException)
     */
    public static int inputValue() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(in.readLine());
        while (i <= 0) {
            System.out.print("Value is zero or not positive\nTry Again: ");
            i = Integer.parseInt(in.readLine());
        }
        return i;
    }

    // Method to run number private var input methods to save room in main for other stuff
    public void inputValuesRunner() throws IOException {
        System.out.print("Enter budget as a positive integer: ");
        this.money = inputValue();
        System.out.print("Enter length: ");
        this.length = inputValue();
        System.out.print("Enter width: ");
        this.width = inputValue();
        System.out.print("Enter number of floors: ");
        this.floors = inputValue();
    }

    // Method for style - separate since it takes char not integer
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
        return "Information for your house:\nCost: " + this.money + "\nLength: " + this.length + "\nWidth: " + this.width + "\nFloors: "
                + this.floors + "\nStyle: " + style;
    }

    public static void main(String[] args) throws IOException {
        Home house = new Home();
        house.inputValuesRunner();
        house.inputStyle();
        System.out.println("\n" + house.toString());

    }

}
