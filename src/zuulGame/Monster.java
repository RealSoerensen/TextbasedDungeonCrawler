package zuulGame;

import java.util.ArrayList;
import java.util.Random;

import zuulGame.Items.Item;
import zuulGame.Items.Potions.AttackPotion;
import zuulGame.Items.Potions.HealthPotion;
import zuulGame.Items.Potions.MixedPotion;
import zuulGame.Items.Weapons.Bow;
import zuulGame.Items.Weapons.Sword;

public class Monster {
	private int hp;
	private int maxHp;
	private int damage;
	private int multiplier;

	/**
	 * Creates Monster object with base hp and damage multiplied by the param.
	 * 
	 * @param multiplier
	 */
	public Monster(int multiplier) {
		this.multiplier = multiplier;
		hp = 10 + multiplier;
		maxHp = hp;
		damage = 1 + multiplier;
	}

	/**
	 * @return the current hp of the monster
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Set the monsters hp.
	 * 
	 * @param newHp
	 */
	public void setHp(int newHp) {
		hp = newHp;
	}

	public ArrayList<Item> generateDrop() {
		Random rnd = new Random();
		ArrayList<Item> drop = new ArrayList<Item>();
		int dropChance = rnd.nextInt(100);
		if (dropChance < 25) {
			drop.add(new HealthPotion(multiplier));
		} else if (25 <= dropChance && dropChance < 50) {
			drop.add(new AttackPotion(multiplier));
		} else if (50 <= dropChance && dropChance < 75) {
			drop.add(new MixedPotion(multiplier));
		} else if (75 <= dropChance && dropChance <= 100) {
			if (rnd.nextBoolean()) {
				drop.add(new Sword(multiplier));
			} else {
				drop.add(new Bow(multiplier));
			}
		}
		return drop;
	}

	/**
	 * @return damage multiplied by a random number between 0 and 4
	 */
	public int attack() {
		Random rnd = new Random();
		return damage + rnd.nextInt(0, 4) + multiplier;
	}

	public int getMaxHp() {
		return maxHp;
	}
}
