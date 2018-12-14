
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
    public static final int gradeMin = 0;
    public static final int gradeMax = 100;

    // PRIVATE DATA
    private Student[] array = new Student[studentMax];
    private int filled = 0;
    // Indexes of bad data, counter returned by method
    private int leftBad;
    private int rightBad;

    // NO ARGUMENT CONSTRUCTOR
    public StudentArray() {

    }

    // GETTER
    public int getFilled() {
        return filled;
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

    // Sorts by score, Bubble sort
    public void sortScore() {
        int temp;
        boolean swap = true;
        int outer = filled;
        while (swap) {
            swap = false;
            outer--;
            for (int inner = 0; inner < outer; inner++) {
                if (array[inner].getScore() > array[inner + 1].getScore()) {
                    temp = array[inner].getScore();
                    array[inner].setScore(array[inner + 1].getScore());
                    array[inner + 1].setScore(temp);
                    swap = true;
                }
            }
        }
    }

    // STATISTICS METHODS/OTHER
    // Mean
    public void findMean() {
        int total = 0, counter = 0;
        for (int i = leftBad; i <= rightBad; i++) {
            total += array[i].getScore();
            counter++;
        }
        System.out.println("Mean: " + (int) (((double) total / counter) * 100 + .5) / 100.0);
    }

    // Median
    public void findMedian() {
        int length = rightBad - leftBad + 1;
        double median = 0;
        if (length % 2 == 0) {
            median = (double) (array[leftBad + length / 2].getScore() + array[rightBad - length / 2].getScore()) / 2;
        } else {
            median = array[leftBad + length / 2].getScore();
        }
        System.out.println("Median: " + median);
    }

    // Highest/Lowest Score
    public void findExtrema() {
        System.out.println(
                "Lowest Score: " + array[leftBad].getScore() + "\nHighest Score: " + array[rightBad].getScore());
    }

    // To be called after array is sorted by score, calls checkScore
    // Moves leftBad and rightBad to first indices of a score 0 - 100
    public int checkScores() {
        leftBad = 0;
        rightBad = filled - 1;
        int output = 0;
        while (leftBad < filled && withinRange(array[leftBad].getScore())) {
            leftBad++;
            output++;
        }
        while (rightBad > leftBad && withinRange(array[rightBad].getScore())) {
            rightBad--;
            output++;
        }
        return output;
    }

    // Returns false if given score is between 0 and 100
    // no usage of private data so static
    public static boolean withinRange(int score) {
        return score > gradeMax || score < gradeMin;
    }

    // Percentage of each grade
    public void gradePercents() {
        // One position for each letter grade
        int[] grades = new int[5];
        int total = 0;
        for (int i = leftBad; i <= rightBad; i++) {
            if (array[i].getScore() >= 90) {
                grades[0]++;
            } else if (array[i].getScore() >= 80) {
                grades[1]++;
            } else if (array[i].getScore() >= 70) {
                grades[2]++;
            } else if (array[i].getScore() >= 65) {
                grades[3]++;
            } else {
                grades[4]++;
            }
            total++;
        }
        System.out.println("\nA: " + ((int) (((double) grades[0] / total) * 1000 + .5) / 10.0) + "%");
        System.out.println("B: " + ((int) (((double) grades[1] / total) * 1000 + .5) / 10.0) + "%");
        System.out.println("C: " + ((int) (((double) grades[2] / total) * 1000 + .5) / 10.0) + "%");
        System.out.println("D: " + ((int) (((double) grades[3] / total) * 1000 + .5) / 10.0) + "%");
        System.out.println("F: " + ((int) (((double) grades[4] / total) * 1000 + .5) / 10.0) + "%");
    }

    // Prints array, "arrayToString" to distinguish from toString in Student
    public void arrayToString() {
        for (int i = 0; i < filled; i++) {
            System.out.println("\n" + array[i].toString());
        }
    }

    // Binary search method
    public static int binarySearch(Student[] list, int target) {
        int left = 0;
        int right = list.length - 1;
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
        System.out.print("Enter an ID Number: ");
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
        boolean sentinel = true;
        while (sentinel) {
            System.out.print("Search for an ID Number: ");
            roster.findId();
            System.out.println("Would you like to continue? (Y/N)");
            sentinel = in.readLine().charAt(0) != 'Y';
        }

    }
}