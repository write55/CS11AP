
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CatNMouse {

	private ArrayList<char[]> maze;

	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter relative path of file: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		tokenizeString(input);
		inFile.close();
	}

	public void tokenizeString(String input) {
		StringTokenizer st = new StringTokenizer(input);
		
	}
	
	
}
