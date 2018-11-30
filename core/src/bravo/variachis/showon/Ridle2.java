package bravo.variachis.showon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ridle2 implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont question;
    private BitmapFont answer;
    private Quest1 quest1;
    private GameScreenInterface screen;

    public Ridle2(GameScreenInterface screen){

        this.screen = screen;
    }


    @Override
    public void create() {

        batch = new SpriteBatch();
        question = new BitmapFont();
        answer = new BitmapFont();
        quest1 = new Quest1();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {


        /*renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        renderer.rect(220, -10, 450, 200);
        renderer.end();*/
        batch.begin();

        riddle1();
        //riddle2();
        //riddle3();

        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public void riddle1() {


        //batch.begin();
        if (!screen.getQuestResolved()) {
            question.draw(batch, "RIDDLE: The lyrics of the SHOW MUST GO ON refers to determination?\nT-True\nF-False", 250, 100);
            question.setColor(Color.WHITE);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.T)) {

            question.dispose();
            screen.setQuestResolved();
            answer.draw(batch, "Correct.", 250, 100);
            answer.setColor(Color.WHITE);
            //batch.end();
            //font.dispose();


        }

        if (Gdx.input.isKeyPressed(Input.Keys.F)) {

            question.dispose();
            screen.setQuestResolved();
            answer.draw(batch, "Incorrect, they do refer to determination.", 250, 100);
            answer.setColor(Color.WHITE);
        }

    /*public void riddle2(){


        //batch.begin();
        question.draw(batch, "RIDDLE: A TUA PRIMA É TOP?", 350, 100);
        question.setColor(Color.WHITE);

        if (Gdx.input.isKeyPressed(Input.Keys.T)) {


            question.dispose();
            quest1.setResolvedQuest();
            answer.draw(batch, "Ya it's fine", 350, 100);
            answer.setColor(Color.WHITE);
            //batch.end();
            //font.dispose();


        }
    }

    public void riddle3() {


        //batch.begin();
        question.draw(batch, "RIDDLE: A TUA PRIMA É BOA que morre?", 350, 100);
        question.setColor(Color.WHITE);

        if (Gdx.input.isKeyPressed(Input.Keys.T)) {


            question.dispose();
            showOn.setQuestResolved();
            answer.draw(batch, "Ya it's good", 350, 100);
            answer.setColor(Color.WHITE);
            //batch.end();
            //font.dispose();


        }*/
    }

}

