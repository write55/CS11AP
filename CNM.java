
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
	boolean found;

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

	public boolean getFound() {
		return found;
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

	public void solve(int down, int across) {
		while (!found) {
			if (inBounds(across, down) && !maze.get(down).get(across).equals('#')
					&& !maze.get(down).get(across).equals('0') && !maze.get(down).get(across).equals('C')) {
				if (!maze.get(down).get(across).equals('M')) {
					if (maze.get(down).get(across).equals(' ')) {
						maze.get(down).set(across, '0');
					}
					for (int x1 = across - 1; x1 < across + 2; x1++) {
						for (int y1 = down - 1; y1 < down + 2; y1++) {
							solve(y1, x1);
						}
					}
				}
				found = true;
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		CatNMouse cat = new CatNMouse();
		cat.readFile();
		cat.setDimensions();
		cat.solve(1, 2);
		System.out.println(cat.toString());
		cat.printResult(cat.getFound());
	}
}
