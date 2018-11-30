package bravo.variachis.showon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {

    private Texture mainMenu;
    private ShowOn showOn;

    public MainMenuScreen(ShowOn showOn){

        mainMenu = new Texture(Gdx.files.internal("mainmenu.png"));
        this.showOn = showOn;

    }

    @Override
    public void show() {



    }

    @Override
    public void render(float delta) {

        showOn.getBatch().begin();
        showOn.getBatch().draw(mainMenu, 0, 0 , 800, 600);
        showOn.getBatch().end();

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){

            showOn.setScreen(new GameScreen(showOn));
        }

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
