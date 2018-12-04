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
	private int median;
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
			System.out.println(input);
			input = inFile.readLine();
		}
		inFile.close();
	}
}
