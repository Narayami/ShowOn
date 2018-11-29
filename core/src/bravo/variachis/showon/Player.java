package bravo.variachis.showon;

public class Player  {

    private int health;
    private Item[] items;


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
}
