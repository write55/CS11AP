
/*
Aaron Wu
11/18/18
Program takes input for the path of a file, then reads it and counts up the total number of each letter
The Program then outputs the counts and percentages of each letter
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
		System.out.print("Enter name of file, file must be in project directory\nEnter: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		while (input != null) {
			this.convertLetter(input);
			System.out.println(input);
			input = inFile.readLine();
		}
		inFile.close();
	}

	// Converts letter to position in array and increases position total
	// Called for one line at a time, never called in main
	public void convertLetter(String file) {
		for (int i = 0; i < file.length(); i++) {
			// If character returns less than 65 it's not a letter
			if (file.charAt(i) > 64) {
				this.letters[Character.toUpperCase(file.charAt(i)) - 65]++;
				this.total++;
			}
		}
	}

	// printArray prints array and finds percentages
	public void printArray() {
		System.out.println("\nLetters and Percentages:");
		for (int i = 0; i < 26; i++) {
			System.out.print((char) (i + 65) + ": " + this.letters[i] + ", ");
			System.out.println((int) (this.letters[i] / this.total * 1000.0 + .5) / 10.0 + "% ");
		}
	}

	public static void main(String[] args) throws IOException {
		Tally file = new Tally();
		file.readFile();
		file.printArray();
	}
}

//OUTPUT
//
//Enter name of file, file must be in project directory
//Enter: paragraph.txt
//
//Reading File...
//
//	An array is a data structure made up of a group of locations having the 
//same type and given a common name.  Each individual location is accessed by 
//its name and position (index) in the group.  The position numbering starts at 
//zero.
//
//	Described below are some typical types of processing that occur when 
//using arrays:  searching, sorting, and parallel arrays.
//
//	Searching is looking systematically through the elements of an array for a 
//specific value.  You may need to know only if the value is in the array, or you 
//may need to know its position in the array.  There are two algorithms for 
//searching:  linear and binary.
//
//	Arranging values in ascending, descending, or alphabetical order is 
//called sorting.  There are many different algorithms for sorting.  The ones we will 
//study include selection, bubble, insertion, merge, and quick.  Which of these do 
//you already know? 
//
//	In many problems there are several pieces which go together.  For 
//example, you might have student id numbers, gender codes (M or F), and qpas.  
//You could use an integer array for the id numbers, a character array for the 
//gender codes, and a double array for the qpas.  A particular id number goes
//with a particular gender code and a particular qpa because they have the same 
//position in their respective arrays, that is, they have the same index!  Such
//arrays are called parallel arrays.
//
//Letters and Percentages:
//A: 115, 10.7% 
//B: 15, 1.4% 
//C: 41, 3.8% 
//D: 42, 3.9% 
//E: 125, 11.6% 
//F: 17, 1.6% 
//G: 30, 2.8% 
//H: 45, 4.2% 
//I: 76, 7.1% 
//J: 0, 0.0% 
//K: 5, 0.5% 
//L: 42, 3.9% 
//M: 26, 2.4% 
//N: 74, 6.9% 
//O: 70, 6.5% 
//P: 25, 2.3% 
//Q: 4, 0.4% 
//R: 93, 8.7% 
//S: 67, 6.2% 
//T: 70, 6.5% 
//U: 34, 3.2% 
//V: 11, 1.0% 
//W: 11, 1.0% 
//X: 3, 0.3% 
//Y: 33, 3.1% 
//Z: 1, 0.1% 
