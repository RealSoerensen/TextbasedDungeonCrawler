package zuulGame.Items.Potions;

import zuulGame.Items.Potion;

public class HealthPotion implements Potion {
	private int health;

	public HealthPotion(int multiplier) {
		health = multiplier + 15;
	}

	@Override
	public int getIncrease() {
		return health;
	}

	@Override
	public String getName() {
		return "Health Potion";
	}

	@Override
	public String getDescription() {
		return "Heals you for " + getIncrease() + " health.";
	}
}
