
/*
Aaron Wu
11/27/18
Program takes input for two arrays as strings and sorts them using the insertion sort algorithm
The sorting algorithm is modified to take care of duplicates
The program will then combine the two arrays, removing any duplicates between them
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge {

    // PRIVATE DATA
    private int[] array;
    private int filled;

    // CONSTRUCTOR - only argument for array length
    public Merge(int length) {
        array = new int[length];
    }

    // GETTER/SETTER - for filled only
    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    // Fills array and gives number filled
    public void inputArray() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (filled = 0; filled < array.length && st.hasMoreTokens(); filled++) {
            array[filled] = Integer.parseInt(st.nextToken());
        }
    }

    // Prints out array in proper format from an object
    public void printArray(int number) {
        System.out.print("List " + number + "--> ");
        for (int i = 0; i < filled; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Sorts arrays, for use on first and second
    public void sortArray() {
        int duplicates = 0;
        // Insertion Sort (From slides)
        for (int j = 1; j < filled; j++) {
            int temp = array[j];
            int possible = j;
            while (possible > 0 && temp <= array[possible - 1]) {
                if (temp == array[possible - 1]) {
                    // Ensure duplicate always gets sent to front of array
                    temp = array[0] - 1;
                    // Store number of duplicates
                    duplicates++;
                }
                array[possible] = array[possible - 1];
                possible--;
            }
            array[possible] = temp;
        }
        // Removal Loop
        for (; duplicates > 0; duplicates--) {
            filled--;
            for (int i = 0; i < filled; i++) {
                array[i] = array[i + 1];
            }
        }
    }

    // Merges arrays together, takes two merge objects as arguments
    public void mergeArrays(Merge X, Merge Y) {
        int c1 = 0, c2 = 0, i = 0;
        while (c1 < X.filled && c2 < Y.filled) {
            if (X.array[c1] < Y.array[c2]) {
                this.array[i] = X.array[c1];
                c1++;
            } else if (X.array[c1] > Y.array[c2]) {
                this.array[i] = Y.array[c2];
                c2++;
            } else {
                this.array[i] = X.array[c1];
                this.filled--;
                c1++;
                c2++;
            }
            i++;
        }
        // Only one loop ever runs
        for (; c1 < X.filled; c1++) {
            this.array[i] = X.array[c1];
            i++;
        }
        for (; c2 < Y.filled; c2++) {
            this.array[i] = X.array[c2];
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        // 2 3 8 12 18 21
        // 5 8 10 15
        Merge first = new Merge(15);
        Merge second = new Merge(15);
        System.out.println("Enter a string of numbers separated by spaces");
        System.out.println("If your string is greater than 15 excess values will not be stored");
        System.out.print("First Array: ");
        first.inputArray();
        System.out.print("Second Array: ");
        second.inputArray();
        System.out.println("\nSorted arrays:");
        first.sortArray();
        first.printArray(1);
        second.sortArray();
        second.printArray(2);
        System.out.println("\nMerged Array:");
        Merge combined = new Merge(first.getFilled() + second.getFilled());
        combined.setFilled(first.getFilled() + second.getFilled());
        combined.mergeArrays(first, second);
        combined.printArray(3);
    }

}
