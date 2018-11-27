
/*
Aaron Wu
11/27/18
Program to do IDK yet
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// check element on one list to one on other list, increase position for lesser one and append to final list
// if duplicates are present just ignore them, don't put the condition in the if
// use that for the final, sort both first
// merge has 1 array with length, have 3 objects

public class Merge {

	private int[] array;
	private int filled;

	public Merge(int length, int filled) {
		array = new int[length];
		this.filled = filled;
	}

	public void inputArray() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string of numbers separated by spaces");
		String temp = in.readLine();

	}

	public void sortArray() {

	}

	public void printArray(int number) {
		System.out.print("List " + number + "--> ");
		for (int i = 0; i < filled; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int[] mergeArrays(int[] X, int[] Y) {
		int[] Z = new int[X.length + Y.length];
		return Z;
	}

}
