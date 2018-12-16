
/*
Aaron Wu
12/12/18
Main Program for array of student objects
Array of student objects, allows user to take a text file with student id, score, and course
Prints out array sorted by Id number then gives number of scores outside 0 - 100, mean, median, lowest/highest score
Also gives out percentage of students who got each letter grade A-F
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StudentArray {

    // CONSTANTS
    public static final int studentMax = 30;

    // PRIVATE DATA
    private Student[] array = new Student[studentMax];
    private int filled = 0;

    // NO ARGUMENT CONSTRUCTOR
    public StudentArray() {

    }

    // FILE READER
    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter name of file, file must be in project directory\nEnter: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            tokenizeString(input);
            input = inFile.readLine();
        }
        inFile.close();
    }

    // Takes 3 values from string, inputs them into the student array
    // called in file reader method
    public void tokenizeString(String input) {
        StringTokenizer st = new StringTokenizer(input);
        for (; filled < array.length && st.hasMoreTokens(); filled++) {
            array[filled] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    st.nextToken().charAt(0));
        }
    }

    // SORTING METHODS
    // Sorts array by ID, Selection sort
    public void sortId() {
        for (int j = 0; j < filled - 1; j++) {
            int minIndex = j;
            for (int k = j + 1; k < filled; k++) {
                if (array[k].getId() < array[minIndex].getId()) {
                    minIndex = k;
                }
            }
            int temp = array[j].getId();
            array[j].setId(array[minIndex].getId());
            array[minIndex].setId(temp);
        }
    }

    // Prints array, "arrayToString" to distinguish from toString in Student
    public void arrayToString() {
        for (int i = 0; i < filled; i++) {
            System.out.println("\n" + array[i].toString());
        }
    }

    // Binary search method
    public int binarySearch(Student[] list, int target) {
        int left = 0;
        int right = filled - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < list[middle].getId()) {
                right = middle - 1;
            } else if (target > list[middle].getId()) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public void findId() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter an ID Number: ");
        int target = Integer.parseInt(in.readLine());
        int output = binarySearch(array, target);
        if (output == -1) {
            System.out.println("ID number not found.");
        } else {
            System.out.println("Index: " + output);
        }
    }

    public static void main(String[] args) throws IOException {
        StudentArray roster = new StudentArray();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Program will read student's ids, scores, and course choices from a file"
                + "\nMake sure it is properly formatted or the program will not work correctly"
                + "\nIf your score is over 100 or below 0 it will not be included in statistics");
        roster.readFile();
        roster.sortId();
        System.out.println("Complete list - sorted by ID");
        roster.arrayToString();
        char sentinel = 'Y';
        while (sentinel != 'N') {
            roster.findId();
            System.out.println("Would you like to continue? (Y/N)");
            sentinel = in.readLine().toUpperCase().charAt(0);
        }

    }
}