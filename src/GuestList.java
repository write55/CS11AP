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
            int posIndex = 0;
            while (posIndex < guests.size() && newGuest.compareGuests(guests.get(posIndex + 1)) < 0) {
                posIndex++;
            }
            guests.add(posIndex, newGuest);
            System.out.println("Guest Added");
        } else {
            System.out.println("Guest already on List" + guests.get(guests.indexOf(newGuest)).toString());
        }

    }

    // FUNCTIONS
    // Allows user to enter name, returns a Guest object with that name
    public static Guest enterGuestName() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Guest temp = new Guest("", "", "", "");
        System.out.print("Enter the last name of a guest: ");
        temp.setLastName(in.readLine());
        System.out.print("Enter the first name of a guest: ");
        temp.setFirstName(in.readLine());
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
            System.out.println("Response recorded");
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
        if (input == 'G') {
            temp = binarySearch(enterGuestName());
            if (temp == null) {
                System.out.println("Guest Not on List");
            } else {
                System.out.println(temp.toString());
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
        } else if (input == 'R') {
            temp = binarySearch(enterGuestName());
            if (temp == null) {
                System.out.println("Guest not on list");
            } else {
                String response = temp.getResponse();
                if (response.equals("?")) {
                    response = "maybe";
                }
                System.out.println("Old Response: " + response);
                changeResponse(temp);
            }
        } else if (input == 'C') {
            temp = binarySearch(enterGuestName());
            if (temp == null) {
                System.out.println("Guest not on list");
            } else {
                findColleagues(binarySearch(enterGuestName()));
            }
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
        list.printList();
    }

}
