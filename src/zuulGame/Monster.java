package zuulGame;

import java.util.Random;

import zuulGame.Potions.AttackPotion;
import zuulGame.Potions.HealthPotion;
import zuulGame.Potions.Potions;

public class Monster {
	private int hp;
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

	public Potions genDrop() {
		Random rnd = new Random();
		Potions returnPotion = null;
		if (rnd.nextBoolean()) {
			if (rnd.nextBoolean()) {
				returnPotion = new Potions(new HealthPotion(multiplier));
			} else {
				returnPotion = new Potions(new AttackPotion(multiplier));
			}
		}
		return returnPotion;
	}

	/**
	 * @return damage multiplied by a random number between 0 and 4
	 */
	public int attack() {
		Random rnd = new Random();
		return damage + rnd.nextInt(0, 4);
	}
}
