/*
Aaron Wu
1/31/19
Program to handle guest objects, allows for reading of a file and usage of various other methods to organize a list of guests
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GuestList {

    private ArrayList<Guest> guests = new ArrayList<>();

    public GuestList() {

    }

    // FILE READER METHODS
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
        System.out.println("Reading Complete.");
        inFile.close();
    }

    private void tokenizeString(String input) {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            guests.add(new Guest(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
        }
    }

    // SORT GUESTS
    public void insertionSort() {
        for (int j = 1; j < guests.size(); j++) {
            Guest temp = guests.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.compareGuests(guests.get(possibleIndex - 1)) < 0) {
                guests.set(possibleIndex, guests.get(possibleIndex - 1));
                possibleIndex--;
            }
            guests.set(possibleIndex, temp);
        }
    }

    // BINARY SEARCH - returns object reference to target guest
    public Guest binarySearch(Guest target) {
        int left = 0;
        int right = guests.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (guests.get(middle).compareGuests(target) > 0) {
                right = middle - 1;
            } else if (guests.get(middle).compareGuests(target) < 0) {
                left = middle + 1;
            } else {
                return guests.get(middle);
            }
        }
        return null;
    }

    // ADD GUEST - puts in sorted position
    public void addGuest(Guest newGuest) {
        if (binarySearch(newGuest) == null) {
            int posIndex = guests.size();
            while (posIndex > 0 && newGuest.compareGuests(guests.get(posIndex - 1)) < 0) {
                posIndex--;
            }
            guests.add(posIndex, newGuest);
            System.out.println("Guest Added");
        } else {
            System.out.println("Guest already on List");
        }
    }

    // FUNCTIONS
    // Allows user to enter name, returns a Guest object with that name
    public static Guest enterGuestName() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Guest temp = new Guest("", "", "", "");
        System.out.print("Enter the first name of a guest: ");
        temp.setFirstName(in.readLine());
        System.out.print("Enter the last name of a guest: ");
        temp.setLastName(in.readLine());
        return temp;
    }

    // Changes given object's company, will only be used on new Guest
    public void changeCompany(Guest temp) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a company: ");
        temp.setCompany(in.readLine());
    }

    // Counts number of guests for each response and prints
    public void guestNumbers() {
        int attending = 0, notAttending = 0, maybe = 0;
        for (Guest i : guests) {
            if (i.getResponse().equals("yes")) {
                attending++;
            } else if (i.getResponse().equals("no")) {
                notAttending++;
            } else {
                maybe++;
            }
        }
        System.out.println("Number of guests attending: " + attending + "\nNumber of guests not attending: "
                + notAttending + "\nNumber of guests without response: " + maybe);
    }

    // Allows user to change a given guest's response
    public void changeResponse(Guest temp) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter response: ");
        String response = in.readLine();
        if (response.equals(temp.getResponse())) {
            System.out.println("New response same as old, no changes made");
        } else {
            temp.setResponse(response);
        }
    }

    // Find a guest's colleagues
    public void findColleagues(Guest temp) {
        System.out.println("\nCompany: " + temp.getCompany());
        for (Guest i : guests) {
            if (i.getCompany().equals(temp.getCompany())) {
                System.out.println(i.toString());
            }
        }
    }

    // Print guest list
    public void printList() {
        for (Guest i : guests) {
            System.out.println(i.toString());
        }
    }

    // Command Chooser
    public void runStuff(char input) throws IOException {
        Guest temp;
        if (input == 'G' || input == 'R' || input == 'C') {
            // Kind of a convoluted setup, to avoid putting if(temp==null) multiple times in G R and C
            temp = binarySearch(enterGuestName());
            if (temp == null) {
                System.out.println("\nGuest Not on List");
            } else if (input == 'G') {
                System.out.println(temp.toString());
            } else if (input == 'R') {
                String response = temp.getResponse();
                if (response.equals("?")) {
                    response = "maybe";
                }
                System.out.println("Old Response: " + response);
                changeResponse(temp);
                System.out.println("Response recorded");
            } else {
                findColleagues(temp);
            }
        } else if (input == 'L') {
            printList();
        } else if (input == 'N') {
            guestNumbers();
        } else if (input == 'A') {
            temp = enterGuestName();
            changeCompany(temp);
            changeResponse(temp);
            addGuest(temp);
        } else {
            System.out.println("Not a command, try again");
        }
    }

    public static void main(String[] args) throws IOException {
        GuestList list = new GuestList();
        list.readFile();
        list.insertionSort();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nCommands: \nG: Find a Guest\nL: List Guests\nN: Number of Guests\nA: Add a Guest\nR: Change a Response\nC: Display a Guest's Colleagues\nQ: Quit");
        System.out.print("\nEnter a Command: ");
        char input = in.readLine().toUpperCase().charAt(0);
        while (input != 'Q') {
            list.runStuff(input);
            System.out.print("\nEnter a Command: ");
            input = in.readLine().toUpperCase().charAt(0);
        }
        System.out.println("Program Complete, Quitting");
    }

}

/*
Enter relative path of file: GuestList.txt

Reading File...

Reading Complete.

Commands:
G: Find a Guest
L: List Guests
N: Number of Guests
A: Add a Guest
R: Change a Response
C: Display a Guest's Colleagues
Q: Quit

Enter a Command: L

Name: Field, April
Company: APL
Response: maybe

Name: Field, Electromagnetic
Company: APL
Response: maybe

Name: Field, Sally
Company: APL
Response: maybe

Name: Field, Zoe
Company: APL
Response: maybe

Name: Geek, Ima
Company: DGT
Response: no

Name: Guest, Sally
Company: DGT
Response: no

Name: Guest, Zoe
Company: APL
Response: yes

Name: Keys, Qwerty
Company: IBM
Response: no

Name: Kulate, Cal
Company: DGT
Response: no

Name: List, Linc
Company: APL
Response: yes

Name: Nerd, Ura
Company: IBM
Response: ?R

Name: Pascal, Blaise
Company: APL
Response: no

Name: Queue, Suzy
Company: IBM
Response: no

Name: Windoes, Closda
Company: APL
Response: yes

Enter a Command: G
Enter the first name of a guest: Ima
Enter the last name of a guest: Geek

Name: Geek, Ima
Company: DGT
Response: no

Enter a Command: G
Enter the first name of a guest: Pointoa
Enter the last name of a guest: List

Guest Not on List

Enter a Command: G
Enter the first name of a guest: Closda
Enter the last name of a guest: Windoes

Name: Windoes, Closda
Company: APL
Response: yes

Enter a Command: N
Number of guests attending: 3
Number of guests not attending: 6
Number of guests without response: 5

Enter a Command: G
Enter the first name of a guest: Electromagnetic
Enter the last name of a guest: Field

Name: Field, Electromagnetic
Company: APL
Response: maybe

Enter a Command: G
Enter the first name of a guest: Olivia
Enter the last name of a guest: Apple

Guest Not on List

Enter a Command: G
Enter the first name of a guest: Asdfgh
Enter the last name of a guest: Keys

Guest Not on List

Enter a Command: G
Enter the first name of a guest: John
Enter the last name of a guest: Pappoudoupolivsky

Guest Not on List

Enter a Command: G
Enter the first name of a guest: Sally
Enter the last name of a guest: Field

Name: Field, Sally
Company: APL
Response: maybe

Enter a Command: G
Enter the first name of a guest: April
Enter the last name of a guest: Field

Name: Field, April
Company: APL
Response: maybe

Enter a Command: G
Enter the first name of a guest: Ima
Enter the last name of a guest: Guest

Guest Not on List

Enter a Command: X
Not a command, try again

Enter a Command: Y
Not a command, try again

Enter a Command: Z
Not a command, try again

Enter a Command: L

Name: Field, April
Company: APL
Response: maybe

Name: Field, Electromagnetic
Company: APL
Response: maybe

Name: Field, Sally
Company: APL
Response: maybe

Name: Field, Zoe
Company: APL
Response: maybe

Name: Geek, Ima
Company: DGT
Response: no

Name: Guest, Sally
Company: DGT
Response: no

Name: Guest, Zoe
Company: APL
Response: yes

Name: Keys, Qwerty
Company: IBM
Response: no

Name: Kulate, Cal
Company: DGT
Response: no

Name: List, Linc
Company: APL
Response: yes

Name: Nerd, Ura
Company: IBM
Response: ?R

Name: Pascal, Blaise
Company: APL
Response: no

Name: Queue, Suzy
Company: IBM
Response: no

Name: Windoes, Closda
Company: APL
Response: yes

Enter a Command: G
Enter the first name of a guest: Blaise
Enter the last name of a guest: Pascal

Name: Pascal, Blaise
Company: APL
Response: no

Enter a Command: A
Enter the first name of a guest: Suzy
Enter the last name of a guest: Queue
Enter a company: IBM
Enter response: no
Guest already on List

Enter a Command: A
Enter the first name of a guest: Asdfgh
Enter the last name of a guest: Keys
Enter a company: DGT
Enter response: yes
Guest Added

Enter a Command: A
Enter the first name of a guest: Mike
Enter the last name of a guest: Rochip
Enter a company: DGT
Enter response: ?
Guest Added

Enter a Command: R
Enter the first name of a guest: Ima
Enter the last name of a guest: Geek
Old Response: no
Enter response: yes
Response recorded

Enter a Command: A
Enter the first name of a guest: Amy
Enter the last name of a guest: Rochip
Enter a company: IBM
Enter response: ?
Guest Added

Enter a Command: A
Enter the first name of a guest: Didja
Enter the last name of a guest: Windoes
Enter a company: APL
Enter response: yes
Guest Added

Enter a Command: A
Enter the first name of a guest: Data
Enter the last name of a guest: Field
Enter a company: APL
Enter response: no
Guest Added

Enter a Command: R
Enter the first name of a guest: Seymour
Enter the last name of a guest: Math

Guest Not on List

Enter a Command: R
Enter the first name of a guest: Elena
Enter the last name of a guest: Zaitsoff

Guest Not on List

Enter a Command: A
Enter the first name of a guest: Howard
Enter the last name of a guest: Yadoing
Enter a company: DGT
Enter response: no
Guest Added

Enter a Command: R
Enter the first name of a guest: Asdfgh
Enter the last name of a guest: Keys
Old Response: yes
Enter response: no
Response recorded

Enter a Command: R
Enter the first name of a guest: Mike
Enter the last name of a guest: Rochip
Old Response: maybe
Enter response: ?
New response same as old, no changes made
Response recorded

Enter a Command: R
Enter the first name of a guest: Alice
Enter the last name of a guest: Ardvaark

Guest Not on List

Enter a Command: A
Enter the first name of a guest: Alice
Enter the last name of a guest: Ardvaark
Enter a company: IBM
Enter response: yes
Guest Added

Enter a Command: G
Enter the first name of a guest: Amy
Enter the last name of a guest: Rochip

Name: Rochip, Amy
Company: IBM
Response: maybe

Enter a Command: G
Enter the first name of a guest: Beth
Enter the last name of a guest: Yerrmoniesworth

Guest Not on List

Enter a Command: L

Name: Ardvaark, Alice
Company: IBM
Response: yes

Name: Field, April
Company: APL
Response: maybe

Name: Field, Data
Company: APL
Response: no

Name: Field, Electromagnetic
Company: APL
Response: maybe

Name: Field, Sally
Company: APL
Response: maybe

Name: Field, Zoe
Company: APL
Response: maybe

Name: Geek, Ima
Company: DGT
Response: yes

Name: Guest, Sally
Company: DGT
Response: no

Name: Guest, Zoe
Company: APL
Response: yes

Name: Keys, Asdfgh
Company: DGT
Response: no

Name: Keys, Qwerty
Company: IBM
Response: no

Name: Kulate, Cal
Company: DGT
Response: no

Name: List, Linc
Company: APL
Response: yes

Name: Nerd, Ura
Company: IBM
Response: ?R

Name: Pascal, Blaise
Company: APL
Response: no

Name: Queue, Suzy
Company: IBM
Response: no

Name: Rochip, Amy
Company: IBM
Response: maybe

Name: Rochip, Mike
Company: DGT
Response: maybe

Name: Windoes, Closda
Company: APL
Response: yes

Name: Windoes, Didja
Company: APL
Response: yes

Name: Yadoing, Howard
Company: DGT
Response: no

Enter a Command: A
Enter the first name of a guest: Data
Enter the last name of a guest: Field
Enter a company: APL
Enter response: no
Guest already on List

Enter a Command: A
Enter the first name of a guest: Genevieve
Enter the last name of a guest: Stapos
Enter a company: DGT
Enter response: yes
Guest Added

Enter a Command: A
Enter the first name of a guest: Abe
Enter the last name of a guest: Ardvaark
Enter a company: IBM
Enter response: ?
Guest Added

Enter a Command: A
Enter the first name of a guest: Doyour
Enter the last name of a guest: Math
Enter a company: DGT
Enter response: ?
Guest Added

Enter a Command: A
Enter the first name of a guest: Iluv
Enter the last name of a guest: Math
Enter a company: DGT
Enter response: yes
Guest Added

Enter a Command: C
Enter the first name of a guest: Cal
Enter the last name of a guest: Kulate

Company: DGT

Name: Geek, Ima
Company: DGT
Response: yes

Name: Guest, Sally
Company: DGT
Response: no

Name: Keys, Asdfgh
Company: DGT
Response: no

Name: Kulate, Cal
Company: DGT
Response: no

Name: Math, Doyour
Company: DGT
Response: maybe

Name: Math, Iluv
Company: DGT
Response: yes

Name: Rochip, Mike
Company: DGT
Response: maybe

Name: Stapos, Genevieve
Company: DGT
Response: yes

Name: Yadoing, Howard
Company: DGT
Response: no

Enter a Command: C
Enter the first name of a guest: Linc
Enter the last name of a guest: List

Company: APL

Name: Field, April
Company: APL
Response: maybe

Name: Field, Data
Company: APL
Response: no

Name: Field, Electromagnetic
Company: APL
Response: maybe

Name: Field, Sally
Company: APL
Response: maybe

Name: Field, Zoe
Company: APL
Response: maybe

Name: Guest, Zoe
Company: APL
Response: yes

Name: List, Linc
Company: APL
Response: yes

Name: Pascal, Blaise
Company: APL
Response: no

Name: Windoes, Closda
Company: APL
Response: yes

Name: Windoes, Didja
Company: APL
Response: yes

Enter a Command: C
Enter the first name of a guest: Alice
Enter the last name of a guest: Ardvaark

Company: IBM

Name: Ardvaark, Abe
Company: IBM
Response: maybe

Name: Ardvaark, Alice
Company: IBM
Response: yes

Name: Keys, Qwerty
Company: IBM
Response: no

Name: Nerd, Ura
Company: IBM
Response: ?R

Name: Queue, Suzy
Company: IBM
Response: no

Name: Rochip, Amy
Company: IBM
Response: maybe

Enter a Command: A
Enter the first name of a guest: Sally
Enter the last name of a guest: Pascal
Enter a company: FCA
Enter response: yes
Guest Added

Enter a Command: G
Enter the first name of a guest: Sally
Enter the last name of a guest: Pascal

Name: Pascal, Sally
Company: FCA
Response: yes

Enter a Command: C
Enter the first name of a guest: Sally
Enter the last name of a guest: Pascal

Company: FCA

Name: Pascal, Sally
Company: FCA
Response: yes

Enter a Command: G
Enter the first name of a guest: Blaise
Enter the last name of a guest: Field

Guest Not on List

Enter a Command: C
Enter the first name of a guest: Jane
Enter the last name of a guest: Doe

Guest Not on List

Enter a Command: N
Number of guests attending: 9
Number of guests not attending: 8
Number of guests without response: 9

Enter a Command: L

Name: Ardvaark, Abe
Company: IBM
Response: maybe

Name: Ardvaark, Alice
Company: IBM
Response: yes

Name: Field, April
Company: APL
Response: maybe

Name: Field, Data
Company: APL
Response: no

Name: Field, Electromagnetic
Company: APL
Response: maybe

Name: Field, Sally
Company: APL
Response: maybe

Name: Field, Zoe
Company: APL
Response: maybe

Name: Geek, Ima
Company: DGT
Response: yes

Name: Guest, Sally
Company: DGT
Response: no

Name: Guest, Zoe
Company: APL
Response: yes

Name: Keys, Asdfgh
Company: DGT
Response: no

Name: Keys, Qwerty
Company: IBM
Response: no

Name: Kulate, Cal
Company: DGT
Response: no

Name: List, Linc
Company: APL
Response: yes

Name: Math, Doyour
Company: DGT
Response: maybe

Name: Math, Iluv
Company: DGT
Response: yes

Name: Nerd, Ura
Company: IBM
Response: ?R

Name: Pascal, Blaise
Company: APL
Response: no

Name: Pascal, Sally
Company: FCA
Response: yes

Name: Queue, Suzy
Company: IBM
Response: no

Name: Rochip, Amy
Company: IBM
Response: maybe

Name: Rochip, Mike
Company: DGT
Response: maybe

Name: Stapos, Genevieve
Company: DGT
Response: yes

Name: Windoes, Closda
Company: APL
Response: yes

Name: Windoes, Didja
Company: APL
Response: yes

Name: Yadoing, Howard
Company: DGT
Response: no

Enter a Command: Q
Program Complete, Quitting
 */