package zuulGame.Potions;

public class Potions {
	private HealthPotion healthPotion;
	private AttackPotion attackPotion;

	public Potions(HealthPotion healthPotion) {
		this.healthPotion = healthPotion;
	}

	public Potions(AttackPotion attackPotion) {
		this.attackPotion = attackPotion;
	}

	public HealthPotion getHealthPotion() {
		return healthPotion;
	}

	public AttackPotion getAttackPotion() {
		return attackPotion;
	}

	public String getPotionType() {
		if (healthPotion != null) {
			return "Health Potion";
		} else {
			return "Attack Potion";
		}
	}
}
