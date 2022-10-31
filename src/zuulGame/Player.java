package zuulGame;

import zuulGame.Items.Potion;
import zuulGame.Items.Weapon;
import zuulGame.Items.Potions.AttackPotion;
import zuulGame.Items.Potions.HealthPotion;
import zuulGame.Items.Potions.MixedPotion;

public class Player {
	private String name;
	private int hp;
	private int maxHp;
	private Weapon weapon;
	private int baseDamage;
	private int level;
	private int exp;
	private int expCap;
	private Inventory inventory;

	/**
	 * Initialize the player object.
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		inventory = new Inventory();
		baseDamage = 7;
		weapon = null;
		hp = 10;
		maxHp = hp;
		level = 1;
		exp = 1;
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
		maxHp = getMaxHp();
		if (newHp > maxHp) {
			hp = maxHp;
		} else {
			hp = newHp;
		}
	}

	/**
	 * @return players max hp
	 */
	public int getMaxHp() {
		return maxHp;
	}

	/**
	 * Set players max hp
	 * 
	 * @param newMaxHp
	 */
	public void setMaxHp(int newMaxHp) {
		maxHp = newMaxHp;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public void increaseDmg(int dmgChange) {
		baseDamage += dmgChange;
	}

	public void setWeapon(Weapon newWeapon) {
		if (weapon != null) {
			inventory.addItem(weapon);
		}
		weapon = newWeapon;
		inventory.removeItem(weapon);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public int getExp() {
		return exp;
	}

	/**
	 * Set gained exp
	 * If exp is above the threshold the level will increase
	 * 
	 * @param amount of exp gained
	 */
	public void setExp(int amount) {
		exp += amount;
		if (exp >= expCap) {
			levelUp();
		}
	}

	public int getExpCap() {
		return expCap;
	}

	public void setExpCap(int newCap) {
		expCap = newCap;
	}

	public int getLevel() {
		return level;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void addToInventory(Object item) {
		inventory.addItem(item);
	}

	public void removeFromInventory(Object item) {
		inventory.removeItem(item);
	}

	public void levelUp() {
		level++;
		setMaxHp(getMaxHp() + 5);
		setHp(getMaxHp());
		increaseDmg(2);
		setExpCap(level * 100);
		expCap = getExpCap();
		if (exp > expCap) {
			exp -= expCap;
		}
	}

	public int attack() {
		if (weapon != null) {
			return weapon.attack() + getBaseDamage();
		} else {
			return getBaseDamage();
		}
	}

	public void drinkPotion(Potion potion) {
		if (potion instanceof HealthPotion) {
			setHp(hp + potion.getIncrease());
		} else if (potion instanceof AttackPotion) {
			increaseDmg(potion.getIncrease());
		} else if (potion instanceof MixedPotion) {
			setHp(hp + potion.getIncrease());
			increaseDmg(potion.getIncrease());
		}
		inventory.removeItem(potion);
	}

	public void printStats() {
		System.out.println("Name: " + getName());
		System.out.println("Level: " + getLevel());
		System.out.println("EXP: " + getExp() + "/" + getExpCap());
		System.out.println("HP: " + getHp() + "/" + getMaxHp());
		System.out.println("Damage: " + getBaseDamage());
		if (weapon != null) {
			System.out.println("Weapon: " + weapon.getName());
			System.out.println("Weapon Damage: " + weapon.getMinDamage() + "-" + weapon.getMaxDamage());
		} else {
			System.out.println("Weapon: None");
		}
	}
}
