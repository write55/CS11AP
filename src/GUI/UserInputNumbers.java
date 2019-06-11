package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i = Integer.parseInt(br.readLine());

		int random = 1 + (int) (Math.random() * (10));

		if (i > 10) {
			System.out.println("Input Must be Less than 10");
		}
		if (i == random) {
			System.out.println("Correct");
		} else {
			System.out.println("Incorrect");
		}

	}

}
