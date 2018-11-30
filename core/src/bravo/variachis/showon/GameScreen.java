package bravo.variachis.showon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen, GameScreenInterface {

    private static final float SPEED = 150;
    private SpriteBatch batch;
    private Texture moveDown, moveUp, moveRight, moveLeft;
    private Texture currentTexture;

    private Texture level2;

    private Riddle riddle;
    private MapObjects objects;

    private Rectangle player;
    private OrthographicCamera camera;
    private TiledMap map;
    private TiledMapRenderer mapRenderer;

    private Music bgMusic;

    private boolean questResolved = false;

    private Texture initialScreen;
    private ShowOn showOn;

    public GameScreen(ShowOn showOn ) {

        this.showOn = showOn;


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
    public void show() {
        batch = new SpriteBatch();

        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("queen.mp3"));
        bgMusic.setLooping(true);
        bgMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        moveDown= new Texture(Gdx.files.internal("moveDown.png"));
        moveUp= new Texture(Gdx.files.internal("moveUp.png"));
        moveRight= new Texture(Gdx.files.internal("moveRight.png"));
        moveLeft= new Texture(Gdx.files.internal("moveLeft.png"));

        initialScreen = new Texture(Gdx.files.internal("mainmenu.png"));

        currentTexture = moveDown;

        map = new TmxMapLoader().load("fineHouse.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);


        player = new Rectangle();
        player.x = 428;
        player.y = 220;
        player.width = moveDown.getWidth();
        player.height = moveDown.getHeight();



    }

    @Override
    public void render(float delta) {
        //bg color
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        camera.update();


        mapRenderer.setView(this.camera);

        mapRenderer.render();

        batch.begin();
        batch.draw(currentTexture, player.x, player.y);
        batch.end();


        move();

    }


    @Override
    public void dispose() {
        currentTexture.dispose();
        batch.dispose();
        map.dispose();
        bgMusic.dispose();
        objects = null;
    }

    public boolean checkMapColision() {
        //MapLayer collisionObjectLayer = map.getLayers().get("Tile Layer 1");
        objects = map.getLayers().get(1).getObjects();

        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();
            if (player.overlaps(rectangle)) { return true; }
        }
        return false;
    }


    public boolean interactiveItems(){
        MapObjects objects = map.getLayers().get(2).getObjects();

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)){

            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.overlaps(rectangle)){
                return  true;
            }
        }
        return false;
    }

    public boolean door1(){
        MapObjects objects = map.getLayers().get(3).getObjects();

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)){

            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.overlaps(rectangle)){
                return  true;
            }
        }
        return false;
    }



    public boolean object1(){
        MapObjects objects = map.getLayers().get(4).getObjects();

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)){

            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.overlaps(rectangle)){
                return  true;
            }
        }
        return false;
    }

    public boolean object2(){
        MapObjects objects = map.getLayers().get(5).getObjects();

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)){

            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.overlaps(rectangle)){
                return  true;
            }
        }
        return false;
    }

    public boolean object3(){
        MapObjects objects = map.getLayers().get(6).getObjects();

        for (RectangleMapObject rectangleMapObject : objects.getByType(RectangleMapObject.class)){

            Rectangle rectangle = rectangleMapObject.getRectangle();

            if(player.overlaps(rectangle)){
                return  true;
            }
        }
        return false;
    }



    private void move() {
        float playerOldX = player.x;
        float playerOldY = player.y;

        //player movement
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= SPEED * Gdx.graphics.getDeltaTime();
            batch.begin();
            batch.draw(moveLeft, player.x, player.y);
            currentTexture = moveLeft;
            System.out.println("x" + player.x + "y" + player.y );
            if(player.y < 200){
                System.out.println("oiasdoiasodasd");
            }
            batch.end();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += SPEED * Gdx.graphics.getDeltaTime();
            batch.begin();
            batch.draw(moveRight, player.x, player.y);
            currentTexture = moveRight;
            System.out.println("x" + player.x + "y" + player.y );
            if(player.y < 200){
                System.out.println("oiasdoiasodasd");
            }
            batch.end();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.y += SPEED * Gdx.graphics.getDeltaTime();
            batch.begin();
            batch.draw(moveUp, player.x, player.y);
            currentTexture = moveUp;
            System.out.println("x" + player.x + "y" + player.y );
            if(player.y < 200){
                System.out.println("oiasdoiasodasd");
            }
            batch.end();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.y -= SPEED * Gdx.graphics.getDeltaTime();
            batch.begin();
            batch.draw(moveDown, player.x, player.y);
            currentTexture = moveDown;
            System.out.println("x" + player.x + "y" + player.y );
            if(player.y < 200){
                System.out.println("oiasdoiasodasd");
            }
            batch.end();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            System.out.println(questResolved);
        }


        //collision walls
        if (checkMapColision()) {
            player.x = playerOldX;
            player.y = playerOldY;

        }

        if(interactiveItems()){
            //collision door
            if(questResolved == false){
                System.out.println("question false");
                player.x = playerOldX;
                player.y = playerOldY;
            }

            if(questResolved == true ){
                System.out.println("question True");

                showOn.setScreen(new ScreenSecondLevel(showOn, this));
                //this.dispose();

            }

        }





        if(object1()){

            this.riddle = new Riddle(this);
            batch.begin();
            riddle.create();
            riddle.render();
            batch.end();
        }

        if(object2()){

            BitmapFont message = new BitmapFont();
            batch.begin();
            message.draw(batch, "Freddy was here!", 250, 100);
            message.setColor(Color.WHITE);
            batch.end();
        }




    }

    public void setQuestResolved(){
        questResolved = true;
    }

    public boolean getQuestResolved(){
        return questResolved;
    }
}
