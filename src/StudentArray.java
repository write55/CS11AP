/*
Aaron Wu
12/12/18

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
    private double mean;
    private double median;
    private int highest;
    private int lowest;
    // Indexes of bad data, counter returned by method
    private int leftBad;
    private int rightBad;

    // NO ARGUMENT CONSTRUCTOR
    public StudentArray() {

    }

    // GETTERS
    public int getFilled() {
        return filled;
    }

    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    public int getHighest() {
        return highest;
    }

    public int getLowest() {
        return lowest;
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
        mean = (int) (((double) total / counter) * 100 + .5) / 100.0;
    }

    // Median
    public void findMedian() {
        int length = rightBad - leftBad + 1;
        if (length % 2 == 0) {
            median = (array[leftBad + length / 2].getScore() + array[rightBad - length / 2].getScore()) / 2;
        } else {
            median = array[leftBad + length / 2].getScore();
        }
    }

    // Highest/Lowest Score
    public void findExtrema() {
        lowest = array[leftBad].getScore();
        highest = array[rightBad].getScore();
    }

    // To be called after array is sorted by score, calls checkScore
    public int checkScores() {
        leftBad = 0;
        rightBad = filled - 1;
        int output = 0;
        while (leftBad < filled && checkScore(array[leftBad].getScore())) {
            leftBad++;
            output++;
        }
        while (rightBad > leftBad && checkScore(array[rightBad].getScore())) {
            rightBad--;
            output++;
        }
        return output;
    }

    // Returns false if given score is between 0 and 100
    // Static for usage in other methods without an object
    public static boolean checkScore(int score) {
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
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println((char) (i + 65) + ": " + (int) (((double) grades[i] / total) * 100 + .5) / 100.0);
        }
    }

    // Prints array, "arrayToString" to distinguish from toString in Student
    public void arrayToString() {
        for (int i = 0; i < filled; i++) {
            System.out.println("\n" + array[i].toString());
        }
    }

    public static void main(String[] args) throws IOException {
        StudentArray roster = new StudentArray();
        System.out.println("Program will read student's ids, scores, and course choices from a file"
                + "\nMake sure it is properly formatted or the program will not work correctly"
                + "\nIf your score is over 100 or below 0 it will not be included in statistics calculations but will still be printed");
        roster.readFile();
        roster.sortId();
        System.out.println("Complete list - sorted by ID");
        roster.arrayToString();
        roster.sortScore();
        int badData = roster.checkScores();
        System.out.println("\nStatistics:");
        System.out.println("Bad Data: " + badData);
        if (badData != roster.getFilled()) {
            roster.findMean();
            roster.findExtrema();
            roster.findMedian();
            System.out.println("\nMean: " + roster.getMean() + "\nMedian: " + roster.getMedian() + "\nHighest Score: "
                    + roster.getHighest() + "\nLowest Score: " + roster.getLowest());
            roster.gradePercents();
        } else {
            System.out.println("All scores are outside of 0 - 100, skipping statistics");
        }
    }
}