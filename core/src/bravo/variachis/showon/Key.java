package bravo.variachis.showon;

import com.badlogic.gdx.graphics.Texture;

public class Key extends Item {

    private Texture texture;
    private boolean locked;

    public Key(Texture texture) {
        this.texture = texture;

    }

    public Texture getTexture() {
        return texture;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
