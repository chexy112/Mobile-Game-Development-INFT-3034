package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.GL20;

public class MenuScreen implements Screen {

    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;

    MyGdxGame game; // Note it’s "MyGdxGame" not "Game"
    // constructor to keep a reference to the main Game class
    public MenuScreen(MyGdxGame game){
        this.game = game;
    }
    public void create() {


        Gdx.app.log("MenuScreen: ","menuScreen create");

        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("gui/uiskin.json"));
        stage = new Stage();

        final TextButton button = new TextButton("Click me", skin, "default");
        button.setWidth(600f);
        button.setHeight(400f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 10f);

        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);
    }
    public void render(float f) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.draw();
        batch.end();

        Gdx.app.log("MenuScreen: ","menuScreen render");
        Gdx.app.log("MenuScreen: ","About to call gameScreen");
        game.setScreen(MyGdxGame.gameScreen);
        Gdx.app.log("MenuScreen: ","gameScreen started");


    }
    @Override
    public void dispose() { }
    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void show() {
        Gdx.app.log("MenuScreen: ","menuScreen show called");
        create();
    }
    @Override
    public void hide() {
        Gdx.app.log("MenuScreen: ","menuScreen hide called");
    }
}