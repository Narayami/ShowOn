package bravo.variachis.showon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import javax.swing.text.GapContent;

public class SecondLevel implements Screen {

    private Texture texture;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private ShapeRenderer renderer;


    public SecondLevel(){

        show();
    }


    @Override
    public void show() {

        spriteBatch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("library.png"));
        renderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);




    }

    @Override
    public void dispose(){

    }

    @Override
    public void render(float delta) {

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
}
