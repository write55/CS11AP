package S2;/*
Aaron Wu
2/21/19
ArrayList of S2.HSStudent objects and sub-objects
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
        System.out.println("Reading Complete.\n");
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
                // Next token is char for math grade
            } else if (gl == 11) {
                String keystone = st.nextToken();
                if (st.hasMoreTokens()) {
                    keystone += " " + st.nextToken();
                    // for "Below Basic"
                }
                temp = new Junior(fn, ln, gl, qpa, keystone);
                // Next token is string for keystone grade
            } else {
                String test = st.nextToken().toLowerCase();
                boolean portfolioDone = test.equals("true") || test.equals("yes") || test.equals("done");
                temp = new Senior(fn, ln, gl, qpa, portfolioDone, Double.parseDouble(st.nextToken()));
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
        System.out.println("Sorted List:");
        list.printList();
        System.out.println("\nProgram Complete.");
    }

}

/*
OUTPUT

Enter relative path of file: HSS.txt

Reading File...

Reading Complete.

Sorted List:

First Name: Aname
Last Name: Whatever
Grade: S2.Freshman
QPA: 1.0
Discipline Referrals in Middle School: 1000

First Name: Bname
Last Name: Whatever
Grade: S2.Freshman
QPA: 4.0
Discipline Referrals in Middle School: 10

First Name: Cname
Last Name: Whatever
Grade: S2.Freshman
QPA: 2.1
Discipline Referrals in Middle School: 0

First Name: AAaaayyyyy
Last Name: Aaaaaaaaaaaay
Grade: S2.Sophomore
QPA: 4.0
Math Grade S2.Freshman Year: F

First Name: BBBBBBBB
Last Name: Aaaaaaaaaz
Grade: S2.Sophomore
QPA: 4.0
Math Grade S2.Freshman Year: A

First Name: Adolph
Last Name: Wolfeschlegelsteinhausenbergerdorff
Grade: S2.Sophomore
QPA: 4.0
Math Grade S2.Freshman Year: C

First Name: FirstName
Last Name: LastName
Grade: S2.Junior
QPA: 3.18
Algebra Keystone Score: Below Basic

First Name: Aaron
Last Name: Wu
Grade: S2.Junior
QPA: 0.0
Algebra Keystone Score: Below Basic

First Name: Witu
Last Name: Low
Grade: S2.Senior
QPA: 4.0
Portfolio Complete: true
Fines: $0.0

First Name: Sumting
Last Name: Wong
Grade: S2.Senior
QPA: 4.0
Portfolio Complete: true
Fines: $12.0

First Name: Jorgen
Last Name: Wu
Grade: S2.Senior
QPA: 1.0
Portfolio Complete: false
Fines: $2.0E9

Program Complete.

 */