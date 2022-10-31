package zuulGame.Items.Potions;

import zuulGame.Items.Potion;

public class AttackPotion implements Potion {
	private int attack;

	public AttackPotion(int multiplier) {
		attack = multiplier + 3;
	}

	@Override
	public int getIncrease() {
		return attack;
	}

	@Override
	public String getName() {
		return "Attack Potion";
	}

	@Override
	public String getDescription() {
		return "Increases your attack by " + getIncrease() + ".";
	}
}