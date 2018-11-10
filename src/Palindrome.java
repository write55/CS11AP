
/*
Aaron Wu
11/7/18
Program to take user input for a string and check if it's a palindrome, loops until the user enters 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static boolean palindromeCheck(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (right > left) {
            while (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                if (left == str.length()) {
                    return false;
                }
            }
            while (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(str.charAt(left)) == Character.toLowerCase(str.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("The program will print out OK for a Palindrome and X for not a palindrome."
                + "\nEnter 0 to exit the program.");
        System.out.print("Enter a String: ");
        String input = in.readLine();
        while (!input.equals("0")) {
            if (palindromeCheck(input)) {
                System.out.println("OK");
            } else {
                System.out.println("X");
            }
            System.out.print("Enter a new string: ");
            input = in.readLine();
        }
    }

}
