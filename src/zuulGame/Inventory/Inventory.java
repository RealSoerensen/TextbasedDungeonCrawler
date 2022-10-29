package zuulGame.Inventory;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Object> inventory;

    public Inventory() {
        inventory = new ArrayList<Object>();
    }

    public ArrayList<Object> getInventoryList() {
        return inventory;
    }

    public void addItem(Object item) {
        inventory.add(item);
    }

    public void removeItem(Object item) {
        for (Object itemInInventory : inventory) {
            if (itemInInventory.equals(item)) {
                inventory.remove(itemInInventory);
                return;
            }
        }
    }
}
