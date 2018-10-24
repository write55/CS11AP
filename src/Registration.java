
/*
Aaron Wu
10/22/18
This program allows the user to input and ID and desired course, then adds the student to the given class.
The program also finds the number of sections needed, and allows the user to change class limits and the limit for each section
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Registration {

	// CONSTANTS
	public static final int BATIK_LIMIT = 6;
	public static final int CALLIGRAPHY_LIMIT = 4;
	public static final int PAINTING_LIMIT = 7;
	public static final int SCULPTURE_LIMIT = 4;
	public static final int WEAVING_LIMIT = 5;
	public static final int SENTINEL = 0;
	public static final int SECTION_LIMIT = 2;

	// PRIVATE DATA
	private int batik = 0;
	private int calligraphy = 0;
	private int painting = 0;
	private int sculpture = 0;
	private int weaving = 0;

	// CONSTRUCTOR (No Arguments)
	public Registration() {
	}

	// INPUT METHODS
	// First is for ID
	public static int inputId() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your ID Number: ");
		int id = new Integer(in.readLine());
		return id;
	}

	// Second is for Course code, also error traps
	public static char inputCourseCode() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your Course Code: ");
		// Makes sure course code is always uppercase
		char course = Character.toUpperCase(in.readLine().charAt(0));
		while (course != 'B' && course != 'C' && course != 'P' && course != 'S' && course != 'W') {
			System.out.println("Course character doesn't match with any available courses");
			System.out.print("Try Again: ");
			course = Character.toUpperCase(in.readLine().charAt(0));
		}
		return course;
	}

	// CHANGE COURSE CODE TO FULL NAME - code given in argument
	public static String getCourseName(char input) {
		String name;
		if (input == 'B') {
			name = "Batik";
		} else if (input == 'C') {
			name = "Calligraphy";
		} else if (input == 'P') {
			name = "Painting";
		} else if (input == 'S') {
			name = "Sculpture";
		} else {
			name = "Weaving";
		}
		return name;
	}

	// TOSTRING - gives number of students in each course
	public String toString() {
		return "Final Course Counts:" + "\nBatik: " + this.batik + "\nCalligraphy: " + this.calligraphy + "\nPainting: "
				+ this.painting + "\nSculpture: " + this.sculpture + "\nWeaving: " + this.weaving;
	}

	// ADD STUDENT TO CLASS - code given in argument
	public void setClassCounts(char input) {
		if (input == 'B') {
			this.batik++;
		} else if (input == 'C') {
			this.calligraphy++;
		} else if (input == 'P') {
			this.painting++;
		} else if (input == 'S') {
			this.sculpture++;
		} else {
			this.weaving++;
		}
	}

	// CALCULATE SECTION COUNTS - generalized to work with every course
	public static int getSections(int limit, int students) {
		int sections = 0;
		if (students > SECTION_LIMIT) {
			while (students >= 1) {
				students -= limit;
				sections++;
			}
		}
		return sections;
	}

	public static void main(String[] args) throws IOException {
		Registration info = new Registration();
		int id = inputId();
		while (id != SENTINEL) {
			char course = inputCourseCode();
			System.out.println("Added to given course" + "\n" + "ID Number: " + id + "\n" + "Course taken: "
					+ getCourseName(course) + "\n");
			info.setClassCounts(course);
			id = inputId();
		}
		System.out.println("Program ended");
		System.out.println("\n" + info.toString());

		// Variables for each section
		int batikS = getSections(BATIK_LIMIT, info.batik);
		int calligraphyS = getSections(CALLIGRAPHY_LIMIT, info.calligraphy);
		int paintingS = getSections(PAINTING_LIMIT, info.painting);
		int sculptureS = getSections(SCULPTURE_LIMIT, info.sculpture);
		int weavingS = getSections(WEAVING_LIMIT, info.weaving);

		// Print Section numbers
		System.out.println("\nSection Counts: " + "\nBatik Sections: " + batikS + "\nCalligraphy Sections: "
				+ calligraphyS + "\nPainting Sections: " + paintingS + "\nSculpture Sections: " + sculptureS
				+ "\nWeaving Sections: " + weavingS);
	}

}

// OUTPUT

// Enter your ID Number: 18
// Enter your Course Code: S
// Added to given course
// ID Number: 18
// Course taken: Sculpture
//
// Enter your ID Number: 24
// Enter your Course Code: S
// Added to given course
// ID Number: 24
// Course taken: Sculpture
//
// Enter your ID Number: 21
// Enter your Course Code: C
// Added to given course
// ID Number: 21
// Course taken: Calligraphy
//
// Enter your ID Number: 19
// Enter your Course Code: W
// Added to given course
// ID Number: 19
// Course taken: Weaving
//
// Enter your ID Number: 32
// Enter your Course Code: B
// Added to given course
// ID Number: 32
// Course taken: Batik
//
// Enter your ID Number: 20
// Enter your Course Code: S
// Added to given course
// ID Number: 20
// Course taken: Sculpture
//
// Enter your ID Number: 10
// Enter your Course Code: S
// Added to given course
// ID Number: 10
// Course taken: Sculpture
//
// Enter your ID Number: 11
// Enter your Course Code: C
// Added to given course
// ID Number: 11
// Course taken: Calligraphy
//
// Enter your ID Number: 12
// Enter your Course Code: C
// Added to given course
// ID Number: 12
// Course taken: Calligraphy
//
// Enter your ID Number: 35
// Enter your Course Code: R
// Course character doesn't match with any available courses
// Try Again: Y
// Course character doesn't match with any available courses
// Try Again: M
// Course character doesn't match with any available courses
// Try Again: W
// Added to given course
// ID Number: 35
// Course taken: Weaving
//
// Enter your ID Number: 38
// Enter your Course Code: W
// Added to given course
// ID Number: 38
// Course taken: Weaving
//
// Enter your ID Number: 40
// Enter your Course Code: B
// Added to given course
// ID Number: 40
// Course taken: Batik
//
// Enter your ID Number: 19
// Enter your Course Code: S
// Added to given course
// ID Number: 19
// Course taken: Sculpture
//
// Enter your ID Number: 98
// Enter your Course Code: S
// Added to given course
// ID Number: 98
// Course taken: Sculpture
//
// Enter your ID Number: 87
// Enter your Course Code: C
// Added to given course
// ID Number: 87
// Course taken: Calligraphy
//
// Enter your ID Number: 18
// Enter your Course Code: W
// Added to given course
// ID Number: 18
// Course taken: Weaving
//
// Enter your ID Number: 51
// Enter your Course Code: S
// Added to given course
// ID Number: 51
// Course taken: Sculpture
//
// Enter your ID Number: 52
// Enter your Course Code: W
// Added to given course
// ID Number: 52
// Course taken: Weaving
//
// Enter your ID Number: 67
// Enter your Course Code: S
// Added to given course
// ID Number: 67
// Course taken: Sculpture
//
// Enter your ID Number: 15
// Enter your Course Code: C
// Added to given course
// ID Number: 15
// Course taken: Calligraphy
//
// Enter your ID Number: 44
// Enter your Course Code: R
// Course character doesn't match with any available courses
// Try Again: C
// Added to given course
// ID Number: 44
// Course taken: Calligraphy
//
// Enter your ID Number: 48
// Enter your Course Code: S
// Added to given course
// ID Number: 48
// Course taken: Sculpture
//
// Enter your ID Number: 0
// Program ended
//
// Final Course Counts:
// Batik: 2
// Calligraphy: 6
// Painting: 0
// Sculpture: 9
// Weaving: 5
////
// Section Counts:
// Batik Sections: 0
// Calligraphy Sections: 2
// Painting Sections: 0
// Sculpture Sections: 3
// Weaving Sections: 1
