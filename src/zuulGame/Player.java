package zuulGame;

import java.util.ArrayList;
import java.util.Random;

import zuulGame.Potions.Potions;

public class Player {
	private String name;
	private int hp;
	private int damage;
	private int level;
	private int exp;
	private int expCap;
	private ArrayList<Potions> inventory;

	/**
	 * Initialize the player object.
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		inventory = new ArrayList<Potions>(10);
		hp = 10;
		damage = 1;
		level = 1;
		exp = 0;
		expCap = level * 100;
	}

	/**
	 * @return players name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return players current hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Set players hp
	 * 
	 * @param newHp
	 */
	public void setHp(int newHp) {
		hp = newHp;
	}

	public void setAttack(int newDmg) {
		damage += newDmg;
	}

	/**
	 * Set gained exp
	 * If exp is above the threshold the level will increase
	 * 
	 * @param amount of exp gained
	 */
	public void setExp(int amount) {
		exp += amount;
		if (exp > expCap) {
			level++;
			exp -= 100;
			expCap = level * 100;
		}
	}

	public ArrayList<Potions> getInventory() {
		return inventory;
	}

	public void addToInventory(Potions potion) {
		inventory.add(potion);
	}

	public int getLevel() {
		return level;
	}

	/**
	 * @return damage multiplied by a random number between 1 and 5.
	 */
	public int attack() {
		Random rnd = new Random();
		return damage + rnd.nextInt(1, 5);
	}

	public int getExp() {
		return exp;
	}

	public int getDmg() {
		return damage;
	}

	public void setDmg(int newDmg) {
		damage = newDmg;
	}
}
