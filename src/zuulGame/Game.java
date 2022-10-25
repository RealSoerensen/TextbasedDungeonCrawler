package zuulGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import zuulGame.Potions.Potions;

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

	/**
	 * Initializing the game object
	 */
	public void init() {
		characterCreation();
		gameStart();
	}

	/**
	 * while-loop that continues while the players hp is above 0.
	 * For each loop the roundNum will increase and create a room with a higher
	 * multiplier to monster health and damage.
	 */
	public void gameStart() {
		int roundNum = 1;
		while (player.getHp() > 0) {
			int multiplier = roundNum / 2;
			room = new Room(multiplier);
			monster = room.getMonster();
			while (monster.getHp() > 0 && player.getHp() > 0) {
				battle();
			}
			System.out.println("The battle has ended...");
			if (player.getHp() > 0) {
				Potions drop = monster.genDrop();
				if (drop != null) {
					player.addToInventory(drop);
					System.out.println("The monster dropped a " + drop.getPotionType());
				}
				Random rnd = new Random();
				int newExp = player.getExp() + rnd.nextInt(20, 40);
				System.out.println("You gained " + (newExp - player.getExp()) + " exp!");
				player.setExp(newExp);
				roundNum++;
				System.out.println("Proceeding to level " + roundNum);
			}
		}
		System.out.println("You died... You reached round " + roundNum);
	}

	public static void battle() {
		System.out.println("Do you want to (attack) or (consume) a potion?");
		String choice = sc.nextLine();
		switch (choice) {
			case "attack":
				int playerHealth = player.getHp();
				int monsterHealth = monster.getHp();
				int playerDmg = player.attack();

				System.out.println("You dealt " + playerDmg + " to the monster.");
				monster.setHp(monsterHealth - playerDmg);
				System.out.println("The monster now have " + monster.getHp() + "hp");

				if (monster.getHp() >= 0) {
					int monsterDmg = monster.attack();

					System.out.println("The monster dealt " + monsterDmg);
					player.setHp(playerHealth - monsterDmg);
					System.out.println("You now have " + player.getHp() + "hp");
				}
				break;

			case "consume":
				ArrayList<Potions> playerInventory = player.getInventory();
				System.out.println("Enter a number to which item you want to use: ");
				for (Potions potion : playerInventory) {
					System.out.print(playerInventory.indexOf(potion) + ": " + potion.getPotionType());
				}
				System.out.println(playerInventory.size() + ": Back");
				choice = sc.nextLine();
				int newChoice = 0;
				try {
					newChoice = Integer.parseInt(choice);
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number");
					break;
				}
				if (newChoice == playerInventory.size()) {
					break;
				}
				Potions pickedPotion = playerInventory.get(newChoice);
				if (pickedPotion.getPotionType() == "Health Potion") {
					int restoreHp = pickedPotion.getHealthPotion().drinkPotion() + player.getHp();
					int newHp = 0;
					if (restoreHp > 10) {
						newHp = 10;
					} else {
						newHp = restoreHp;
					}
					player.setHp(newHp);
				} else if (pickedPotion.getPotionType() == "Attack Potion") {
					int newDmg = pickedPotion.getAttackPotion().drinkPotion() + player.getDmg();
					player.setDmg(newDmg);
				}
				break;

			default:
				System.out.println("I didn'tunderstand that. Type either 'consume' or 'attack'.");
		}

	}

	/**
	 * Create the players character.
	 */
	public static void characterCreation() {
		System.out.println("Enter your characters name: ");
		String name = sc.nextLine();
		player = new Player(name);
		System.out.println("Welcome " + player.getName() + "!");
	}
}
