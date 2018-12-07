import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StudentArray {

	// CONSTANTS
	public static final int studentMax = 30;
	public static final int gradeMin = 0;
	public static final int gradeMax = 100;

	// PRIVATE DATA
	private Student[] array = new Student[studentMax];
	private int filled;
	private double mean;
	private double median;
	private int highest;
	private int lowest;

	// NO ARGUMENT CONSTRUCTOR
	public StudentArray() {

	}

	// FILE READER
	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name of file, file must be in project directory\nEnter: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		while (input != null) {
			tokenizeString(input);
			input = inFile.readLine();
		}
		inFile.close();
	}

	// Takes 3 values from string, inputs them into the student array
	// called in file reader method
	public void tokenizeString(String input) {
		StringTokenizer st = new StringTokenizer(input);
		for (filled = 0; filled < array.length && st.hasMoreTokens(); filled++) {
			array[filled] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					st.nextToken().charAt(0));
		}
	}

	// SORTING METHODS

	// Sorts array by ID, Selection sort
	public void sortId() {
		for (int j = 0; j < filled - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < filled; k++) {
				if (array[k].getId() < array[minIndex].getId()) {
					minIndex = k;
				}
			}
			int temp = array[j].getId();
			array[j].setId(array[minIndex].getId());
			array[minIndex].setId(temp);
		}
	}

	// Sorts by score, Bubble sort
	public void sortScore() {
		int temp;
		boolean swap = true;
		int outer = filled;
		while (swap) {
			swap = false;
			outer--;
			for (int inner = 0; inner < outer; inner++) {
				if (array[inner].getScore() > array[inner + 1].getScore()) {
					temp = array[inner].getScore();
					array[inner].setScore(array[inner + 1].getScore());
					array[inner + 1].setScore(temp);
					swap = true;
				}
			}
		}
	}

	// STATISTICS METHODS/OTHER

	// Prints array, called "arrayToString" to distinguish toString in Student
	public void arrayToString() {
		for (int i = 0; i < filled; i++) {
			System.out.println("\n" + array[i].toString());
		}
	}

	public static void main(String[] args) throws IOException {
		StudentArray roster = new StudentArray();
		roster.readFile();
		roster.sortId();
		System.out.println("Complete list - sorted by ID");
		roster.arrayToString();
		roster.sortScore();
	}
}
