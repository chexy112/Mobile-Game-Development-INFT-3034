package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.BricksGame;


public class Paddle extends Actor {

    private TextureRegion paddleTextureRegion;

    public Paddle(TextureAtlas atlas){

        this.paddleTextureRegion = atlas.findRegion("paddle");
        create();
    }

    //create paddle
    private void create() {
        //setting paddle size
        setSize(paddleTextureRegion.getRegionWidth(), paddleTextureRegion.getRegionHeight());
        setBounds(BricksGame.V_WIDTH, BricksGame.V_HEIGHT, getWidth(), getHeight());
        setTouchable(Touchable.enabled);

        //set paddle initial position
        float initX = BricksGame.V_WIDTH / 2 - getWidth() / 2;
        float initY = 32 + getHeight()/2;
        setX(initX);
        setY(initY);
    }

    //create moving method for paddle
    public void move(float d) {
        float x = getX() + d;
        if (x > 0 && x < (BricksGame.V_WIDTH - getWidth())) {
            setX(x);
        }
    }


    @Override
    public void draw (Batch batch, float parentAlpha){
        batch.draw(paddleTextureRegion, getX(), getY());
    }
}
