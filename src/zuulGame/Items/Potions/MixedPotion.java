package zuulGame.Items.Potions;

import zuulGame.Items.Potion;

public class MixedPotion implements Potion {
    private int increase;
    private String name;
    private String description;

    public MixedPotion(int multiplier) {
        increase = multiplier + 15;
    }

    @Override
    public int getIncrease() {
        return increase;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}