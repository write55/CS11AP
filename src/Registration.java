
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
    public static final int CALIGRAPHY_LIMIT = 4;
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
        // Makes Sure course code is always uppercase
        char course = Character.toUpperCase(in.readLine().charAt(0));
        while (course != 'B' && course != 'C' && course != 'P' && course != 'S' && course != 'W') {
            System.out.println("Course character doesn't match with any available courses");
            System.out.print("Try Again: ");
            course = Character.toUpperCase(in.readLine().charAt(0));
        }
        return course;
    }

    // CHANGE COURSE CODE TO FULL NAME
    public static String getCourseName(char input) {
        String name;
        if (input == 'B') {
            name = "Batik";
        } else if (input == 'C') {
            name = "Caligraphy";
        } else if (input == 'P') {
            name = "Painting";
        } else if (input == 'S') {
            name = "Sculpture";
        } else {
            name = "Weaving";
        }
        return name;
    }

    // TOSTRING FOR NUMBER OF STUDENTS IN EACH COURSE
    public String toString() {
        return "Final Course Counts:" + "\nBatik: " + this.batik + "\nCaligraphy: " + this.calligraphy + "\nPainting: "
                + this.painting + "\nSculpture: " + this.sculpture + "\nWeaving: " + this.weaving;
    }

    // ADD STUDENT TO GIVEN CLASS
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
                    + getCourseName(course));
            id = inputId();
            info.setClassCounts(course);
        }
        System.out.println("Program ended");
        System.out.println("\n" + info.toString());

        // Variables for each section
        int batikS = getSections(BATIK_LIMIT, info.batik);
        int calligraphyS = getSections(CALIGRAPHY_LIMIT, info.calligraphy);
        int paintingS = getSections(PAINTING_LIMIT, info.painting);
        int sculptureS = getSections(SCULPTURE_LIMIT, info.sculpture);
        int weavingS = getSections(WEAVING_LIMIT, info.weaving);

        // Print Section numbers
        System.out.println("\nBatik Sections: " + batikS +
                "\nCaligraphy Sections: " + calligraphyS +
                "\nPainting Sections: " + paintingS +
                "\nSculpture Sections: " + sculptureS +
                "\nWeaving Sections: " + weavingS
        );


    }

}