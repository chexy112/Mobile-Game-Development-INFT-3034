package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BricksGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Scenes.Hud;


public class PlayScreen implements Screen {

    private BricksGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;
    private TextureAtlas atlas;
    public PlayScreen(BricksGame game){

        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(BricksGame.V_WIDTH,BricksGame.V_HEIGHT, gameCam);
        hud = new Hud(game.batch);
        atlas = new TextureAtlas("breakout_pieces.atlas");

    }

    public void create(){


    }

    @Override
    public void show() {
        create();
    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched()){
            gameCam.position.x += 100 * dt;
        }

    }

    public void update(float dt){
        handleInput(dt);

        gameCam.update();


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


    }

    @Override
    public void resize(int width, int height) {

        gamePort.update(width,height);
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
