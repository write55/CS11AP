package S2;

/**
 * This is a class that tests the S2.Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the S2.Deck operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        String[] ranks = {"jack", "queen", "king"};
        String[] suits = {"blue", "red"};
        int[] pointValues = {11, 12, 13};
        Deck d = new Deck(ranks, suits, pointValues);

        System.out.println("**** Original S2.Deck Methods ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a S2.Card ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

        System.out.println("**** S2.Deck Methods After 1 S2.Card Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal Remaining 5 Cards ****");
        for (int i = 0; i < 5; i++) {
            System.out.println("  deal: " + d.deal());
        }
        System.out.println();
        System.out.println();

        System.out.println("**** S2.Deck Methods After All Cards Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a S2.Card From Empty S2.Deck ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

        String[] ranks2 = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits2 = {"Spades", "Diamonds", "Clubs", "Hearts"};
        int[] points2 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Deck d2 = new Deck(ranks2, suits2, points2);
        for (int i = 0; i < 5; i++) {
            System.out.println(d2.toString());
            d2.shuffle();
        }
    }
}
