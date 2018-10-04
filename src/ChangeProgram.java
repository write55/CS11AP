// Aaron Wu

public class ChangeProgram {

    public static void main(String[] args) {

        double cost = 54.39;
        double paid = 100.00;

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

        System.out.println("Cost of Items : $" + cost + "\n" + "Amount Paid : $" + paid + "\n" + "Amount of Change : $"
                + change + "\n");
        System.out.println("Number of $50 Bills : " + fifties + "\n" + "Number of $20 Bills : " + twenties + "\n"
                + "Number of $10 Bills : " + tens + "\n" + "Number of $5 Bills : " + fives + "\n"
                + "Number of $1 Bills : " + ones + "\n" + "Number of Quarters : " + quarters + "\n"
                + "Number of Dimes : " + dimes + "\n" + "Number of Nickels : " + nickles + "\n" + "Number of Pennies : "
                + pennies);

    }
}

// Cost of Items : $54.39
// Amount Paid : $100.0
// Amount of Change : $45.61
//
// Number of $50 Bills : 0
// Number of $20 Bills : 2
// Number of $10 Bills : 0
// Number of $5 Bills : 1
// Number of $1 Bills : 0
// Number of Quarters : 2
// Number of Dimes : 1
// Number of Nickels : 0
// Number of Pennies : 1
