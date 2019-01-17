package Semester1;
// Aaron Wu
// 9/12/18
// Program to take ISBN Number and calculate a check digit for comparison with given check digit

public class ISBNProgram {
    public static void main(String[] args) {

        // REMOVE DASHES

        // Change ISBN here
        String ISBNorig = "0-7645-0417-7";

        // loc is location of dash
        int loc1 = ISBNorig.indexOf("-");
        int loc2 = ISBNorig.indexOf("-", loc1 + 1);
        int loc3 = ISBNorig.indexOf("-", loc2 + 1);

        String ISBNtemp1 = ISBNorig.substring(0, loc1);
        String ISBNtemp2 = ISBNorig.substring(loc1 + 1, loc2);
        String ISBNtemp3 = ISBNorig.substring(loc2 + 1, loc3);
        String ISBNtemp4 = ISBNorig.substring(loc3 + 1);

        String ISBN = ISBNtemp1 + ISBNtemp2 + ISBNtemp3 + ISBNtemp4;

        // MULTIPLY VALUES

        int zero, one, two, three, four, five, six, seven, eight, check;

        zero = (int) (ISBN.charAt(0) - '0') * 10;
        one = (int) (ISBN.charAt(1) - '0') * 9;
        two = (int) (ISBN.charAt(2) - '0') * 8;
        three = (int) (ISBN.charAt(3) - '0') * 7;
        four = (int) (ISBN.charAt(4) - '0') * 6;
        five = (int) (ISBN.charAt(5) - '0') * 5;
        six = (int) (ISBN.charAt(6) - '0') * 4;
        seven = (int) (ISBN.charAt(7) - '0') * 3;
        eight = (int) (ISBN.charAt(8) - '0') * 2;

        check = zero + one + two + three + four + five + six + seven + eight;

        check = 10 - ((check - 1) % 11);

        System.out.println("ISBN Number: " + ISBNorig);
        String digits = "0123456789X";
        System.out.println("Check digit from number: " + ISBNorig.charAt(12));
        System.out.println("Check digit from calculations: " + digits.charAt(check));

    }

}

// input: 0-7645-0417-7
// output:
// ISBN Number: 0-7645-0417-7
// Check digit from number: 7
// Check digit from calculations: 7

// input: 0-7654-0417-6
// output:
// ISBN Number: 0-7654-0417-6
// Check digit from number: 6
// Check digit from calculations: 6

// input: 0-912517-31-X
// output:
// ISBN Number: 0-912517-31-X
// Check digit from number: X
// Check digit from calculations: X

// input: 3-314-21145-7
// output:
// ISBN Number: 3-314-21145-7
// Check digit from number: 7
// Check digit from calculations: 7

// input: 91-29-65497-1
// output:
// ISBN Number: 91-29-65497-1
// Check digit from number: 1
// Check digit from calculations: 1

// input: 957-621-541-2
// output:
// ISBN Number: 957-621-541-2
// Check digit from number: 2
// Check digit from calculations: 2
