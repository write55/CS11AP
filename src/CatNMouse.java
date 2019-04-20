
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
    private int w; // width
    private int h; // height
    private boolean found = false;

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

    // Cat always in first row, returns column location
    public int findCat() {
        int out = 0;
        while (!maze.get(0).get(out).equals('C')) {
            out++;
        }
        return out;
    }

    public boolean getFound() {
        return found;
    }

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

    public void printResult() {
        if (found) {
            System.out.println("The cat found the mouse in this " + w + " x " + h + " maze");
            System.out.println(toString());
        } else {
            System.out.println("The cat was unable to find the mouse in this " + w + " x " + h + " maze");
        }
    }


    public boolean inBounds(int x, int y) {
        return x < w && x > -1 && y < h && y > -1;
    }

    public void solve(int x, int y) {
        if (!inBounds(x, y)) {
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
        solve(x, y - 1); // has to start moving away from the cat, down first
        solve(x - 1, y);
        solve(x, y + 1);
        solve(x + 1, y);
        maze.get(y).set(x, '1');
    }


    public static void main(String[] args) throws IOException {
        CatNMouse cat = new CatNMouse();
        cat.readFile();
        System.out.println(cat.toString());
        cat.solve(cat.findCat(), 1);
        if (!cat.getFound()) {
            cat.printResult();
        }
    }
}
