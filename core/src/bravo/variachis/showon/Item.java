package bravo.variachis.showon;

public abstract class Item implements Items {

    private boolean collected;
    private boolean used;

    @Override
    public Boolean isCollected() {
        return collected;
    }

    @Override
    public Boolean isUsed() {
        return used;
    }

    @Override
    public void destroy() {


    }
}
