
/*
Aaron Wu
10/22/18
This program allows the user to input and ID and desired course, then adds the student to the given class.
The program also finds the number of sections needed, and allows the user to change class limits and the limit for each section
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Registration {

	// CONSTANTS
	public static final int BATIK_LIMIT = 6;
	public static final int CALIGRAPHY_LIMIT = 4;
	public static final int PAINTING_LIMIT = 7;
	public static final int SCULTURE_LIMIT = 4;
	public static final int WEAVING_LIMIT = 5;
	public static final int SENTINEL = 0;
	public static final int SECTION_LIMIT = 2;

	// PRIVATE DATA
	private int batik = 0;
	private int caligraphy = 0;
	private int painting = 0;
	private int sculpture = 0;
	private int weaving = 0;

	// CONSTRUCTOR (No Arguments)
	public Registration() {
		batik = 0;
		caligraphy = 0;
		painting = 0;
		sculpture = 0;
		weaving = 0;
	}

	// GETTERS
	public int getBatik() {
		return batik;
	}

	public int getCaligraphy() {
		return caligraphy;
	}

	public int getPainting() {
		return painting;
	}

	public int getSculpture() {
		return sculpture;
	}

	public int getWeaving() {
		return weaving;
	}

	// SETTERS
	public void setBatik(int batik) {
		this.batik = batik;
	}

	public void setCaligraphy(int caligraphy) {
		this.caligraphy = caligraphy;
	}

	public void setPainting(int painting) {
		this.painting = painting;
	}

	public void setSculpture(int sculpture) {
		this.sculpture = sculpture;
	}

	public void setWeaving(int weaving) {
		this.weaving = weaving;
	}

	// INPUT - takes care of error trapping course code
	public String getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter ID and first letter of course (capitalized) seperated by a space: ");
		String input = in.readLine();
		while (input.charAt(input.length()) != 'b') {

		}
		// char course = input.charAt(input.length());
		// int id = new Integer(input.substring(0, input.indexOf(" ") - 1));
		return input;
	}

	public static void main(String[] args) throws IOException {
		Registration info = new Registration();
		System.out.println(info.getInput());
	}

}
