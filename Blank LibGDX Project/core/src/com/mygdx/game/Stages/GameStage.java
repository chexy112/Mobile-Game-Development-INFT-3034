package com.mygdx.game.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actors.Ball;
import com.mygdx.game.Actors.Brick;
import com.mygdx.game.Actors.Paddle;
import com.mygdx.game.BricksGame;

import java.util.ArrayList;


public class GameStage extends Stage {

    private Group group;
    private Ball ball;
    private Paddle paddle;
    private ArrayList<Brick> brickList;
    private int preX;

    public GameStage(TextureAtlas atlas){

        //creating group to store all actors
        group = new Group();
        Gdx.gl20.glLineWidth(4);
        group.setDebug(true);
        group.setWidth(BricksGame.V_WIDTH);
        group.setHeight(BricksGame.V_HEIGHT);

        //put group in stage
        addActor(group);

        //set up ball actor
        ball = new Ball(atlas);
        paddle = new Paddle(atlas);
        brickList = new ArrayList<Brick>();

        for (int i = 0; i < 80; i++){
            Brick brick = new Brick(atlas, i);
            brickList.add(brick);
        }


        Gdx.app.log("MyGdxGame: "," ball width: " + ball.getWidth());

        group.addActor(ball);
        group.addActor(paddle);
        for (Brick each : brickList){

            group.addActor(each);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        preX = screenX;
        return super.touchDown(screenX, screenY, pointer, button);
    }


    //move paddle
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float dX = (screenX - preX) * getViewport().getWorldWidth() / getViewport().getScreenWidth();

        paddle.move(dX);
        return super.touchDragged(screenX, screenY, pointer);
    }

}
