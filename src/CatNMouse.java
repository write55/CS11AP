
/*
Aaron Wu

 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatNMouse {

	private ArrayList<ArrayList<Character>> maze;
	private int width;
	private int height;

	public CatNMouse() {
		maze = new ArrayList<ArrayList<Character>>();
	}

	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter relative path of file: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		while (input != null) {
			process(input);
			System.out.println("line added");
			input = inFile.readLine();
		}
		inFile.close();
	}

	public void process(String in) {
		ArrayList<Character> temp = new ArrayList<Character>();
		for (int i = 0; i < in.length(); i++) {
			temp.add(in.charAt(i));
		}
		maze.add(temp);
	}

	public String toString() {
		String output = "";
		for (ArrayList<Character> i : maze) {
			for (Character j : i) {
				output += j;
			}
			output += "\n";
		}
		return output;
	}

	public void setDimensions() {
		width = maze.get(0).size();
		height = maze.size();
	}

	public void printResult(boolean solved) {
		if (solved) {
			System.out.print("The cat found the mouse in this ");
		} else {
			System.out.print("The cat was unable to find the mouse in this ");
		}
		System.out.println(width + " x " + height + " maze");
		System.out.println(toString());
	}

	public boolean inBounds(int x, int y) {
		return x < width && x > -1 && y < height && y > -1;
	}

	public char solve(int x, int y) {

		if (inBounds(x, y)) {
			if (maze.get(y).get(x) == ' ') {
				maze.get(y).set(x, '0');
				for (int x1 = x - 1; x1 < x + 2; x1++) {
					for (int y1 = y - 1; y < y + 2; y1++) {
						solve(x1, y1);
					}
				}
			} else if (maze.get(y).get(x) == '0') {

			} else if (maze.get(y).get(x) == '#') {

			} else {

			}
		}
		return ' ';
	}

	public static void main(String[] args) throws IOException {
		CatNMouse cat = new CatNMouse();
		cat.readFile();
		System.out.println(cat.toString());
		cat.setDimensions();
	}
}
