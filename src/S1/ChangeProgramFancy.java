package S1;
// Aaron Wu

import java.util.Scanner;

public class ChangeProgramFancy {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double cost = 0;
        double paid = 0;

        try {
            System.out.println("Enter Cost to 2 Decimal Places");
            cost = in.nextDouble();
        } catch (Exception e) {
            System.out.println(
                    "Try again, enter only numbers to 2 Decimal Places" + "\n" + "The Program will now terminate");
            System.exit(1);
        }

        try {
            System.out.println("Enter Amount Paid to 2 Decimal Places");
            paid = in.nextDouble();
        } catch (Exception e) {
            System.out.println(
                    "Try again, enter only numbers to 2 Decimal Places" + "\n" + "The Program will now terminate");
            System.exit(1);
        }

        in.close();

        double change = paid - cost;
        int chpennies = (int) (change * 100);
        int remainder;

        int fifties = chpennies / 5000;
        remainder = chpennies % 5000;

        int twenties = remainder / 2000;
        remainder = remainder % 2000;

        int tens = remainder / 1000;
        remainder = remainder % 1000;

        int fives = remainder / 500;
        remainder = remainder % 500;

        int ones = remainder / 100;
        remainder = remainder % 100;

        int quarters = remainder / 25;
        remainder = remainder % 25;

        int dimes = remainder / 10;
        remainder = remainder % 10;

        int nickles = remainder / 5;
        int pennies = remainder % 5;

        System.out.println("\n" + "Cost of Items : $" + cost + "\n" + "Amount Paid : $" + paid + "\n"
                + "Amount of Change : $" + change + "\n");
        System.out.println("Number of $50 Bills : " + fifties + "\n" + "Number of $20 Bills : " + twenties + "\n"
                + "Number of $10 Bills : " + tens + "\n" + "Number of $5 Bills : " + fives + "\n"
                + "Number of $1 Bills : " + ones + "\n" + "Number of Quarters : " + quarters + "\n"
                + "Number of Dimes : " + dimes + "\n" + "Number of Nickels : " + nickles + "\n" + "Number of Pennies : "
                + pennies);

    }
}
