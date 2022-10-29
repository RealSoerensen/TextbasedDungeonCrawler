package zuulGame.Inventory.Weapons;

import java.util.Random;

public class Sword implements Weapon {
    private int minDamage;
    private int maxDamage;

    public Sword(int multiplier) {
        minDamage = multiplier + 8;
        maxDamage = multiplier + 10;
    }

    /**
     * @return damage multiplied by a random number between 1 and 5.
     */
    public int attack() {
        Random rnd = new Random();
        return rnd.nextInt(minDamage, maxDamage);
    }

    @Override
    public int getMinDamage() {
        return minDamage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public String getName() {
        return "Sword";
    }
}
