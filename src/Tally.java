
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tally {

	public Tally() {

	}

	private int[] letters = new int[26];
	private int total = 0;

	public String inputFile() throws IOException { // This doesn't work
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter filename with extension, must be in same directory as program\nEnter: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("Reading File...");
		String input = inFile.readLine();
		while (input != null) {
			System.out.println(input);
			input = inFile.readLine();
		}
		inFile.close();
		return input;
	}

	public void convertLetter(String file) {
		for (int i = 0; i < file.length() - 1; i++) {
			letters[Character.toUpperCase(file.charAt(i)) - 'A']++;
		}
	}

	public static void main(String[] args) throws IOException {
		Tally file = new Tally();
		file.convertLetter("Aa Bb Cc Dd Ee Ff Gg");

	}
}
