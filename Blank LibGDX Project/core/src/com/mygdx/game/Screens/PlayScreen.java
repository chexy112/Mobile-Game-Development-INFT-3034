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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Actors.Ball;
import com.mygdx.game.Actors.Brick;
import com.mygdx.game.Actors.Paddle;
import com.mygdx.game.BricksGame;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Scenes.Hud;


public class PlayScreen implements Screen {

    private BricksGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

//    private TextureAtlas atlas;
//    private Ball ball;
//    private Array<Brick> bricks;
//    private Brick brick;
//    private Paddle paddle;
//    private int score;
//    private Stage stage;

    //box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;


    public PlayScreen(BricksGame game){
//        atlas = new TextureAtlas("breakout_pieces.atlas");

        this.game = game;

        //create cam
        gameCam = new OrthographicCamera();

        //create a FitViewport
        gamePort = new FitViewport(BricksGame.V_WIDTH,BricksGame.V_HEIGHT, gameCam);

        //create HUD for scores
        hud = new Hud(game.batch);

        //load map and set up map renderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        //set initial game camera position

        gameCam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

        world = new World(new Vector2(0,0),true);
        b2dr = new Box2DDebugRenderer();
    }

    public void create(){
//        ball = new Ball(atlas);
//        bricks = new Array<Brick>();
//        paddle = new Paddle(atlas);
//
//        stage = new Stage();
//        stage.addActor(ball);
//        stage.addActor(paddle);

//        brick = new Brick(atlas);
//        for (int i = 0; i < BricksGame.V_WIDTH / brick.getWidth()+1; i++){
//            Brick brick = new Brick(atlas);
//            stage.addActor(brick);
//        }

    }

    @Override
    public void show() {
        create();
    }

    public void handleInput(float dt){
//        if (Gdx.input.isTouched()){
//            float xInc = (paddle.getX()+100)*dt;
//            float yInc = (paddle.getY()+100)*dt;
//
//            paddle.setPosition(xInc, yInc);
//
//        }

    }

    public void update(float dt){
        handleInput(dt);

        gameCam.update();
        renderer.setView(gameCam);

    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

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
