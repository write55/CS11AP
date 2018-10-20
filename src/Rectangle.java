
/* Aaron Wu
 * 10/18/18
 * This program
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {

    // CONSTANTS
    public static final int MAX_WIDTH = 80;
    public static final int MAX_HEIGHT = 25;
    public static final int MIN = 1;

    // PRIVATE DATA
    private int width = 0;
    private int height = 0;

    // CONSTRUCTOR
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    // GETTERS
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // SETTERS
    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // INPUTS AND ERROR TRAP
    // First gets width and error traps
    public void inputWidth() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width: ");
        this.setWidth(new Integer(in.readLine()));
        while (this.getWidth() > MAX_WIDTH || this.getWidth() < MIN) {
            System.out.println("Width must be <= " + MAX_WIDTH + " and >= " + MIN);
            System.out.print("Try again: ");
            this.setWidth(new Integer(in.readLine()));
        }
    }

    // Second gets height and error traps
    public void inputHeight() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter height: ");
        this.setHeight(new Integer(in.readLine()));
        while (this.getHeight() > MAX_HEIGHT || this.getHeight() < MIN) {
            System.out.println("Height must be <= " + MAX_HEIGHT + " and >= " + MIN);
            System.out.print("Try Again: ");
            this.setHeight(new Integer(in.readLine()));
        }
    }

    // Just used a separate method to save room in main
    public static char sentinelCheck() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Would you like to continue? (Y/N)");
        return in.readLine().charAt(0);
    }

    // toString also takes care of finding area then prints out l, w, a
    public String toString() {
        int w = this.getWidth();
        int h = this.getHeight();
        return "Your Rectangle is " + w + " stars across and " + h + " stars down, with an area of " + w * h;
    }

    // Prints out rectangle according to l and w of the given object
    public void printRectangle() {
        int w = this.getWidth();
        int h = this.getHeight();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println(); // Extra space for output
    }

    public static void main(String[] args) throws IOException {
        Rectangle rect = new Rectangle(0, 0);
        char sentinel = 'Y';
        while (Character.toUpperCase(sentinel) == 'Y') {
            rect.inputWidth();
            rect.inputHeight();
            System.out.println(rect.toString());
            rect.printRectangle();
            sentinel = sentinelCheck();
        }
        System.out.println("Program Terminated");
    }
}

// OUTPUT - format this better a bit

// Enter width: -8
// Width must be <= 80 and >= 1
// Try again: 100
// Width must be <= 80 and >= 1
// Try again: 81
// Width must be <= 80 and >= 1
// Try again: 1
// Enter height: -5
// Height must be <= 25 and >= 1
// Try Again: 30
// Height must be <= 25 and >= 1
// Try Again: 25
// Your Rectangle is 1 stars across and 25 stars down, with an area of 25
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
//
// Would you like to continue? (Y/N)
// Y
// Enter width: 10
// Enter height: 2
// Your Rectangle is 10 stars across and 2 stars down, with an area of 20
// **********
// **********
//
// Would you like to continue? (Y/N)
// Y
// Enter width: 5
// Enter height: 8
// Your Rectangle is 5 stars across and 8 stars down, with an area of 40
// *****
// *****
// *****
// *****
// *****
// *****
// *****
// *****
//
// Would you like to continue? (Y/N)
// N
// Program Terminated
