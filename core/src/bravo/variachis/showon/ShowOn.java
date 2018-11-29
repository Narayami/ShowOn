package bravo.variachis.showon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class ShowOn extends Game {
    private static final float SPEED = 200;
    private SpriteBatch batch;
    private Texture playerImg;
    private Rectangle player;
    private OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        playerImg = new Texture(Gdx.files.internal("chartest.png"));

        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 64;
        player.height = 64;


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.begin();
        batch.draw(playerImg, player.x, player.y);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= SPEED * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += SPEED * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.y += SPEED * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.y -= SPEED * Gdx.graphics.getDeltaTime();
        }

    }

    @Override
    public void dispose() {
        playerImg.dispose();
        batch.dispose();
    }
}
