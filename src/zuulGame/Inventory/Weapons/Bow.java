package zuulGame.Inventory.Weapons;

import java.util.Random;

public class Bow implements Weapon {
    private int minDamage;
    private int maxDamage;

    public Bow(int multiplier) {
        minDamage = multiplier + 5;
        maxDamage = multiplier + 15;
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
        // TODO Auto-generated method stub
        return "Bow";
    }

}
