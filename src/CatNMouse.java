
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
    private boolean found;

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

    public boolean getFound() {
        return found;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (ArrayList<Character> i : maze) {
            for (Character j : i) {
                out.append(j);
            }
            out.append("\n");
        }
        return out.toString();
    }

    public void printResult() {
        if (found) {
            System.out.print("The cat found the mouse in this ");
        } else {
            System.out.print("The cat was unable to find the mouse in this ");
        }
        System.out.println(w + " x " + h + " maze");
        System.out.println(toString());
    }

    public boolean inBounds(int x, int y) {
        return x < w && x > -1 && y < h && y > -1;
    }

    public void solve(int x, int y) {
            if (inBounds(x, y)) {
                if (maze.get(y).get(x).equals('M')) {
                    found = true;
                    return;
                } else if (maze.get(y).get(x).equals('#') || maze.get(y).get(x).equals('0') || maze.get(y).get(x).equals('C')) {
                    return;
                }
                maze.get(y).set(x, '0');
                for (int x1 = x - 1; x1 < x + 2; x1++) {
                    for (int y1 = y - 1; y1 < y + 2; y1++) {
                        solve(x1, y1);
                    }
                }
            }

    }

    public static void main(String[] args) throws IOException {
        CatNMouse cat = new CatNMouse();
        cat.readFile();
        cat.solve(2, 1);
        cat.printResult();
    }
}
