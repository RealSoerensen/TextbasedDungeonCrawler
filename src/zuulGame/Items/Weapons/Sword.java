package zuulGame.Items.Weapons;

import java.util.Random;

import zuulGame.Items.Weapon;

public class Sword implements Weapon {
    private int minDamage;
    private int maxDamage;

    public Sword(int multiplier) {
        minDamage = multiplier + 5;
        maxDamage = multiplier + 7;
    }

    @Override
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
