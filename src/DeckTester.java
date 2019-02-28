/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		String[] ranks1 = { "jack", "queen", "king" };
		String[] suits1 = { "blue", "red" };
		int[] points1 = { 11, 12, 13 };
		Deck d = new Deck(ranks1, suits1, points1);
		System.out.println(d.toString());

		String[] ranks2 = { "2", "3", "4", "5", "Ace" };
		String[] suits2 = { "Diamonds", "Spades" };
		int[] points2 = { 2, 3, 4, 5, 11 };
		Deck d2 = new Deck(ranks2, suits2, points2);
		d2.deal();
		d2.deal();
		d2.deal();
		System.out.println(d2.toString());
		
		
		
		

	}

}
