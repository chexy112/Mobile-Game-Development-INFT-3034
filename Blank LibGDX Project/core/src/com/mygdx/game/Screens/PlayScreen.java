package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actors.Ball;
import com.mygdx.game.Actors.Paddle;
import com.mygdx.game.BricksGame;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Stages.GameStage;


public class PlayScreen implements Screen {

    private BricksGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private TextureAtlas atlas;

    private Stage stage;


    public PlayScreen(BricksGame game){
        atlas = new TextureAtlas(Gdx.files.internal("breakout_pieces.atlas"));

        this.game = game;


    }

    public void create(){
//        bricks = new Array<Brick>();
//        paddle = new Paddle(atlas);
//
//        stage.addActor(paddle);



        //create cam
        camera = new OrthographicCamera();

        //create a FitViewport
        viewport = new FitViewport(BricksGame.V_WIDTH,BricksGame.V_HEIGHT, camera);

        stage = new GameStage(atlas);
        stage.setViewport(viewport);

        //create HUD for scores
        hud = new Hud(game.batch);

        //load map and set up map renderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        //set initial game camera position

        camera.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);


    }

    @Override
    public void show() {
        create();
    }

    public void handleInput(float dt){
//        if (Gdx.input.isTouched()){
//
//            float screenX = Gdx.input.getDeltaX();
//        }

    }



    public void update(float dt){
        handleInput(dt);

        camera.update();
        renderer.setView(camera);

    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        hud.stage.draw();
        stage.draw();



    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width,height);
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
        hud.dispose();
    }
}
