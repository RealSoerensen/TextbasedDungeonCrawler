package zuulGame.Potions;

public class AttackPotion {
	private int attack;

	public AttackPotion(int multiplier) {
		attack = multiplier + 10;
	}

	public int drinkPotion() {
		return attack;
	}
}