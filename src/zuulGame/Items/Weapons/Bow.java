package zuulGame.Items.Weapons;

import java.util.Random;

import zuulGame.Items.Weapon;

public class Bow implements Weapon {
    private int minDamage;
    private int maxDamage;

    public Bow(int multiplier) {
        minDamage = multiplier + 3;
        maxDamage = multiplier + 10;
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
    public int attack() {
        Random rnd = new Random();
        return rnd.nextInt(minDamage, maxDamage);
    }

    @Override
    public String getName() {
        return "Bow";
    }

}
