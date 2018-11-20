
/*
Aaron Wu
11/18/18

 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tally {

    // PRIVATE DATA
    private int[] letters = new int[26];
    private double total = 0.0;

    // NO-ARGUMENT CONSTRUCTOR
    public Tally() {

    }

    // Method to read the file, reads one line at a time
    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter full path of file\nEnter: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("Reading File...");
        String input = inFile.readLine();
        while (input != null) {
            this.convertLetter(input);
            System.out.println(input);
            input = inFile.readLine();
        }
        inFile.close();
    }

    // Converts letter to position in array and increases that position and the total
    // Called for one line at a time, never called in main
    public void convertLetter(String file) {
        for (int i = 0; i < file.length(); i++) {
            // If character returns less than 65 it's not a letter
            if ((int) file.charAt(i) > 64) {
                this.letters[(int) Character.toUpperCase(file.charAt(i)) - 65]++;
                this.total++;
            }
        }
    }

    // printArray prints array and finds percentages
    public void printArray() {
        System.out.print("\n[");
        for (int i = 0; i < 25; i++) {
            System.out.print((char) (i + 65) + ": " + this.letters[i] + ", ");
        }
        // Last value printed separately for formatting purposes
        System.out.println("Z: " + this.letters[25] + "]");

        // Second output with percentages
        double value; // variable to make code more readable
        System.out.print("\n[");
        for (int i = 0; i < 25; i++) {
            value = (int) (this.letters[i] / this.total * 1000.0 + .5) / 10.0;
            System.out.print((char) (i + 65) + ": " + value + "%, ");
        }
        value = (int) (this.letters[25] / this.total * 1000.0 + .5) / 10.0;
        System.out.println("Z: " + value + "%]\n");
    }

    public static void main(String[] args) throws IOException {
        Tally file = new Tally();
        file.readFile();
        file.printArray();
    }
}
