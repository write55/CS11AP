import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication {

	// CONSTANT
	public static final int max = 12;

	// PRIVATE DATA
	private int[][] array;

	// CONSTRUCTOR
	public Multiplication() {
		
	}

	// SETTER
	public void setArray(int[][] array) {
		this.array = array;
	}

	// ACTUAL STUFF
	// Returns array of proper dimensions
	public int[][] inputArray() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter Width: ");
		int width = Integer.parseInt(in.readLine());
		while (width > max) {
			System.out.print("Out of bounds, try again: ");
			width = Integer.parseInt(in.readLine());
		}
		System.out.print("\nEnter Height: ");
		int height = Integer.parseInt(in.readLine());
		while (height > max) {
			System.out.print("Out of bounds, try again: ");
			height = Integer.parseInt(in.readLine());
		}

		System.out.println("\nInput Complete");
		return new int[height][width];
	}

	// Fills each spot with product of position
	public void fillArray() {
		System.out.println("\nFilling Array...\n");
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = (row + 1) * (col + 1);
			}
		}
	}

	// Prints array with proper formatting
	public void printArray() {
		System.out.print("\t");
		for (int i = 0; i < array[0].length; i++) {
			System.out.print((i + 1) + "\t");
		}
		System.out.println();
		for (int i = 0; i < array[0].length * 8 + 4; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int row = 0; row < array.length; row++) {
			// Tab is 8 spaces, use separator here
			System.out.print((row + 1));
			// Loop for formatting
			for (int i = 0; i < 4 - ((row + 1) + " ").length(); i++) {
				System.out.print(" ");
			}
			System.out.print("|\t");
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		Multiplication table = new Multiplication();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Numbers Must be Integers <= 12");
		char sentinel = 'Y';
		while (sentinel != 'N') {
			table.setArray(table.inputArray());
			table.fillArray();
			table.printArray();
			System.out.println("\nContinue? (Y/N)");
			sentinel = in.readLine().toUpperCase().charAt(0);
		}
		System.out.println("\nProgram Complete");
	}
}

// OUTPUT - it looks better in the console
//
//Numbers Must be Integers <= 12
//
//Enter Width: 3
//
//Enter Height: 4
//
//Input Complete
//
//Filling Array...
//
//	1	2	3	
//----------------------------
//1  |	1	2	3	
//2  |	2	4	6	
//3  |	3	6	9	
//4  |	4	8	12	
//
//Continue? (Y/N)
//Y
//
//Enter Width: 12
//
//Enter Height: 10
//
//Input Complete
//
//Filling Array...
//
//	1	2	3	4	5	6	7	8	9	10	11	12	
//----------------------------------------------------------------------------------------------------
//1  |	1	2	3	4	5	6	7	8	9	10	11	12	
//2  |	2	4	6	8	10	12	14	16	18	20	22	24	
//3  |	3	6	9	12	15	18	21	24	27	30	33	36	
//4  |	4	8	12	16	20	24	28	32	36	40	44	48	
//5  |	5	10	15	20	25	30	35	40	45	50	55	60	
//6  |	6	12	18	24	30	36	42	48	54	60	66	72	
//7  |	7	14	21	28	35	42	49	56	63	70	77	84	
//8  |	8	16	24	32	40	48	56	64	72	80	88	96	
//9  |	9	18	27	36	45	54	63	72	81	90	99	108	
//10 |	10	20	30	40	50	60	70	80	90	100	110	120	
//
//Continue? (Y/N)
//N
//
//Program Complete
