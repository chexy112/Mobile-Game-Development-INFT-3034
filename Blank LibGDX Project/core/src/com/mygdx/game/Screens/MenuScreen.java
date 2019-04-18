package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.BricksGame;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreen implements Screen {
    private BricksGame game;
    private Skin skin;
    private Stage stage;
    private TextButton playButton, exitButton;

    public MenuScreen(BricksGame game){

        this.game = game;

    }

    public void create() {

        skin = new Skin(Gdx.files.internal("gui/uiskin.json"));
        stage = new Stage();

        //creating play button
        playButton = new TextButton("PLAY", skin, "default");
        playButton.setWidth(200f);
        playButton.setHeight(200f);
        playButton.setPosition(Gdx.graphics.getWidth() /2 - playButton.getWidth(),
                Gdx.graphics.getHeight()/2 - 10f);

        //creating exit button
        exitButton = new TextButton("EXIT", skin, "default");
        exitButton.setWidth(200f);
        exitButton.setHeight(200f);
        exitButton.setPosition(Gdx.graphics.getWidth() /2 , Gdx.graphics.getHeight()/2 - 10f);

        stage.addActor(playButton);
        stage.addActor(exitButton);


        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        stage.draw();
        //play button takes us to play screen
        if (playButton.isPressed()) game.setScreen(new PlayScreen(game));
        //exit button exits programme
        if (exitButton.isPressed()) Gdx.app.exit();
        game.batch.end();

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
        game.dispose();
        stage.dispose();
        skin.dispose();
    }
}
