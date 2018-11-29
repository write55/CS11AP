
/*
Aaron Wu
11/27/18
TODO finish description 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// check element on one list to one on other list, increase position for lesser one and append to final list
// if duplicates are present just ignore them, don't put the condition in the if
// use that for the final, sort both first - do insertion sort maybe
// merge has 1 array with length, have 3 objects

public class Merge {

	// PRIVATE DATA
	private int[] array;
	private int filled;

	// TODO Add field for filled on 3rd array
	// CONSTRUCTOR - only argument for array length
	public Merge(int length) {
		array = new int[length];
	}

	// GETTERS - probably won't need
	public int[] getArray() {
		return array;
	}

	public int getFilled() {
		return filled;
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

	// TODO Sort Method
	// Sorts arrays, for use on first and second
	public void sortArray() {
		// Insertion Sort (From slides)
		for (int j = 1; j < filled; j++) {
			int temp = array[j];
			int possible = j;
			while (possible > 0 && temp < array[possible - 1]) {
				array[possible] = array[possible - 1];
				possible--;
			}
			array[possible] = temp;
		}
	}

	// TODO Merge Method
	public void mergeArrays(Merge X, Merge Y) {
		int c1 = 0, c2 = 0;
		for (int i = 0; i < this.array.length; i++) {
			while (c1 < X.filled && c2 < Y.filled) {
				if (X.array[c1] < Y.array[c2]) {
					this.array[i] = X.array[c1];
					c1++;
				} else {
					this.array[i] = Y.array[c2];
					c2++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
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
		combined.mergeArrays(first, second);
		combined.printArray(3);

	}

}
