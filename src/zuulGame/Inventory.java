package zuulGame;

import java.util.ArrayList;

import zuulGame.Items.Item;

public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }

    public ArrayList<Item> getInventoryList() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        for (Item itemInInventory : inventory) {
            if (itemInInventory.equals(item)) {
                inventory.remove(itemInInventory);
                return;
            }
        }
    }
}
