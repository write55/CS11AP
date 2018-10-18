
// Aaron Wu
// 10/18/18
// 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {

	// CONSTANTS
	public static final int MAX_WIDTH = 80;
	public static final int MAX_HEIGHT = 25;
	public static final int MIN = 1;

	// PRIVATE DATA
	private int length = 0;
	private int width = 0;

	// CONSTRUCTOR
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	// GETTERS
	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	// SETTERS
	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void getInput() throws IOException { // Separate these
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter width: ");
		this.setWidth(new Integer(in.readLine()));
		System.out.print("Enter length: ");
		this.setLength(new Integer(in.readLine()));
	}

	public String toString() {
		return "Can I get uhhhhhhhh some LAMP";
	}

	public void printRectangle() {
		System.out.println("If you want to go oof jump off the roof");
	}

	public static void main(String[] args) throws IOException {
		Rectangle rect = new Rectangle(0, 0);
		rect.getInput();
		// Error Trap and sentinel for 0
		while (rect.getWidth() != 0 && rect.getLength() != 0) {
			while (rect.getWidth() > MAX_WIDTH || rect.getLength() > MAX_HEIGHT || rect.getLength() < MIN
					|| rect.getWidth() < MIN) {
				System.out.println("Try again - width must be less than or equal to " + MAX_WIDTH
						+ "\nHeight must be less than or equal to " + MAX_HEIGHT + "\nBoth must be at least " + MIN);
				rect.getInput();
			}
			System.out.println(rect.toString());
			rect.printRectangle();
			System.out.println("Would you like to contine?");
			rect.getInput();

		}
		System.out.println("Program Terminated");
	}

}
