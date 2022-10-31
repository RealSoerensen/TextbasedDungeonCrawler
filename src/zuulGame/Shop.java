package zuulGame;

import java.util.ArrayList;
import java.util.Random;

import zuulGame.Items.Potion;
import zuulGame.Items.Weapon;
import zuulGame.Items.Potions.AttackPotion;
import zuulGame.Items.Potions.HealthPotion;
import zuulGame.Items.Potions.MixedPotion;
import zuulGame.Items.Weapons.Bow;
import zuulGame.Items.Weapons.Dagger;
import zuulGame.Items.Weapons.Sword;

public class Shop {
    private ArrayList<Object> shopInventory;
    private int multiplier;
    Potion allPotions[] = { new HealthPotion(multiplier), new AttackPotion(multiplier),
            new MixedPotion(multiplier) };
    Weapon allWeapons[] = { new Sword(multiplier), new Bow(multiplier), new Dagger(multiplier) };

    /**
     * @param multiplier
     */
    public Shop(int multiplier) {
        this.multiplier = multiplier;
        shopInventory = new ArrayList<Object>();
        for (int i = 0; i < 5; i++) {
            shopInventory.add(getRandomObject());
        }
    }

    public ArrayList<Object> getShopInventory() {
        return shopInventory;
    }

    public void buyItem(Object item) {
        for (Object itemInShop : shopInventory) {
            if (itemInShop.equals(item)) {
                shopInventory.remove(itemInShop);
                return;
            }
        }
    }

    public void sellItem(Object item) {
        shopInventory.add(item);
    }

    public Object getRandomObject() {
        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            return allPotions[rnd.nextInt(allPotions.length)];
        } else {
            return allWeapons[rnd.nextInt(allWeapons.length)];
        }
    }

}
