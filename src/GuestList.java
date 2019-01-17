
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GuestList {

	private ArrayList<Guest> guests;

	public GuestList() {

	}

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
	}

	private void tokenizeString(String input) {
		StringTokenizer st = new StringTokenizer(input);
		while (st.hasMoreTokens()) {
			addGuest(new Guest(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}
	}

	// Adds new guest in sorted order
	public void addGuest(Guest newGuest) {
		if (newGuest.getResponse() == "?") {
			newGuest.setResponse("maybe");
		}
		int posIndex = 0;
		while (posIndex < guests.size() && newGuest.compareGuests(guests.get(posIndex + 1)) > 0) {
			posIndex++;
		}
		guests.add(posIndex, newGuest);
	}

	public static void insertionSort(int[] elements) {
		for (int j = 1; j < elements.length; j++) {
			int temp = elements[j];
			int possibleIndex = j;
			while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
				elements[possibleIndex] = elements[possibleIndex - 1];
				possibleIndex--;
			}
			elements[possibleIndex] = temp;
		}
	}

	public int binarySearch(Guest target) {
		int left = 0;
		int right = guests.size() - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (guests.get(middle).compareGuests(target) < 0) {
				right = middle - 1;
			} else if (guests.get(middle).compareGuests(target) > 0) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

	public void printList() {
		for (Guest i : guests) {
			System.out.println(i.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		GuestList list = new GuestList();
		list.readFile();
		list.printList();
	}

	// integrate sorting and adding method, use binary search
}
