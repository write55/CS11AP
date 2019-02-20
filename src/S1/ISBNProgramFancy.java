package S1;
// Aaron Wu
// 9/12/18
// Program to take ISBN Number and calculate a check digit for comparison with given check digit
// This is the Fancy version with limited console input, a quicker algorithm, and a thing that says if the check digits are the same

import java.util.Scanner;

public class ISBNProgramFancy {

    public static void main(String[] args) {

        // GET INPUT

        Scanner in = new Scanner(System.in);
        String ISBNorig = "";

        try {
            System.out.println("Enter ISBN Number");
            ISBNorig = in.nextLine();
            if (ISBNorig.length() != 13) {
                System.out.println("Try again, program will now terminate");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("Try again, program will now terminate");
            System.exit(1);
        }

        in.close();

        // REMOVE DASHES

        // ISBNorig = "0-393-96945-2";
        int loc1 = ISBNorig.indexOf("-");
        int loc2 = ISBNorig.indexOf("-", loc1 + 1);
        int loc3 = ISBNorig.indexOf("-", loc2 + 1);

        String ISBNtemp1 = ISBNorig.substring(0, loc1);
        String ISBNtemp2 = ISBNorig.substring(loc1 + 1, loc2);
        String ISBNtemp3 = ISBNorig.substring(loc2 + 1, loc3);
        String ISBNtemp4 = ISBNorig.substring(loc3 + 1);

        String ISBN = ISBNtemp1 + ISBNtemp2 + ISBNtemp3 + ISBNtemp4;

        // MULTIPLY VALUES
        int check = 0, value;

        for (int i = 0; i < 9; i++) {
            value = (int) (ISBN.charAt(0 + i) - '0') * (10 - i);
            check += value;
        }

        check = 10 - ((check - 1) % 11);

        // PRINT STUFF
        System.out.println("ISBN Number: " + ISBNorig);
        String digits = "0123456789X";
        System.out.println("Check digit from number: " + ISBNorig.charAt(12));
        System.out.println("Check digit from calculations: " + digits.charAt(check));

        // CHECK IF DIGITS MATCH
        if (check == (ISBNorig.charAt(12) - '0')) {
            System.out.println("Check digit is correct, proceed");
        } else {
            System.out.println("Check digit is incorrect, try again");
        }

    }

}
