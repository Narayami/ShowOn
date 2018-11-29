package bravo.variachis.showon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


public class ShowOn extends Game {
    private static final float SPEED = 200;
    private SpriteBatch batch;
    private Texture playerImg;
    private Rectangle player;
    private OrthographicCamera camera;
    private TiledMap map;
    private TiledMapRenderer mapRenderer;

    private int objectLayerId = 5;


    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        map = new TmxMapLoader().load("core/assets/basemap.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        playerImg = new Texture(Gdx.files.internal("smallRect.jpg"));

        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 15;
        player.height = 15;


    }

    @Override
    public void render() {

        //bg color
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        camera.update();

        mapRenderer.setView(camera);
        mapRenderer.render();


        batch.begin();
        batch.draw(playerImg, player.x, player.y);
        batch.end();


        //player movement
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


        TiledMapTileLayer collisionObjectLayer = (TiledMapTileLayer)map.getLayers().get(1);
        MapObjects objects = collisionObjectLayer.getObjects();

        // there are several other types, Rectangle is probably the most common one
        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {

            Rectangle rectangle = rectangleObject.getRectangle();
            if (Intersector.overlaps(rectangle, player)) {
                // collision happened
            }
        }

    }

    @Override
    public void dispose() {
        playerImg.dispose();
        batch.dispose();
    }
}
