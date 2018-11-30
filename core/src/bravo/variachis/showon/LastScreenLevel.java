package bravo.variachis.showon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class LastScreenLevel implements Screen, GameScreenInterface {

    private Texture exitMenu;
    private ShowOn showOn;

    public LastScreenLevel(ShowOn showOn) {
        this.exitMenu = new Texture(Gdx.files.internal("exitmenu.png"));
        this.showOn = showOn;
    }

    @Override
    public void setQuestResolved() {

    }

    @Override
    public boolean getQuestResolved() {
        return false;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        showOn.getBatch().begin();
        showOn.getBatch().draw(exitMenu, 0, 0, 800, 600);
        if(Gdx.input.isKeyPressed(Input.Keys.Y)){

        System.exit(0);
        }

        showOn.getBatch().end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
