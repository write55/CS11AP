/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        Card first = new Card("S", "Ace", 2);
        Card second = new Card("H", "Queen", 1);
        Card third = new Card("H", "Queen", 1);
        System.out.println(first.toString());
        System.out.println(first.suit() + first.rank() + first.pointValue());
        if (first.matches(second)) {
            System.out.println("First and second are the same");
        } else if (second.matches(third)) {
            System.out.println(second.toString());
        }
    }
}
