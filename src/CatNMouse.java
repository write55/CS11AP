/*
Aaron Wu
Due: 4/25/19
Reads a maze in the format of a text file
Uses recursion to find a mouse on character "M" from a cat "C"
Cat is always in first row
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatNMouse {

    private ArrayList<ArrayList<Character>> maze;
    private int w; // width, x
    private int h; // height, y
    private boolean found = false;

    public CatNMouse() {
        maze = new ArrayList<ArrayList<Character>>();
    }

    // FILE READING
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
        w = maze.get(0).size();
        h = maze.size();
    }

    public void process(String in) {
        ArrayList<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < in.length(); i++) {
            temp.add(in.charAt(i));
        }
        maze.add(temp);
    }

    // GET FOUND
    public boolean getFound() {
        return found;
    }

    // FUNCTION METHODS
    // Cat always at y = 0, gives x location
    public int findCat() {
        int out = 0;
        while (!maze.get(0).get(out).equals('C')) {
            out++;
        }
        return out;
    }

    // Builds string from maze array for output
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (ArrayList<Character> i : maze) {
            for (Character j : i) {
                if (j == '1') {
                    out.append(' ');
                } else {
                    out.append(j);
                }
            }
            out.append("\n");
        }
        return out.toString();
    }

    // Gives dimensions, result, calls toString
    public void printResult() {
        if (found) {
            System.out.println("The cat found the mouse in this " + w + " x " + h + " maze");
        } else {
            System.out.println("The cat was unable to find the mouse in this " + w + " x " + h + " maze");
        }
        System.out.println(toString());
    }

    // Solve method - give starting coordinates
    public void solve(int x, int y) {
        if (x >= w || x < 0 || y >= h || y < 0) {
            return;
        } else if (maze.get(y).get(x).equals('#')) {
            return;
        } else if (maze.get(y).get(x).equals('M') && !found) {
            found = true;
            printResult(); // "End" the method, doesn't stop recursion
            return;
        } else if (maze.get(y).get(x).equals('0') || maze.get(y).get(x).equals('1') || maze.get(y).get(x).equals('C')) {
            return;
        }
        maze.get(y).set(x, '0');
        // These calls have to be vertical then horizontal so the recursion doesn't just flip-flop
        solve(x, y + 1);
        solve(x + 1, y);
        solve(x, y - 1);
        solve(x - 1, y);
        // If the cat hits a wall or something meaning it's trapped the recursive call will return
        // The space from the previous recurse will be set to 1 then printed as a space later
        maze.get(y).set(x, '1');
    }

    public static void main(String[] args) throws IOException {
        CatNMouse cnm;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char sentinel = 'Y';
        while (sentinel != 'N') {
            cnm = new CatNMouse();
            cnm.readFile();
            cnm.solve(cnm.findCat(), 1);
            if (!cnm.getFound()) {
                cnm.printResult();
            }
            System.out.println("Continue? (Y/N)");
            sentinel = in.readLine().toUpperCase().charAt(0);
        }
    }
}
