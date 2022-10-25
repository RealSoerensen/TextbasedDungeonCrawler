package zuulGame.Potions;

public class HealthPotion {
	private int health;

	public HealthPotion(int multiplier) {
		health = multiplier + 6;
	}

	public int drinkPotion() {
		return health;
	}

}
