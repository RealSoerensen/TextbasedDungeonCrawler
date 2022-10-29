package zuulGame;

import java.util.Scanner;

public class Main {

	/**
	 * Initializes the game object.
	 */
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("Welcome to Zuul!");
		System.out.println("Zuul is a new, incredibly boring adventure game.");
		System.out.println("Here are your options:");
		System.out.println("1. Continue");
		System.out.println("2. New game");
		System.out.println("3. Exit");
		try (Scanner sc = new Scanner(System.in)) {
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					new Game(true);
					break;

				case 2:
					new Game(false);
					break;

				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice");
					break;
			}
		}
	}
}
