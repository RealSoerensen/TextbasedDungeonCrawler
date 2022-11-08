package zuulGame.Items.Potions;

import zuulGame.Items.Potion;

public class MixedPotion implements Potion {
    private int increase;

    public MixedPotion(int multiplier) {
        increase = multiplier + 15;
    }

    @Override
    public int getIncrease() {
        return increase;
    }

    @Override
    public String getName() {
        return "Mixed Potion";
    }

    @Override
    public String getDescription() {
        return "Heals you for " + getIncrease() + " health and increases your attack by " + getIncrease() + ".";
    }

    @Override
    public Object getType() {
        return this;
    }
}