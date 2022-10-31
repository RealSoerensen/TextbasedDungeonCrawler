package zuulGame.Items.Weapons;

import java.util.Random;

import zuulGame.Items.Weapon;

public class Dagger implements Weapon {
    private int minDamage;
    private int maxDamage;

    public Dagger(int multiplier) {
        minDamage = multiplier + 6;
        maxDamage = multiplier + 6;
    }

    @Override
    public int attack() {
        Random rnd = new Random();
        return rnd.nextInt(minDamage, maxDamage);
    }

    @Override
    public String getName() {
        return "Dagger";
    }

    @Override
    public int getMinDamage() {
        return minDamage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }
}
