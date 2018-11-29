package bravo.variachis.showon;

public class Player {

    private int health;
    private Item[] items = new Item[5];


    public int getHealth() {
        return health;
    }

    public Item[] getItems() {
        return items;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = null;
                items[i].destroy();
                return true;
            }
        }
        return false;
    }
}
