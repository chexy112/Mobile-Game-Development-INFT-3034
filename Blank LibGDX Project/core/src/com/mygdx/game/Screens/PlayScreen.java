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

    //box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;

    private Group group;


    public PlayScreen(BricksGame game){
        atlas = new TextureAtlas(Gdx.files.internal("breakout_pieces.atlas"));

        this.game = game;


    }

    public void create(){
//        bricks = new Array<Brick>();
//        paddle = new Paddle(atlas);
//
//        stage.addActor(paddle);

//        brick = new Brick(atlas);
//        for (int i = 0; i < BricksGame.V_WIDTH / brick.getWidth()+1; i++){
//            Brick brick = new Brick(atlas);
//            stage.addActor(brick);
//        }

        //create cam
        camera = new OrthographicCamera();

        //create a FitViewport
        viewport = new FitViewport(BricksGame.V_WIDTH,BricksGame.V_HEIGHT, camera);

        stage = new Stage(viewport, game.batch);

        //creating group to store all actors
        group = new Group();
        Gdx.gl20.glLineWidth(4);
        group.setDebug(true);
        group.setWidth(BricksGame.V_WIDTH);
        group.setHeight(BricksGame.V_HEIGHT);

        //put group in stage
        stage.addActor(group);

        //set up ball actor
        Ball ball = new Ball(atlas);
        Paddle paddle = new Paddle(atlas, world);


        Gdx.app.log("MyGdxGame: "," ball width: " + ball.getWidth());

        group.addActor(ball);
        group.addActor(paddle);

        //create HUD for scores
        hud = new Hud(game.batch);

        //load map and set up map renderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        //set initial game camera position

        camera.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);

        world = new World(new Vector2(0,0),true);
        b2dr = new Box2DDebugRenderer();

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

        world.step(1/60f,6,2);

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

    }
}
