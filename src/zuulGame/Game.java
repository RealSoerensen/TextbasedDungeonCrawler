package zuulGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import zuulGame.Inventory.Potions.Potion;
import zuulGame.Inventory.Weapons.Weapon;

/**
 *
 * @author Patrick
 * 
 */
public class Game {
	static Player player;
	static Room room;
	static Monster monster;
	static Scanner sc = new Scanner(System.in);

	public Game(boolean load) {
		if (load) {
			// TODO: Load game
			characterCreation();
		} else {
			characterCreation();
		}
		gameStart();
	}

	/**
	 * while-loop that continues while the players hp is above 0.
	 * For each loop the roundNum will increase and create a room with a higher
	 * multiplier to monster health and damage.
	 */
	public void gameStart() {
		int roundNum = 1;
		System.out.println("Entering the dungeon, you see a monster in front of you.");
		while (player.getHp() > 0) {
			int multiplier = roundNum;
			room = new Room(multiplier);
			monster = room.getMonster();
			while (monster.getHp() > 0 && player.getHp() > 0) {
				battle();
			}
			System.out.println("The battle has ended.");
			if (player.getHp() > 0) {
				ArrayList<Object> drop = monster.generateDrop();
				for (Object item : drop) {
					player.addToInventory(item);
					System.out.println("You found a " + item.getClass().getSimpleName());
				}
				Random rnd = new Random();
				int gainedExp = rnd.nextInt(70, 100);
				System.out.println("You gained " + gainedExp + " exp!");
				player.setExp(gainedExp);
				roundNum++;
				postBattle();
			}
		}
		System.out.println("You died... \nYou reached round " + roundNum);
	}

	private static void battle() {
		System.out.println("\nMonster HP: " + monster.getHp() + "/" + monster.getMaxHp());
		System.out.println("Your HP: " + player.getHp() + "/" + player.getMaxHp());
		System.out.println("What do you want to do?");
		System.out.println("1. Attack");
		System.out.println("2. Open inventory");
		System.out.println("3. Stats");
		System.out.println("4. Save game");
		System.out.println("5. Exit game");
		System.out.print("> ");
		int choice = takeInput();
		System.out.println("\n");

		switch (choice) {
			case 1:
				int monsterHealth = monster.getHp();
				int playerDmg = player.attack();

				System.out.println("You dealt " + playerDmg + " to the monster.");
				monster.setHp(monsterHealth - playerDmg);
				System.out.println("The monster now have " + monster.getHp() + "hp");

				if (monster.getHp() > 0) {
					monsterAttack();
				}
				break;

			case 2:
				inventoryMenu();
				break;

			case 3:
				player.printStats();
				break;

			case 4:
				System.out.println("Saving game...");
				break;

			case 5:
				System.out.println("Exiting game...");
				System.exit(0);
				break;

			default:
				System.out.println("I didn'tunderstand that. Type either 'consume' or 'attack'.");
		}
	}

	private void postBattle() {
		boolean continueGame = false;
		while (!continueGame) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Proceed to next room");
			System.out.println("2. Open inventory");
			System.out.println("3. Stats");
			System.out.println("4. Save game");
			System.out.println("5. Exit game");
			System.out.print("> ");
			int choice = takeInput();
			System.out.println("\n");

			switch (choice) {
				case 1:
					continueGame = true;
					break;
				case 2:
					inventoryMenu();
					continue;
				case 3:
					player.printStats();
					continue;
				case 4:
					System.out.println("Saving game...");
					continue;
				case 5:
					System.out.println("Exiting game...");
					System.exit(0);
					continue;
				default:
					System.out.println("I didn't understand that. Please enter a valid number.");
			}
		}
	}

	private static void inventoryMenu() {
		ArrayList<Object> inventory = player.getInventory().getInventoryList();
		String name = "";
		int i = 1;
		for (Object item : inventory) {
			if (item instanceof Weapon) {
				name = ((Weapon) item).getName();
				int minDamage = ((Weapon) item).getMinDamage();
				int maxDamage = ((Weapon) item).getMaxDamage();
				System.out.println(i + ". " + name + " - " + minDamage + "-" + maxDamage + " damage");
			} else if (item instanceof Potion) {
				name = ((Potion) item).getName();
				String description = ((Potion) item).getDescription();
				System.out.println(i + ". " + name + " - " + description);
			}
			i++;
		}
		System.out.println(i + ". Back");
		System.out.print("> ");

		int choice = sc.nextInt();

		if (choice == inventory.size() + 1) {
			return;
		}

		Object item = inventory.get(choice - 1);
		if (item instanceof Weapon) {
			player.setWeapon((Weapon) item);
			System.out.println("You equipped " + ((Weapon) item).getName());
		} else if (item instanceof Potion) {
			player.drinkPotion((Potion) item);
			System.out.println("You consumed " + ((Potion) item).getName());
		}
		System.out.println("\n");
	}

	private static void monsterAttack() {
		int monsterDmg = monster.attack();
		int playerHealth = player.getHp();
		System.out.println("The monster dealt " + monsterDmg);
		player.setHp(playerHealth - monsterDmg);
		System.out.println("You now have " + player.getHp() + "hp\n");
	}

	/**
	 * Create the players character.
	 */
	private static void characterCreation() {
		System.out.println("Enter your characters name: ");
		String name = sc.nextLine();
		player = new Player(name);
		System.out.println("Welcome " + player.getName() + "!\n");

	}

	private static int takeInput() {
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid number.");
			sc.next();
			return takeInput();
		}
	}
}
