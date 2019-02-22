
/*
Aaron Wu
2/21/19
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSStudentList {

    private ArrayList<HSStudent> students = new ArrayList<>();

    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            tokenizeString(input);
            input = inFile.readLine();
        }
        inFile.close();
        System.out.println("\nReading Complete.\n");
    }

    private void tokenizeString(String input) {
        try {
            StringTokenizer st = new StringTokenizer(input);
            String fn = st.nextToken(); // first name
            String ln = st.nextToken(); // last name
            int gl = Integer.parseInt(st.nextToken()); // grade level
            double qpa = Double.parseDouble(st.nextToken());
            HSStudent temp;
            if (gl == 9) {
                temp = new Freshman(fn, ln, gl, qpa, Integer.parseInt(st.nextToken()));
                // Next token is int for referrals
            } else if (gl == 10) {
                temp = new Sophomore(fn, ln, gl, qpa, st.nextToken().toUpperCase().charAt(0));
                // Next token is double for math grade
            } else if (gl == 11) {
                String keystone = st.nextToken();
                if (st.hasMoreTokens()) {
                    keystone += st.nextToken();
                    // for "Below Basic"
                }
                temp = new Junior(fn, ln, gl, qpa, keystone);
                // Next token is string for keystone grade
            } else {
                String test = st.nextToken().toLowerCase();
                boolean portfoliodone = test.equals("true") || test.equals("yes") || test.equals("done");
                temp = new Senior(fn, ln, gl, qpa, portfoliodone, Double.parseDouble(st.nextToken()));
                // Next tokens are boolean for portfolio done and school fines
            }
            students.add(temp);
        } catch (Exception e) {
            System.out.println("Error in formatting");
        }
    }

    public void insertionSort() {
        for (int j = 1; j < students.size(); j++) {
            HSStudent temp = students.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.compareTo(students.get(possibleIndex - 1)) < 0) {
                students.set(possibleIndex, students.get(possibleIndex - 1));
                possibleIndex--;
            }
            students.set(possibleIndex, temp);
        }
    }

    public void printList() {
        for (HSStudent i : students) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        HSStudentList list = new HSStudentList();
        list.readFile();
        list.insertionSort();
        System.out.println("Sorted List:\n");
        list.printList();
        System.out.println("\nProgram Complete.");
    }

}
